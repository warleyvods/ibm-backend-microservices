# IBM Hashtag Track - Twitter Microservice (Backend)

This app can measure the performance of the campaign as well as the locations to which this campaign is being most commented.


## Overview

The architecture is composed by four services:

- `config-server`: All of our system configuration files are in the repository `https://###` and **Config Server** will be responsible for reading the information in the repository and providing it to applications through HTTP requests.
- `discovery-server`: Service Discovery Server created with **Spring Cloud Eureka**
- `gateway-server`: API Gateway created with **Zuul** that uses the `discovery-service` to send the requests to the services. It uses **Ribbon** as Load Balancer
- `hashtag-tracker`: Simple REST service created with **Spring Boot** to find hashtags location from Twitter API.

## Live on AWS
http://3.12.198.17/tracker/


## Tecnologies used

- Java 11
- Springboot Framework
- Spring Cloud OpenFeign
- Spring Cloud Eureka Discovery
- Spring Cloud Ribbon
- Spring Cloud Zull Gateway
- Caffeine Cache
- Spring Cloud Hystrix (Cirquit Breaker)
- Spring Cloud Config
- Stanford JavaNLP library (Natural language processing)
- Docker
- PostgreSQL

## How to use

To test this architecture you will need to have: **JDK 11**, **Docker** and **Maven** installed or **Docker** with **docker-compose**

- Clone this repo and enter it

- Run the `start.sh` script, it will use **Maven** to build the `.jar` file for each service and then use Docker to build the containers with the `.jar` files

In the default configuration you will have:

- **Config Server** running on port `8083`
- **Discovery Server** running on port `8081`, access `http://localhost:8081` to see the dashboard
- **Gateway Server** running on port `8080`
- **Hashtag Track API Server** running on port: `8082`, you will send the requests to this service

After running the containers, head to `http://localhost:8081` to make sure that the service (**Hashtag Track API Server**) are registered in the **Discovery Server**, when they're all registered you can test the application using swagger through the following link: `http://localhost:8082/swagger-ui.html`

