## DOCKER


#### Download Image
``` docker
docker pull alpine
```

#### Membuat Container
``` docker
docker run -p 8080:8080 image_name
```

docker login
docker build - t image_name:tag
docker run -p 8080:8080 image_name
docker images
docker image ls
docker container ls 
docker ps
docker -f rmi image_id
docker rmi tag
docker tag image_name:tag user_name/image_name:tag

FROM openjdk:11
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac Main.java
CMD ["java", "Main"]
