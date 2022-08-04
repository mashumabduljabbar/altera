ARG CRD
FROM openjdk:8
EXPOSE 8080
COPY target/student.jar student.jar
ENTRYPOINT ["java","jasypt.encryptor.password=$CRD","-jar","demo.jar"]