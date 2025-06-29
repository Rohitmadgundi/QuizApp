# Spring Boot Quiz App (Microservices Architecture)

## Modules
- `API-Gateway`: Acts as the gateway for routing and filtering.
- `QuestionApp`: Handles questions.
- `Quiz-App`: Manages quizzes.
- `Service-Registry`: Eureka server for service discovery.

## How to Run
1. Start `Service-Registry`
2. Start `QuestionApp` and `Quiz-App`
3. Start `API-Gateway`
4. Access APIs via gateway on port `8765`

## Tech Stack
- Spring Boot
- Spring Cloud Gateway
- Eureka(Server & Client)
- Maven
- Spring Web MVC
- Microservices
