FROM openjdk:8
LABEL authors="83912"
COPY judger.jar /app/judger.jar
EXPOSE 8080
WORKDIR /app
ENTRYPOINT ["java", "-jar", "judger.jar"]