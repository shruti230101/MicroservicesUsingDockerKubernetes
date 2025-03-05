Bank Application with Spring Boot, Docker

Topics covered:
- Building microservices using Spring Boot
- Handle deployment, portability & scalability of microservices using Docker
- Configurations Management in Microservices
- Using MySQL DBs inside microservices
- Service Discovery & Service Registration in microservices
- Gateway, Routing & Cross cutting concerns in Microservices
- Making Microservices Resilient
- Observability and monitoring of microservices
- Microservices Security

Pre-requisites:
- Good understanding on Java and Spring concepts
- Basic understanding on SpringBoot & REST services is a bonus but not mandatory

Maven Commands used:
- "mvn clean install -Dmaven.test.skip=true" ---> To generate a jar inside target folder
- "mvn spring-boot:run"	---> To start a springboot maven project
- "mvn spring-boot:build-image"	---> To generate a docker image using Buildpacks. No need of Dockerfile
- "mvn compile jib:dockerBuild"	---> To generate a docker image using Google Jib. No need of Dockerfile
  
Docker Commands used: 
- "docker build . -t shrutia23/accounts:s4"	To generate a docker image based on a Dockerfile
- "docker run -p 8080:8080 shrutia23/accounts:s4"	To start a docker container based on a given image
- "docker images"	To list all the docker images present in the Docker server
- "docker image inspect image-id"	To display detailed image information for a given image id
- "docker image rm image-id"	To remove one or more images for a given image ids
- "docker image push docker.io/shrutia23/accounts:s4"	To push an image or a repository to a registry
- "docker image pull docker.io/shrutia23/accounts:s4"	To pull an image or a repository from a registry
- "docker ps"	To show all running containers
- "docker ps -a"	To show all containers including running and stopped
- "docker container start container-id"	To start one or more stopped containers
- "docker container stop container-id"	To stop one or more running containers
- "docker container kill container-id"	To kill one or more running containers instantly
- "docker container rm container-id"	To remove one or more containers based on container ids
- "docker container prune"	To remove all stopped containers
- "docker compose up"	To create and start containers based on given docker compose file
- "docker compose down"	To stop and remove containers
- "docker compose start"	To start containers based on given docker compose file
- "docker run -p 3306:3306 --name accountsdb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=accountsdb -d mysql"	To create a MySQL DB container
- "docker run -p 6379:6379 --name eazyredis -d redis"	To create a Redis Container

Apache Benchmark command used: 
- "ab -n 10 -c 2 -v 3 http://localhost:8072/eazybank/cards/api/contact-info"	To perform load testing on API by sending 10 requests
