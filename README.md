# Task

### By completing this task, you will:
- Learn how to organize microservice interactions via RESTful API
- Learn how to work with the BFF (Backend-for-Frontend) pattern

### Tools and materials that will be useful for completing the task
- IntellijIDE
- HTTP client

### Task description
You need to create two microservices. They must have a REST API that will provide information to the BFF microservice. The BFF must receive a client request, call both microservices, collect the information received from the microservices into a single object, and return it to the client.

### Instructions
1. Create a microservice that stores user information.
- The information must be accessible via HTTP.
- Use RestController from spring-boot-starter-web.
- User information must be accessible via the GET /api/users/{userId} endpoint.
2. Create a microservice that stores user order information.
- The information must be accessible via http.
- Use RestController from spring-boot-starter-web.
- User order information must be accessible via the GET /api/orders/by-user/{user} endpoint.
3. Create a microservice that implements the BFF pattern.
- Information must be accessible via HTTP.
- Use RestController from spring-boot-starter-web.
- Information about the user's profile and orders must be accessible via the endpoint /api/site-bff/user/{userId}.
- When a request is received, the service must send a request to each of the microservices to obtain data, aggregate the received data, and return the result.
### Data models:
- For the User microservice, it must contain Id, full name, delivery address, phone number, email
- For the Order microservice, it must contain Id, UserId, order amount, order currency, list of items in the order
- For the BFF microservice, it is necessary to create a common data model that will contain information about both the user and their orders.

4. For testing
· You need to start all three microservices, send a request to BFF, and check the response.
· The BFF service should not store any data. Its task is to contact other services, receive data from them, aggregate it, and convert it into a convenient format for the end user.
