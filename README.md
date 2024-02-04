## Description

The tinyUrl project is a Java-based application designed to create shortened URLs, similar to services like bit.ly or TinyURL. This application provides an API to shorten URLs, manage them, and track their usage.

## Installation

To run the tinyUrl project, you will need Java and Maven installed on your system. Follow these steps to get the project up and running:

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Use Maven to build the project:
   ./mvnw clean install
4. To run the application, execute:
   ./mvnw spring-boot:run


## Usage

After starting the application, you can shorten URLs by sending a request to the application's REST API. Detailed API documentation is available at `[API_DOCUMENTATION_LINK]`.

Example request to shorten a URL:
curl -X POST -H "Content-Type: application/json" -d '{"url": "https://example.com"}' http://localhost:8080/shorten


   
