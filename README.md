# NATS Messaging App

A lightweight, event-driven Java application that subscribes to a [NATS](https://nats.io) messaging server, processes incoming messages, and persists them into a PostgreSQL database. Built with Docker, Java 17, and Maven for seamless containerized deployment.

## Tech Stack

- Java
- Maven
- PostgreSQL
- NATS
- Docker + Docker Compose

## Application Layers

- API Layer  
  Subscribes to a NATS subject and receives incoming data.

- Business Layer  
  Validates and processes incoming messages before storing them.

- Data Layer  
  Handles connection to PostgreSQL and persists messages with content and timestamp.

## How to Run (with Docker)

1. Clone the repository
```
   git clone https://github.com/nane-andreasyan/nats-messaging.git
   cd nats-messaging
```

3. Build and start the services
```
   docker-compose up --build
```
This will:
- Start PostgreSQL on port 5432
- Start a NATS server on port 4222
- Build and run the Java application

## How to Create the Table
In a new terminal:

Connect to the PostgreSQL container:

```
docker exec -it postgres-db psql -U naneandreasyan -d messaging
```

Run the following SQL:

```
CREATE TABLE messages (
  id SERIAL PRIMARY KEY,
  content TEXT NOT NULL,
  timestamp TIMESTAMP NOT NULL
);
```

Exit the Postgres shell:
```
\q
```

## How to Publish a Message

```
   docker run --rm natsio/nats-box nats --server nats://host.docker.internal:4222 pub messages "Hi!"
```
You should see output like:

```
  Received message from NATS: Hi!
  Message saved to DB.
```

## How to View Saved Messages

Connect to the PostgreSQL container:
```
   docker exec -it postgres-db psql -U naneandreasyan -d messaging
```
Then run:
```
  SELECT * FROM messages;
```
## Build Notes

- The application uses a fat JAR built via the Maven Shade Plugin.
- Environment variables (e.g., DB_URL, NATS_URL) are passed via docker-compose.yml.
- All services are self-contained; no local installations needed.
