FROM maven:3.8.7 AS build
COPY . .
RUN mvn -B clean package -DskipTests

FROM openjdk:17
COPY --from=build target/*.jar register.jar
ENTRYPOINT ["java", "-jar", "register.jar", "--server.port=9090"]

FROM sammyalade/register:latest
RUN apt-get update && \
    apt-get install -y \
    curl \
    lsb-release \
    && curl -sSL https://get.docker.com/ | sh \
    && curl -L https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(lsb_release -cs)-$(uname -m) -o /usr/local/bin/docker-compose \
    && chmod +x /usr/local/bin/docker-compose
RUN docker-compose --version