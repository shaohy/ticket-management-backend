FROM java:17

COPY target/ticket-management-1.0-SNAPSHOT.jar /app/ticket-management.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ticket-management.jar"]
