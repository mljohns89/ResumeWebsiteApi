#Specify the jdk.  It is standard in docker to use the open jdk.  See:  https://hub.docker.com/_/openjdk/
FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE
COPY ${JAR_FILE} app.jar


EXPOSE 9000

CMD ["java", "-jar", "/app.jar", "-Xmx128m"]