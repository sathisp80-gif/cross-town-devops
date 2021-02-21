FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
EXPOSE 5758
COPY ${JAR_FILE} transaction-statement.tar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/transaction-statement.tar"]
