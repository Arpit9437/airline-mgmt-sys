FROM openjdk:17-alpine
EXPOSE 8094
ADD target/springboot-docker.jar springboot-docker.jar
ENTRYPOINT ["java", "-jar", "/springboot-docker.jar"]