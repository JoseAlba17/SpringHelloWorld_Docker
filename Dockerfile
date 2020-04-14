FROM maven:3.6.3-jdk-8 as builder
RUN mkdir /app
WORKDIR /app
COPY . .
RUN mvn package
RUN mv /app/target/*.jar /app/app.jar
FROM openjdk:8-jdk-alpine
COPY --from=builder /app/app.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
