# Service de Gestion de Projets avec Authentification JWT

## Configuration et Installation

### Prérequis
- Java 17+
- Maven 3.8+
- Docker et Docker Compose (optionnel)

### Exécution locale

1. Compiler et packager l'application :
```bash
mvn clean package -DskipTests
```

2. Lancer l'application :
```bash
java -jar target/Exo15-0.0.1-SNAPSHOT.jar
```

L'application démarre sur le port 8080 par défaut.

### Exécution avec Docker

1. Construire l'image Docker :
```bash
docker build -t exo15-app .
```

2. Lancer avec Docker Compose :
```bash
docker-compose up
```

## Endpoints disponibles

### 1. Authentification - POST /api/auth/login

Authentifie un utilisateur et retourne un JWT token.

**Request :**
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"alice","password":"password123"}'
```

**Response (200 OK):**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGljZSIsImlhdCI6MTY3OTc0NjM4MCwiZXhwIjoxNjc5ODMyNzgwfQ...."
}
```

**Utilisateurs prédéfinis :**
- Username: `alice`, Password: `password123`
- Username: `bob`, Password: `password456`

### 2. Récupérer les projets - GET /api/projects

Récupère la liste des projets de l'utilisateur authentifié.

**Request :**
```bash
curl -X GET http://localhost:8080/api/projects \
  -H "Authorization: Bearer <YOUR_JWT_TOKEN>"
```

**Response (200 OK):**
```json
{
  "projects": [
    "Projet A",
    "Projet B"
  ]
}
```

**Response (401 Unauthorized):**
```json
{
  "error": "Unauthorized: Missing or invalid JWT token"
}
```

## Données initiales

L'application crée automatiquement les utilisateurs et projets suivants au démarrage :

### Utilisateurs
- **Alice** (password: password123)
  - Projet A : Premier projet d'Alice
  - Projet B : Deuxième projet d'Alice

- **Bob** (password: password456)
  - Projet C : Projet de Bob
  - Projet D : Autre projet de Bob

## Architecture

### Structure du projet

```
src/main/java/org/example/exo15/
├── Exo15Application.java          # Application principale
├── controller/
│   ├── AuthController.java         # Endpoint de login
│   └── ProjectController.java      # Endpoint des projets
├── service/
│   ├── AuthService.java            # Service d'authentification
│   ├── JwtService.java             # Service JWT
│   └── ProjectService.java         # Service des projets
├── entity/
│   ├── User.java                   # Entité utilisateur
│   └── Project.java                # Entité projet
├── repository/
│   ├── UserRepository.java         # Repository pour les utilisateurs
│   └── ProjectRepository.java      # Repository pour les projets
├── filter/
│   └── JwtFilter.java              # Filtre JWT pour valider les tokens
├── config/
│   └── FilterConfig.java           # Configuration des filtres
└── listener/
    └── DataInitializer.java        # Initialisation des données
```

## Dépendances principales

- **Spring Boot 4.0.3** : Framework web
- **Spring Data JPA** : ORM et accès aux données
- **H2 Database** : Base de données en mémoire
- **JJWT 0.12.3** : Gestion des JWT tokens

## Configuration

Les propriétés principales sont configurables dans `application.properties` :

```properties
# JWT
jwt.secret=ExerciceExo15JWTSecretKeyForAuthenticationServiceOfProjectManagement...
jwt.expiration=86400000  # 24 heures en millisecondes

# Base de données H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
```

## Flux d'authentification

1. L'utilisateur envoie ses identifiants au endpoint `/api/auth/login`
2. Le serveur valide les identifiants contre la base de données
3. Si valide, un JWT token est généré et retourné au client
4. Le client utilise ce token dans le header `Authorization: Bearer <token>` pour accéder aux endpoints protégés
5. Le filtre JWT (`JwtFilter`) valide le token pour chaque requête protégée

## Sécurité

- Les tokens JWT sont signés avec un secret HMAC-SHA256
- Les tokens expirent après 24 heures par défaut
- Tous les endpoints sauf `/api/auth/login` nécessitent un token JWT valide
- Les mots de passe sont stockés en clair (à améliorer en production avec bcrypt)

