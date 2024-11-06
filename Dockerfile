FROM maven:3.8.7 AS build
COPY . .
RUN mvn -B clean package -DskipTests

FROM openjdk:17
RUN apt-get update && apt-get install -y curl && \
    curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose && \
    chmod +x /usr/local/bin/docker-compose
COPY docker-compose.yml /docker-compose.yml
COPY --from=build target/*.jar register.jar
ENTRYPOINT ["java", "-jar", "register.jar", "--server.port=9090"]

