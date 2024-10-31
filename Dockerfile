FROM maven:3.8.7 AS build
COPY . .
RUN mvn -B clean package -DskipTests

FROM openjdk:17
RUN apt-get update && apt-get install -y postgresql postgresql-contrib && rm -rf /var/lib/apt/lists/*
COPY --from=build target/*.jar register.jar
EXPOSE 5432
EXPOSE 9090
CMD service postgresql start && java -jar register.jar --server.port=9090
