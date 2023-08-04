FROM openjdk:latest

EXPOSE 8080

ADD target/OrderSystem-1.0.war /home/app.war
WORKDIR /home
ENTRYPOINT ["java","-jar","/app.war"]