# Kafka Producer-Consumer App

This is a simple Kafka-based Spring Boot application demonstrating a **Producer-Consumer** setup. The producer exposes REST endpoints to perform arithmetic operations. These operations are then sent to a Kafka topic, and the consumer listens for and logs them.

---

## Technologies Used

* Java 17+
* Spring Boot
* Apache Kafka
* Docker & Docker Compose
* Maven
* Postman (for API testing)

---

## Getting Started

### 1. Build the Project

```bash
mvn clean package
```

### 2. Run the Application with Docker

```bash
docker compose up --build
```

This command builds and starts the necessary containers (Kafka, Zookeeper, Producer, Consumer, Kafdrop).

---

### Kafka UI (Kafdrop)
You can inspect Kafka topics and messages using the Kafdrop web UI:

Kafdrop - Kafka Web UI: `http://localhost:19000/`

---

## Available API Endpoints

Base URL: `http://localhost:8080`

| Endpoint    | Method | Description                   | Parameters           |
| ----------- | ------ | ----------------------------- | -------------------- |
| `/sum`      | POST   | Sends a sum operation result  | `a` (int), `b` (int) |
| `/subtract` | POST   | Sends a subtraction result    | `a` (int), `b` (int) |
| `/multiply` | POST   | Sends a multiplication result | `a` (int), `b` (int) |
| `/divide`   | POST   | Sends a division result       | `a` (int), `b` (int) |

All results are sent as messages to the Kafka topic defined in your `application.yml`.

---

## API Testing

A Postman collection is included in this repository: `wit.postman_collection.json`

If necessary, import it into Postman and use the preconfigured requests to test all endpoints.

---

## Notes

* Make sure Kafka and Zookeeper are running (handled via Docker Compose).
* If you modify Java code, re-run `mvn clean package` before restarting containers.

---

## Example Usage

```bash
curl -X POST "http://localhost:8080/sum?a=5&b=3"
```

**Response:**

```
Sum sent successfully, 5 + 3
```

And the Kafka consumer will log:

```
### Consuming message -> Sum: 8
```

---

## Kafka Topic Configuration

Make sure that the all `application.yml` contains the topic configuration:

```properties
topic.test=test_topic
```
