# master-microservices-with-spring-docker-kubernetes

## Build Image
```shell
## with unit test
mvn spring-boot:build-image

## skip unit test
mvn clean install spring-boot:build-image -Dmaven.test.skip=true
```

## Push Image local to repository
```shell
docker push docker.io/{{DOCKER_HUB_USERNAME}}/{{IMAGE_NAME}}
```
```shell
docker push docker.io/2819930922/accounts
```

## Zipkin
```text
http://localhost:9411/
```
## Grafana
```text
http://localhost:3000/
```

## Eureka
```text
http://localhost:8070/
```