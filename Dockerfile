FROM openjdk:17

WORKDIR /
COPY ./target/IoT-microservice.jar /

CMD ["java","-jar","IoT-microservice.jar"]