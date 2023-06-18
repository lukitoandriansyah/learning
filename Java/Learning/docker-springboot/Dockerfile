FROM eclipse-temurin:17
LABEL mentainer="lukitoandriansyah54@gmail.com"
WORKDIR /app
COPY target/docker-springboot-0.0.1-SNAPSHOT.jar /app/docker-springboot.jar
ENTRYPOINT ["java","-jar","docker-springboot.jar"]
