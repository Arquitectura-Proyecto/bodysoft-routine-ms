FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/routine-ms-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8443
ENTRYPOINT ["java","-jar","/app.jar"]