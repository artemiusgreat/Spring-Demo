FROM openjdk:18
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=demo", "-jar", "/app.jar"]