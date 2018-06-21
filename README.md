# Webshop: Spring Boot + OAuth2 + Vue.js

Example Webshop Application (Spring Boot, Hibernate, OAuth2, Vue.js)

# Getting startet
## Prerequisites:
- Gradle
- Docker (PostgreSQL)
- Webpack

## Run Application
**spring-boot-oauth2-backend: (localhost:8081)**  
- spring-boot-oauth2-backend/docker docker-compose up  
- Run Application.java  

**spring-boot-oauth2-frontend: (localhost:8080)**  
- npm init -y
- npm install --save-dev css-loader html-webpack-plugin vue-loader vue-style-loader vue-template-compiler webpack webpack-cli webpack-dev-server
- spring-boot-oauth2-frontend: npm run dev  

## Authentication
**Get Token:**  
curl itemis:secret@localhost:8081/oauth/token -d "grant_type=password&username=foo&password=bar"

## Accessing secured endpoints
curl -i -H "Accept: application/json" -H "Authorization: Bearer YOUR_TOKEN" -X GET http://localhost:8081/secured/products