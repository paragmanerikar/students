FROM openjdk:19-ea-5-alpine3.15
ADD target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
