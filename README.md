# Person API Digital Innovation One Project
<h3>Project created to follow DIO bootcamp, this projects uses Spring Boot to
implement an API with person CRUD operations and a
repository built using H2.</h3>
<hr>

This project explores several concepts including:
    
- MVC pattern
- REST API
- CRUD operations
- DTO for Data Conversion and Single Responsibility Principle Compliance
- MapStruct for DTO to Entity and vice-versa for convention over configuration mapping
- Git Flow and Conventional Commits tools for code versioning
- etc...

<hr>

The person API have the following endpoints:
- GET /api/v1/people  
    Lists all people currently persisted in the repository.
- GET /api/v1/people/{id}  
    Retrieves one person object by id.
- POST /api/v1/people  
    Creates a new person on the repository.
- PUT /api/v1/people/{id}  
    Updates a person by id. Replaces the entire object.
- DELETE /api/v1/people/{id}  
    Deletes a person by id.
    
    
