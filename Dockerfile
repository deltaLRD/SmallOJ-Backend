FROM openjdk:17
LABEL authors="83912"
COPY ./target/SmallOJ-Backend-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]