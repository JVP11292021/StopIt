#FROM maven:3.8.5-openjdk-17 AS build
#COPY . .
#RUN mvn clean
#RUN mvn install

FROM eclipse-temurin:17.0.4.1_1-jre as builder
MAINTAINER jessyvanpolanen
WORKDIR extracted
COPY pom.xml .
ADD target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM eclipse-temurin:17.0.4.1_1-jre
WORKDIR app
COPY --from=builder extracted/dependencies/ ./
COPY --from=builder extracted/spring-boot-loader/ ./
COPY --from=builder extracted/snapshot-dependencies/ ./
COPY --from=builder extracted/application/ ./
EXPOSE 8081
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

#FROM maven:3.8.5-openjdk-17 AS build
#COPY . .
#RUN mvn clean package -DskipTests
#
#FROM openjdk:17.0.1-jdk-slim
#COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","demo.jar"]