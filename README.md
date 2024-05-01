# Getting started 🎉
This project was designed to learn Redis and RabbitMQ with Java using Docker compose.

## Requirements 🎲
Install dependencies
- [Docker](https://docs.docker.com/engine/install/)

## Folder structure 📁

In this repo you can see 3 main folders.
- Controllers 
  - TestController
- Domain
  - Test class
- Services
  - RedisService

## Run dependencies 🏃

At root of this project run this command to start Redis and RabbitMQ

- `docker-compose up`

## Start 🧩

- Build and start this project
- Run the next line to set value on Redis
```
curl -X POST -H "Content-Type: application/json" -d '{"id": 1, "value": "hi"}' http://localhost:8080/api/test
```
- Run the next line to get the value setted before
```
 curl -X GET http://localhost:8080/api/test/1
```

## Stop ✋
```
docker-compose stop
```
