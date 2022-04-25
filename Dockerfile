FROM openjdk:11
EXPOSE 8080
ADD target/ProjectManagementSystem-Backend-0.0.1-SNAPSHOT.jar backend.jar
RUN cat /etc/hosts
ENTRYPOINT ["java","-jar","backend.jar"]