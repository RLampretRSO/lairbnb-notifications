FROM openjdk:8-jre-alpine

WORKDIR /app

ADD ./api/target/notifications-api-1.0-SNAPSHOT.jar /app

EXPOSE 8083

CMD ["java", "-jar", "notifications-api-1.0-SNAPSHOT.jar"]