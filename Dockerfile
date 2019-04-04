FROM maven as build
WORKDIR /build
COPY pom.xml .
COPY . .
RUN mvn clean package

FROM openjdk:8
COPY --from=build /build/target/BuildingAPI-0.0.1-SNAPSHOT.jar  building.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","building.jar"]
