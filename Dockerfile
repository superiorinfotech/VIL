FROM maven:3.5.0-jdk-8
WORKDIR /app
COPY ./target/*.jar ./VIL-API.jar
RUN echo "Asia/Kolkata" > /etc/timezone
RUN dpkg-reconfigure -f noninteractive tzdata
ENTRYPOINT ["java","-Djava.awt.headless=true","-Djava.security.egd=file:/dev/./urandom","-Dspring.data.mongodb.uri=mongodb://ems-db:27017/vil-db","-jar","/app/VIL-API.jar"]
EXPOSE 7777
