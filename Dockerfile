FROM openjdk:8

ENV APP_NAME='application-0.0.1-SNAPSHOT'

WORKDIR /app

COPY target/${APP_NAME}.jar /app/spring-app.jar

ENTRYPOINT [ "java", "-jar", "spring-app.jar" ]
