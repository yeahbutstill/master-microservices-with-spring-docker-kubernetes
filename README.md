# master-microservices-with-spring-docker-kubernetes

## Start Keycloak
From a terminal start Keycloak with the following command:
```shell
docker run -p 7080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:20.0.2 start-dev
```
This will start Keycloak exposed on the local port 8080. It will also create an initial admin user with username admin and password admin.
https://www.keycloak.org/getting-started/getting-started-docker .

## Check realm configurations
http://localhost:7080/realms/master/.well-known/openid-configuration

## Hit http method POST using postman
http://localhost:7080/realms/master/protocol/openid-connect/token
add inside the body urlencoded. client_id, client_secret, scope and grant_type.. to get access token

## Oauth2 Authorization Code Grant Flow
```text
http://localhost:8072/eazybank/cards/card/properties
http://localhost:8072/eazybank/accounts/account/properties
http://localhost:8072/eazybank/loans/loan/properties
```

## Start Zipkin
```shell
docker run -d -p 9411:9411 openzipkin/zipkin
```


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