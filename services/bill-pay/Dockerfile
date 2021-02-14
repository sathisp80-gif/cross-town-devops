FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
EXPOSE 5757
COPY ${JAR_FILE} bill-pay.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bill-pay.jar"]