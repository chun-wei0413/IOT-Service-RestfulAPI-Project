FROM openjdk:17

WORKDIR /
COPY iot-service-restfulapi-project/target/IoT-microservice.jar /

CMD ["java","-jar","IoT-microservice.jar"]