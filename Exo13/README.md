# API de gestion des produits avec stock

## Endpoints

### GET /api/products
Retourne tous les produits de la base de données.

### GET /api/products/{id}
Retourne un produit spécifique par son ID.

### POST /api/products
Crée un nouveau produit.
Body JSON requis :
```json
{
  "name": "Nom du produit",
  "price": 100.0,
  "stock": 10
}
```

### PUT /api/products/{id}
Met à jour les informations d'un produit (nom, prix, stock).
Body JSON requis :
```json
{
  "name": "Nom mis à jour",
  "price": 120.0,
  "stock": 8
}
```

### PUT /api/products/{id}/buy?quantity=5
Réduit le stock d'un produit après un achat. Retourne une erreur si la quantité dépasse le stock disponible.

### GET /api/products/search?name=phone
Recherche des produits par nom (recherche partielle et insensible à la casse).

### DELETE /api/products/{id}
Supprime un produit de la base de données.

