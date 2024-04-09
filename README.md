# REST API request timeouts
Materials for the article about analyzing request timeouts for the Spring REST API.

### Simple store
Microservice that uses the Spring RestClient to call another rest endpoint.

### Simple warehouse
Microservice that provides a REST endpoint for a call.

## Building the project
The project is built using standard Maven commands.

Additional profiles:
* **docker-image** - During the packaging phase, jib-maven-plugin creates a microservice image in the Docker daemon 
without uploading it to the container registry.
