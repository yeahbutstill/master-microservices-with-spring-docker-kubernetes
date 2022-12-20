# master-microservices-with-spring-docker-kubernetes

## Build Image
```shell
mvn spring-boot:build-image
```

## Push Image local to repository
```shell
docker push docker.io/{{DOCKER_HUB_USERNAME}}/{{IMAGE_NAME}}
```
```shell
docker push docker.io/2819930922/accounts
```

