FROM openjdk:11

COPY ./target/person-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch person-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","person-0.0.1-SNAPSHOT.jar"]
