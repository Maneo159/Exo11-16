# Exo11 - API Réactive de Gestion des Utilisateurs

## Commandes API

### 1. Récupérer tous les utilisateurs
```
GET http://localhost:8080/api/users
```
Retourne la liste de tous les utilisateurs.

### 2. Récupérer un utilisateur par ID
```
GET http://localhost:8080/api/users/1
```
Retourne les détails d'un utilisateur spécifique.

### 3. Créer un nouvel utilisateur
```
POST http://localhost:8080/api/users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "active": true
}
```
Crée et retourne le nouvel utilisateur avec son ID généré.

### 4. Mettre à jour un utilisateur
```
PUT http://localhost:8080/api/users/1
Content-Type: application/json

{
  "name": "Jane Doe",
  "email": "jane.doe@example.com",
  "active": true
}
```
Met à jour et retourne l'utilisateur modifié.

### 5. Supprimer un utilisateur
```
DELETE http://localhost:8080/api/users/1
```
Supprime l'utilisateur de la base de données (retourne 204 No Content).

## Tests Complets

Consultez le fichier `tests.txt` pour tous les scénarios de test avec les requêtes et les réponses attendues.

