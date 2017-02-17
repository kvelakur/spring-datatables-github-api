#!/bin/sh
mvn clean package
docker build -t karthik/spring-demo .
docker rm demo
docker run --name demo -p 8080:8080 -t karthik/spring-demo
