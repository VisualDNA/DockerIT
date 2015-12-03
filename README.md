# DockerIT (Docker for Integration Test)

Integration tests with a MySQL instance is quite painful, this project is using Docker to improve the testing process.  
The project uses Slick for database access and uses Maven as project manager.

This is ready to be executed with `mvn clean verify` on your local machine (as long as you have Docker installed) and 
also from Jenkins.

The `pom.xml` has 2 profiles, one for running under MacOSX and the second one for running under Linux. 
