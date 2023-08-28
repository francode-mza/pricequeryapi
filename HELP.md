# Price Query API

### Project description

This module provides a price query endpoint applying the criteria of the given requirement document.
Since it is a demo project, it uses an H2 on memory DB with the given sample data inserted with Flyway, and it is a read only application.

### Requirements

-Java **11** or higher

-Optional Maven: **3.6** or higher


### Installation

If you have Maven installed on your system you can run **mvn clean install**.
but if you prefer you can run the command throw the maven wrapper by doing **./mvnw clean install**

### Running the project

With installed Maven: **mvn spring-boot:run**

With Maven Wrapper: **./mvnw spring-boot:run**


### How to use it

Once the project is running, an endpoint will be available on: **localhost:8080/prices**

This GET endpoint require three parameters: date (in LocalDateTime format), productId (Long) and brandId (Long)

For example: **http://localhost:8080/prices?date=2020-06-14T16:00:00&productId=35455&brandId=1**

