FROM java:8
VOLUME /tmp
ADD target/spring-datatables-1.0.0.BUILD-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
