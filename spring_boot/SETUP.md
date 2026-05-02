# Spring Boot Project Setup

## Project Overview

This is a practice Spring Boot microservice built with Java 17 and Maven Wrapper.

Main features:
- REST API for a greeting endpoint
- Echo API with request validation
- Redis-backed endpoints to store, read, and delete JSON values by key
- Kafka producer to publish order creation events
- Kafka consumer to listen for order events
- Actuator endpoints for basic health and metrics

Default application details:
- Application name: `spring_boot`
- Default profile: `local`
- Default port: `8052`

## Tech Stack

- Java 17
- Spring Boot 3
- Maven Wrapper (`./mvnw`)
- Spring Web
- Spring Validation
- Spring Data Redis
- Spring for Apache Kafka
- Spring Boot Actuator

## Prerequisites

Install or have access to:
- Java 17
- Redis running on `localhost:6379`
- Kafka running on `localhost:9092`

You do not need Maven installed globally because the project includes Maven Wrapper.

## Project Structure

- `src/main/java` - application source code
- `src/main/resources` - application config files
- `src/test/java` - test classes
- `pom.xml` - Maven project configuration
- `mvnw` and `mvnw.cmd` - Maven Wrapper scripts

## Environment Configuration

The app reads these values from environment variables and falls back to local defaults:

- `REDIS_HOST` default: `localhost`
- `REDIS_PORT` default: `6379`
- `KAFKA_BOOTSTRAP_SERVERS` default: `localhost:9092`

If you are running everything locally, you can usually start the project without setting anything.

## How To Start The Project

1. Open a terminal in the `spring_boot` folder.

2. Start Redis.

3. Start Kafka.

4. Run the application:

```bash
./mvnw spring-boot:run
```

5. Wait for the app to start, then open:

- `http://localhost:8052/api`
- `http://localhost:8052/actuator/health`

## Alternative Build And Run

Build the jar:

```bash
./mvnw clean package
```

Run the jar:

```bash
java -jar target/spring_boot-0.0.1-SNAPSHOT.jar
```

## Useful API Endpoints

### Greeting

```http
GET /api
```

### Echo

```http
POST /api/echo
Content-Type: application/json
```

Example request:

```json
{
  "message": "hello"
}
```

### Redis Save

```http
POST /api/redis/{key}
Content-Type: application/json
```

Example request:

```json
{
  "value": {
    "name": "sample-user",
    "role": "engineer"
  }
}
```

### Redis Read

```http
GET /api/redis/{key}
```

### Redis Delete

```http
DELETE /api/redis/{key}
```

### Create Order

```http
POST /api/order/create-order
Content-Type: application/json
```

Example request:

```json
{
  "orderId": "ORD-101",
  "userId": "USR-1",
  "totalAmount": 299.99,
  "status": "CREATED",
  "createdAt": "2026-05-02T10:00:00Z",
  "items": [
    {
      "productId": "P-1",
      "quantity": 2,
      "price": 149.995
    }
  ]
}
```

This endpoint publishes an order event to the Kafka topic `food-orders`.

## Running Tests

Run tests with:

```bash
./mvnw test
```

Note:
- `RedisTests` requires Redis to be running locally.
- Kafka listener configuration may also try to connect to local Kafka during startup.

If Redis or Kafka is not running, some tests or startup flows may fail.

## Profiles

Available config files:
- `application.yml`
- `application-local.yml`
- `application-prod.yml`

The default profile is `local`.

To run with the production profile:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

## Common Commands

Start app:

```bash
./mvnw spring-boot:run
```

Run tests:

```bash
./mvnw test
```

Clean project:

```bash
./mvnw clean
```

Build jar:

```bash
./mvnw clean package
```
