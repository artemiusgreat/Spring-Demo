# Spring API Setup

- mvn clean install 
- nvm package 
- docker build --tag=spring-demo:latest . 
- docker run -p 8080:8080 spring-demo:latest

# Endpoints 

- GET /api/v1/users
- GET /api/v1/users/<id>
- POST /api/v1/users/save
