FROM maven:3.8.6-openjdk-11
WORKDIR /home/app
COPY src ./src
COPY pom.xml .
RUN mvn clean package -DskipTests
ENTRYPOINT ["java","-jar","./target/demo-0.0.1-SNAPSHOT.jar"]