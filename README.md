# jnosql-demo

Example Application showing the use of JNoSQL within an Jakarta EE Application.

## Starting MongoDB

To start MongoDB which is used in this example, you have to run `docker-compose up -d` in the root of this repository. 

## Starting the Application

This example uses Wildfly-Bootable-Jar as a runtime environment. Everything is packaged with the Wildfly Maven Plugin.

With `./mvnw wildfly:dev` you can start the application in development mode.

## Testing

Create a new customer with the following curl command:

`curl -v -X POST -d @data/max.json http://localhost:8080/jnosql-demo/api/customer -H "Content-Type: application/json"`

Now you can request the newly created customer with its id:

`curl -v http://localhost:8080/jnosql-demo/api/customer/1 -H "Accept: application/json"`
