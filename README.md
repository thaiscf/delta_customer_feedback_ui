### Delta Customer Feedback UI
This repository contains the source code for the Customer Feedback UI

## Requirements
- Java 8+ (runtime environment)
- Mongo DB (to manage the data)
- Maven 3+ (to build the application)

## Build
Run ```mvn clean install``` on the parent directory of this repository

## Build artefact
The build produces an executable jar file under the target folder

## Run
Update the following properties as per your runtime environment:

- application.properties

Run the application using the java -jar command along with the aforementioned properties.
On successful startup, the API will listen on port `8081`.

Example:

``` java -jar target/customer_feedback_ui-0.0.1-SNAPSHOT.jar

## Stop

- ```Ctrl+C``` on the terminal will gracefully shut down the application.

## Access
To access the application, open the link 'http://localhost:8081/feedback'.
