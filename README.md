# Spring Boot REST API example with simple CRUD operations to manage a Person entity

## Prerequisites
    1. Have JDK 11 installed in your machine and set JAVA_HOME path - in memory database (JSONDB) used in this application is depending on JDK 11
    2. Have Maven installed in your machine and verify Maven commands are working in CLI
    3. Have Docker installed in your machine and ensure Docker is running and you can execute Docker CLI commands

## Steps to setup the application and run

#### Clone the application to your local directory
    https://github.com/raaki274/persons.git

#### Create directory for saving collections into JSONDB an in memory database
    1. Go to your home path $HOME in Linux and Mac and %HOMEPATH% in Windows machines
    2. Create a directory with name "jsondb"
    3. JSONDB components used in the application will store the JSON collections under this location
    
#### Build packaging the application
    1. Go to the root/parent directory of the application where the pom.xml is placed inside your GIT clone directory
    2. Run the following command to build package your application
       *mvn package*
    3. JSONDB components used in the application will store the JSON collections under this location


