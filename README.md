# Nimap CRUD Application

A Spring Boot application implementing CRUD operations for Categories and Products with server-side pagination.

## Features

- **Spring Boot 3.2.0** with Java 17
- **JPA & Hibernate** for database operations
- **MySQL** as the relational database
- **RESTful APIs** with proper HTTP status codes
- **Server-side pagination** for both Categories and Products
- **One-to-Many relationship** between Category and Products
- **Validation** using Bean Validation annotations
- **Cross-Origin Resource Sharing (CORS)** enabled
- **Global Exception Handling**

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- MySQL 8.0 or higher

## Database Setup

1. Install MySQL if not already installed
2. Create a database named `nimap_db` (or update the application.properties)
3. Update the database credentials in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

## Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. The application will start on `http://localhost:8080`

## API Endpoints

### Categories

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/categories?page=0&size=10` | Get all categories with pagination |
| GET | `/api/categories/{id}` | Get category by ID |
| POST | `/api/categories` | Create a new category |
| PUT | `/api/categories/{id}` | Update category by ID |
| DELETE | `/api/categories/{id}` | Delete category by ID |

### Products

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products?page=0&size=10` | Get all products with pagination |
| GET | `/api/products/{id}` | Get product by ID (includes category details) |
| POST | `/api/products` | Create a new product |
| PUT | `/api/products/{id}` | Update product by ID |
| DELETE | `/api/products/{id}` | Delete product by ID |

## Request/Response Examples

### Create Category
```bash
POST /api/categories
Content-Type: application/json

{
    "name": "Electronics",
    "description": "Electronic devices and gadgets"
}
```

### Create Product
```bash
POST /api/products
Content-Type: application/json

{
    "name": "Laptop",
    "description": "High-performance laptop",
    "price": 999.99,
    "category": {
        "id": 1
    }
}
```

### Get Products with Pagination
```bash
GET /api/products?page=0&size=5
```

Response:
```json
{
    "content": [
        {
            "id": 1,
            "name": "Laptop",
            "description": "High-performance laptop",
            "price": 999.99,
            "category": {
                "id": 1,
                "name": "Electronics",
                "description": "Electronic devices and gadgets"
            }
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 5
    },
    "totalElements": 6,
    "totalPages": 2
}
```

## Project Structure

```
src/main/java/com/nimap/
├── NimapApplication.java          # Main Spring Boot application
├── controller/
│   ├── CategoryController.java    # REST controller for categories
│   └── ProductController.java     # REST controller for products
├── entity/
│   ├── Category.java              # Category entity
│   └── Product.java               # Product entity
├── repository/
│   ├── CategoryRepository.java    # Category repository
│   └── ProductRepository.java     # Product repository
├── service/
│   ├── CategoryService.java       # Category business logic
│   └── ProductService.java        # Product business logic
├── exception/
│   └── GlobalExceptionHandler.java # Global exception handler
└── config/
    └── DataLoader.java            # Initial data loader
```

## Testing the APIs

You can test the APIs using tools like:
- Postman
- cURL
- Any REST client

### Example cURL commands:

1. Get all categories:
```bash
curl -X GET "http://localhost:8080/api/categories?page=0&size=10"
```

2. Create a category:
```bash
curl -X POST "http://localhost:8080/api/categories" \
  -H "Content-Type: application/json" \
  -d '{"name":"Sports","description":"Sports equipment"}'
```

3. Get all products:
```bash
curl -X GET "http://localhost:8080/api/products?page=0&size=10"
```

## Features Implemented

✅ Spring Boot application  
✅ REST controllers  
✅ MySQL database configuration  
✅ Annotation-based configuration  
✅ JPA & Hibernate  
✅ Category CRUD operations  
✅ Product CRUD operations  
✅ One-to-Many relationship (Category-Products)  
✅ Server-side pagination  
✅ Product details include category information  
✅ Input validation  
✅ Global exception handling  
✅ CORS support  

## Notes

- The application automatically creates the database and tables on startup
- Initial sample data is loaded automatically
- Pagination is implemented with a default page size of 10
- All endpoints return appropriate HTTP status codes
- Validation errors are returned with detailed field-level messages
