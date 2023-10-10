
#
# Build stage
#
FROM maven:3.8.1-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17-alpine
COPY --from=build /target/LogisticsDevServer-0.0.1-SNAPSHOT.jar logistics.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "logistics.jar"]