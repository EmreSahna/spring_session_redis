FROM maven:3.8.4-openjdk-17 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN mvn dependency:go-offline

COPY src src
RUN mvn package -DskipTests

FROM openjdk:17
WORKDIR register-app
COPY --from=build target/*.jar register-app.jar
ENTRYPOINT ["java", "-jar", "register-app.jar"]