# Blog Application Backend

A Spring Boot REST API for a blog application with user management and JWT authentication.

## Features

- **User Management** - CRUD operations with role-based access (ADMIN, AUTHOR, READER)
- **Blog Management** - CRUD operations for blog posts
- **JWT Authentication** - Token-based authentication and authorization
- **Role-Based Authorization** - Different permissions for different user roles
- **In-Memory Database** - H2 database for development

## Project Structure

```
src/main/java/com/blog/app/
├── annotation/
│   └── RequireRole.java          # Custom annotation for role-based auth
├── config/
│   ├── AuthInterceptor.java      # JWT validation interceptor
│   └── WebConfig.java            # Web configuration
├── controller/
│   ├── AuthController.java       # Authentication endpoints
│   ├── BlogController.java       # Blog CRUD endpoints
│   └── UserController.java       # User CRUD endpoints
├── model/
│   ├── Blog.java                 # Blog entity
│   ├── User.java                 # User entity with Role enum
│   ├── LoginRequest.java         # Login request DTO
│   └── LoginResponse.java        # Login response DTO
├── repository/
│   ├── BlogRepository.java       # In-memory blog storage
│   └── UserRepository.java       # In-memory user storage
├── service/
│   ├── BlogService.java          # Blog business logic
│   ├── UserService.java          # User business logic
│   └── JwtService.java           # JWT token operations
└── AppApplication.java           # Main application class
```

## API Endpoints

### Authentication
- `POST /api/auth/login` - User login (returns JWT token)
- `POST /api/auth/validate` - Validate JWT token

### Users
- `GET /api/users` - Get all users (ADMIN only)
- `GET /api/users/{id}` - Get user by ID
- `GET /api/users/username/{username}` - Get user by username
- `GET /api/users/email/{email}` - Get user by email
- `POST /api/users` - Create new user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user (ADMIN only)

### Blogs
- `GET /api/blogs` - Get all blogs
- `GET /api/blogs/{id}` - Get blog by ID
- `POST /api/blogs` - Create blog (ADMIN/AUTHOR only)
- `PUT /api/blogs/{id}` - Update blog (ADMIN/AUTHOR only)
- `DELETE /api/blogs/{id}` - Delete blog (ADMIN only)

## User Roles

- **ADMIN** - Full access to all operations
- **AUTHOR** - Can create and update blogs, manage own content
- **READER** - Can only read blogs and user information

## Authorization Matrix

| Endpoint | ADMIN | AUTHOR | READER | No Auth |
|----------|-------|--------|--------|---------|
| GET /api/blogs | ✓ | ✓ | ✓ | ✓ |
| POST /api/blogs | ✓ | ✓ | ✗ | ✗ |
| PUT /api/blogs | ✓ | ✓ | ✗ | ✗ |
| DELETE /api/blogs | ✓ | ✗ | ✗ | ✗ |
| GET /api/users | ✓ | ✗ | ✗ | ✗ |
| POST /api/users | ✓ | ✓ | ✓ | ✓ |
| DELETE /api/users | ✓ | ✗ | ✗ | ✗ |

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+

### Running the Application

1. Clone the repository
2. Navigate to project directory
3. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Sample Data

Create sample users using the provided Postman collections:

**Admin User:**
```json
{
  "username": "admin",
  "email": "admin@blog.com",
  "password": "admin123",
  "firstName": "Admin",
  "lastName": "User",
  "phone": "+1234567890",
  "role": "ADMIN",
  "active": true,
  "createdBy": "system"
}
```

**Author User:**
```json
{
  "username": "author1",
  "email": "author@blog.com",
  "password": "author123",
  "firstName": "John",
  "lastName": "Author",
  "phone": "+1234567891",
  "role": "AUTHOR",
  "active": true,
  "createdBy": "admin"
}
```

## Testing with Postman

Import the provided Postman collections:
- `Blog_API.postman_collection.json` - Blog operations
- `User_API.postman_collection.json` - User operations
- `Auth_API.postman_collection.json` - Authentication

### Authentication Flow

1. Create a user using `POST /api/users`
2. Login using `POST /api/auth/login` to get JWT token
3. Use the token in Authorization header: `Bearer <token>`
4. Access protected endpoints with the token

## JWT Token

- **Expiration:** 24 hours
- **Algorithm:** HS256
- **Claims:** username, role, issued date, expiration date

## Technologies Used

- **Spring Boot 3.x** - Main framework
- **Spring Web** - REST API
- **H2 Database** - In-memory database
- **JWT (jjwt)** - JSON Web Token implementation
- **Lombok** - Reduce boilerplate code
- **Jackson** - JSON processing

## Configuration

### Application Properties
```properties
# H2 Database (automatically configured)
# JWT settings are in JwtService.java
# Server runs on port 8080 by default
```

## Error Responses

### 401 Unauthorized
```json
{
  "error": "Missing or invalid token"
}
```

### 403 Forbidden
```json
{
  "error": "Insufficient permissions"
}
```

### 404 Not Found
```json
{
  "timestamp": "2024-12-02T10:30:00.000Z",
  "status": 404,
  "error": "Not Found",
  "path": "/api/blogs/999"
}
```

## Future Enhancements

### Security Enhancements
- **Password Hashing** - Use BCrypt to hash passwords instead of storing plain text
- **Input Validation** - Add @Valid annotations and validation constraints
- **Rate Limiting** - Add request rate limiting for login attempts

### API Improvements
- **Pagination** - Add pagination to GET all blogs/users endpoints
- **Search & Filter** - Add search by title, category, author for blogs
- **Soft Delete** - Instead of hard delete, add deleted flag
- **API Versioning** - Use /api/v1/ for future compatibility

### Database Migration
- **Replace In-Memory Storage** - Switch to JPA entities with H2/MySQL
- **Database Migrations** - Use Flyway or Liquibase for schema management

### Additional Features
- **File Upload** - Add endpoint for blog image uploads
- **Comments System** - Add comments model and CRUD operations
- **Categories Management** - Separate category entity with CRUD
- **User Profile** - Add profile picture, bio fields
- **Email Notifications** - Send emails for new blog posts

### Code Quality
- **Exception Handling** - Add global exception handler with @ControllerAdvice
- **Logging** - Replace System.out with proper logging (SLF4J)
- **Unit Tests** - Add test cases for services and controllers
- **Documentation** - Add Swagger/OpenAPI documentation

### Performance
- **Caching** - Add Redis caching for frequently accessed data
- **Async Processing** - Use @Async for email notifications

## License

This project is for educational purposes.