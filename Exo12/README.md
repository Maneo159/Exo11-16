# API de Gestion des Commandes

## Endpoints disponibles

### GET /api/orders
Retourne toutes les commandes de la base de données.

**Réponse:** Liste de toutes les commandes

---

### GET /api/orders/{id}
Retourne une commande spécifique par son ID.

**Paramètres:**
- `id` (Long) : Identifiant de la commande

**Réponse:** Objet Order avec les détails de la commande

---

### POST /api/orders
Crée une nouvelle commande avec le statut par défaut "PENDING".

**Corps de la requête:**
```json
{
  "customerName": "Jean Dupont",
  "totalAmount": 99.99,
  "status": "PENDING"
}
```

**Réponse:** Objet Order créé avec l'ID généré automatiquement

---

### PUT /api/orders/{id}
Met à jour le statut d'une commande existante.

**Paramètres:**
- `id` (Long) : Identifiant de la commande

**Corps de la requête:**
```json
{
  "status": "SHIPPED"
}
```

**Réponse:** Objet Order mis à jour

---

### DELETE /api/orders/{id}
Supprime une commande par son ID.

**Paramètres:**
- `id` (Long) : Identifiant de la commande

**Réponse:** Confirmation de la suppression

---

### GET /api/orders/search?status=SHIPPED
Recherche les commandes filtrées par statut.

**Paramètres:**
- `status` (String) : Statut à rechercher (PENDING, SHIPPED, DELIVERED)

**Réponse:** Liste des commandes avec le statut spécifié

---

### GET /api/orders/paged?page=0&size=5
Retourne les commandes paginées.

**Paramètres:**
- `page` (Integer) : Numéro de la page (commence à 0)
- `size` (Integer) : Nombre de résultats par page

**Réponse:** Page de commandes avec les résultats paginés

---

### GET /api/orders/customer/{customerName}
Retourne toutes les commandes d'un client spécifique.

**Paramètres:**
- `customerName` (String) : Nom du client

**Réponse:** Liste des commandes du client spécifié

---

## Propriétés de l'objet Order

- `id` (Long) : Identifiant unique généré automatiquement
- `customerName` (String) : Nom du client
- `totalAmount` (Double) : Montant total de la commande
- `status` (String) : Statut de la commande (PENDING, SHIPPED, DELIVERED)
- `createdAt` (LocalDateTime) : Date de création générée automatiquement

