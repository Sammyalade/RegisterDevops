ARG DATABASE_URL
ARG DATABASE_USERNAME
ARG DATABASE_PASSWORD

FROM maven:3.8.7 AS build
COPY . .
RUN mvn -B clean package -DskipTests

FROM openjdk:17
COPY docker-compose.yml /docker-compose.yml
COPY --from=build target/*.jar register.jar
ENTRYPOINT ["java", "-jar", "register.jar", "--server.port=9090"]

