# Getting started 🎉

This project was designed to learn Redis and RabbitMQ with Java using Docker compose.

## Requirements 🎲

Install dependencies

- [Docker](https://docs.docker.com/engine/install/)

## Folder structure 📁

In this repo you can see 2 main folders.

- microservice-1
  - Controllers
    - TestController
  - Domain
    - Test class
  - Services
    - RabbitSender
    - RedisService
- microservice-2
  - Controllers
    - TestController
  - Domain
    - Test class
  - Services
    - RabbitReceiver
    - RedisService

## Build 🛠

```
make build
```

## Run docker 🏃

At root of this project run this command to start Redis and RabbitMQ

```
make up
```

## Start 🧩

Those microservices are running on docker compose and both are connected to Redis and RabbitMQ.

- microservice-1 running on port: 8081
- microservice-2 running on port: 8082

### Redis 🚀

- Build and start this project
- Run the next line to set value on Redis

```
curl -X POST -H "Content-Type: application/json" -d '{"id": 1, "value": "Hello redis!"}' http://localhost:8081/api/test
```

- Run the next line to get the value sent before on redis

```
 curl -X GET http://localhost:8081/api/test/1
```

### RabbitMQ 🚀

- Run this line to listen to RabbitMQ on microservice-2

```
http://localhost:8082/api/test/rabbit
```

- Run this line to send a message to RabbitMQ

```
curl -X POST -H "Content-Type: application/json" -d '{"id": 1, "value": "Hello Rabbit!"}' http://localhost:8081/api/test/rabbit
```

- If you want to access, use: ([Rabbit Management](http://localhost:15672/)) and login with user: **admin** and password: **admin**

## Stop ✋

```
make down
```
