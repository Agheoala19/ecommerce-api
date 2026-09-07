#  E-Commerce REST API (Spring Boot 3 & PostgreSQL)

A robust, enterprise-ready E-Commerce REST API built using modern **Java 17**, **Spring Boot 3**, and **Spring Security 6**. The application handles role-based authorization, inventory-controlled order processing with atomic database transactions, and persistent storage using PostgreSQL.

---

##  Key Features

* **Authentication & Authorization**: Stateless JWT (JSON Web Tokens) with distinct permissions for `ROLE_USER` and `ROLE_ADMIN`.
* **Catalog Management**: Full CRUD operations for Products and Categories with server-side pagination, sorting, and field-level Jakarta validation.
* **ACID Transactions**: Order placement engine protected by `@Transactional` ensuring atomic stock verification and rollback on insufficient inventory.
* **Global Error Handling**: Centralized exception interceptor (`@RestControllerAdvice`) returning standardized JSON error payloads.
* **Unit Testing**: Business logic covered by automated tests using **JUnit 5** and **Mockito**.
* **API Documentation**: Interactive documentation via **SpringDoc OpenAPI (Swagger UI)**.

---

##  Tech Stack

* **Language**: Java 17+
* **Framework**: Spring Boot 3.x
* **Security**: Spring Security 6, JJWT (HMAC-SHA256), BCrypt
* **Data & Persistence**: Spring Data JPA, Hibernate, PostgreSQL
* **Utilities**: Lombok, Jakarta Validation
* **Testing**: JUnit 5, Mockito, AssertJ
* **API Spec**: OpenAPI 3 / Swagger UI

---

##  API Endpoints

### Public / Authentication
| Method | Endpoint | Description | Access |
|---|---|---|---|
| `POST` | `/api/v1/auth/register` | Register new user account | Public |
| `POST` | `/api/v1/auth/login` | Authenticate and obtain JWT | Public |
| `GET` | `/api/v1/products` | Paginated product list | Public |
| `GET` | `/api/v1/products/{id}` | Get product details | Public |

### Admin Catalog Management
| Method | Endpoint | Description | Access |
|---|---|---|---|
| `POST` | `/api/v1/products` | Create new product | `ROLE_ADMIN` |
| `PUT` | `/api/v1/products/{id}` | Update product details/stock | `ROLE_ADMIN` |
| `DELETE`| `/api/v1/products/{id}` | Delete product | `ROLE_ADMIN` |

### Orders & Shopping
| Method | Endpoint | Description | Access |
|---|---|---|---|
| `POST` | `/api/v1/orders` | Place order (stock deduction) | Authenticated |
| `GET` | `/api/v1/orders/my-orders` | View user order history | Authenticated |

---

##  Getting Started

### Prerequisites
* JDK 17 or higher
* PostgreSQL 15+
* Maven 3.8+

### Setup & Run
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/your-username/ecommerce-api.git](https://github.com/your-username/ecommerce-api.git)
   cd ecommerce-api
