FROM openjdk:8-jre

#RUN mkdir /app

COPY target/itoken-sso-1.0.0-SNAPSHOT.jar /app/itoken-sso/


CMD java -jar /app/itoken-sso/token-sso-1.0.0-SNAPSHOT.jar


EXPOSE 8771