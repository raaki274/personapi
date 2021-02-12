# Spring Boot REST API example with simple CRUD operations to manage a Person entity

## Prerequisites
    1. Have JDK 11 installed in your machine and set JAVA_HOME path (in-memory database JSONDB is depending on JDK 11)
    
    2. Have Maven installed in your machine and verify Maven commands are working in CLI
    
    3. Have Docker installed in your machine and ensure Docker is running and you can execute Docker CLI commands
    
    4. Have Postman client installed in you machine for submitting REST requests with GET, POST, PUT and DELETE methods

## Steps to setup the application and run

#### Clone the application to your local directory
    https://github.com/raaki274/persons.git

#### Create directory for saving collections into JSONDB an in memory database
    1. Go to your home path $HOME in Linux and Mac and %HOMEPATH% in Windows machines
    
    2. Create a directory with name "jsondb"
    
    3. Note: JSONDB components used in the application will store the JSON collections under this location only
    
#### Build packaging and running the application locally
    1. Go to the root/parent directory of the application codebase where the pom.xml is placed inside your GIT clone directory
    
    2. Run the following command to build package your application
       > mvn package
       
    3. Once the build is successful, run the following Java command to run the application
       > java -jar ./target/person-0.0.1-SNAPSHOT.jar
       
    4. The app will start running at - http://localhost:8080, check if it is started and running successfully
    
    5. We are going to Dockerize the application in the next section, you can now stop the application by hitting Ctrl + C
    
#### Dockerizing the application
    1. Run the below command from the application's parent directory for building Docker image
        > docker build -t person-app .
    
    2. Run the below command for running the application image inside Docker container
        > docker run -p 8080:8080 person-app
    
    3. Application image will start and run at port number 8080 inside Docker container

#### Inputs for Testing the application
The app defines following CRUD APIs,

    GET     /ebitest/person/{id}
    POST    /ebitest/person
    PUT     /ebitest/person
    DELETE  /ebitest/person/{id}

Sample inputs for the operations,

JSON input for adding a person 

    POST URL: http://localhost:8080/ebitest/person
    
    {
        "first_name": "John",
        "last_name": "Keynes",
        "age": 29,
        "favourite_colour": "red"
    }

URI input for retrieving a person, here first_name is the id for retrieving a person
    
    GET URL: http://localhost:8080/ebitest/person/John
    
    
JSON input for updating a person
    
    PUT URL: http://localhost:8080/ebitest/person
    
    {
        "first_name": "John",
        "last_name": "Kelleys",
        "age": 33,
        "favourite_colour": "black"
    }

URI input for deleting a person

    DELETE URL: http://localhost:8080/ebitest/person/John
    
    Note: No JSON request body required
    
#### Testing the application via Postman
    1. Run the Postman client
    
    2. To add person, select request method POST and paste the URL http://localhost:8080/ebitest/person
    
    3. Click on Headers tab, add the following key value param Content-Type = application/json
    
    4. Click on Body tab, select 'raw' option, paste the sample JSON input from the above section
    
    5. Hit 'Send' button for submitting the request
    
    6. For testing all four operations change the request methods and URLs as per the sample input section above and
       use the respective sample JSON inputs
       


