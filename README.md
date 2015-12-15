# DockerIT (Docker for Integration Test)

Integration tests with a real MySQL instance is quite painful, this project is using Docker and [docker-maven-plugin](https://github.com/rhuss/docker-maven-pluginm) to improve and ease the testing process.

A Docker image running a real MySQL is actually started during the `pre-integration-test` phase and it's stopped at `post-integration-test`  
   
The project uses Slick for database access and uses Maven as build tool.

## Prerequisites  
Intall Docker as described [here](https://docs.docker.com/engine/installation/)

## Running the Integration Tests
The `pom.xml` has 2 profiles, one for running under MacOSX and the second one for running under Linux.  
   
Open a Terminal and run:
  
`mvn -Pmac clean verify`  

`mvn -Plinux clean verify`

