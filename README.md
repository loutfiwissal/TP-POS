# TP1 :
## Product Management Branches
> The Product Management module is fully implemented and ready for integration testing.  
> You can now test all CRUD operations (`Create`, `Read`, `Update`, `Delete`) using the endpoints defined in `ProductController`.
> Once verified, this layer can be safely merged into the main branch.
> 
| Method | Endpoint |
|--------|----------|
| GET    | `/products` |
| GET    | `/products/{id}` |
| POST   | `/products` |
| PUT    | `/products/{id}` |
| DELETE | `/products/{id}` |
| DELETE | `/products` |

This section describes the purpose and content of each branch in the Product Management module of our Cafe project.

---

### Branch: `project-structure`
**Purpose:** Starter project setup.  
**Contains:**  
- Spring Boot project with all required dependencies.  
- Basic packages structure that will be used throughout the project.

---

### Branch: `product-entity`
**Purpose:** Product entity definition.  
**Contains:**  
- Product entity class with all fields.  
- Getters and setters for the fields.  
- Enum `Category` representing product categories.

---

### Branch: `product-dto`
**Purpose:** Data Transfer Objects for product.  
**Contains:**  
- `ProductDto` class.  
- `CreateProductDto` class.  
- These DTOs will be used in the Product Service.

---

### Branch: `product-repo`
**Purpose:** Product repository layer.  
**Contains:**  
- Spring Data JPA repository interface for Product entity.

---

### Branch: `product-service`
**Purpose:** Service layer for product operations.  
**Contains:**  
- Product service class with methods to handle business logic.  
- Methods that will be used by the controller layer.

---

### Branch: `product-controller`
**Purpose:** Controller layer for product API.  
**Contains:**  
- Product controller class with REST endpoints for product operations.

---

### Branch: `product-exception`
**Purpose:** Exception handling for product module.  
**Contains:**  
- Custom product exceptions (e.g., `ProductNotFoundException`, `ProductAlreadyExistException`).  
- Global exception handler (`ProductGlobalException`) for product-related exceptions.
