# Spring Boot-React-Starter

Basic Spring Boot + React application with JWT support. 
Includes login page and  user CRUD. As database, H2 is used.
 If you want to use another database (such as MySQL) then change dependencies in pom.xml.
 
The application is also ready for Heroku deployment -- procfile included.

# Setup is pretty simple.
- Clone the repository
- mvn clean install and mvn spring-boot:run
    - this will install all the dependencies you need


## Frontend development
- cd basic-frontend-app
- npm install 
- npm start


Based on: https://www.devglan.com/react-js/spring-boot-reactjs-crud-example and https://medium.com/analytics-vidhya/how-to-package-your-react-app-with-spring-boot-41432be974bc