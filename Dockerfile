FROM openjdk:8-jdk

MAINTAINER Aiswarja "aiswarja_saha05@yahoo.com"

WORKDIR /usr/local/bin/

COPY target/assignment-0.0.1-SNAPSHOT.jar assignment-0.0.1-SNAPSHOT.jar

EXPOSE 9008

CMD ["java", "-jar", "assignment-0.0.1-SNAPSHOT.jar"]
