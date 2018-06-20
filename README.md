# Webshop: Spring Boot + OAuth2 + Vue.js

Example Webshop Application (Spring Boot, Hibernate, OAuth2, Vue.js)

# Getting startet
## Prerequisites:
- Gradle
- Docker (PostgreSQL)
- Webpack     

## Run Application
**spring-boot-oauth2-backend:**  
spring-boot-oauth2-backend/docker docker-compose up  
Run Application.java  
localhost:8081  

**spring-boot-oauth2-frontend:**  
spring-boot-oauth2-frontend: npm run dev  
localhost:8080  

## Authentication
**Get Token:**  
*curl spring-security-oauth2-read-client:foo@localhost:8081/oauth/token -d "grant_type=password&username=foo&password=password"*

## Accessing secured endpoints
*curl -i -H "Accept: application/json" -H "Authorization: Bearer YOUR_TOKEN" -X GET http://localhost:8081/secured/clients*
