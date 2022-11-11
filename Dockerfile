FROM ubuntu:22.04
RUN apt-get update
RUN apt-get install maven -y
RUN apt install openjdk-11-jdk -y
RUN apt install openjdk-11-jre -y
COPY ./target/crud-0.0.1-SNAPSHOT.jar /home/crud-0.0.1-SNAPSHOT.jar
EXPOSE 8097
CMD ["java","-jar","/home/crud-0.0.1-SNAPSHOT.jar"]