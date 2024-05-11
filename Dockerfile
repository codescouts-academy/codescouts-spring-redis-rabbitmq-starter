FROM openjdk:21-jdk AS build

COPY pom.xml /build/
COPY mvnw /build/
COPY src /build/src/
COPY .mvn /build/.mvn/

WORKDIR /build/
RUN ./mvnw dependency:go-offline -B
RUN ./mvnw package

FROM openjdk:21-jdk

WORKDIR /app

COPY --from=build /build/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]