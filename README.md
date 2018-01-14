
Customers records management app
=====

Customers records management app implement with Spring-boot and controlled with REST API.


Structure
------------

The structure based on Spring's official guides:

"/src/main/java/Application.java":
Includes the "void main", starts and runs the app.

"/src/main/java/MainController.java":
Maps the rest requests.

"/src/main/java/Customer.java":
Customer reference,
includes name, address, phone and id fields, id is unique and auto generated.

"/src/main/java/CustomerRepository.java":
Extends the MongoRepository and apply it's functionallity to Customer.



How To Run
------------

## Mongodb
The app is using mongodb as database, first you should install mongodb, as explained on the official website:
"https://docs.mongodb.com/manual/installation/"

After the installation you should run mongo with mongod command on yout console.

## Running the app

*The app runs by default on port 8080.

Using IDE:
1. The app uses gradle, first build build.gradle.
2. Build and run the app (void main located in /src/main/java/com.p.SpringProject/Application.

Using command line:
Go in you console to project's folder and type and run "./gradlew bootRun".

Jar file:
In your command line go to jar's file derectory and open with "java -jar app.jar".



Available REST commands:
-------------------------
Add after "http://localhost:8080/customer-api" (or other port if changed):

"read-all":
Retrieves all the

"/delete-all":
Delete all data in the database.

"create?name={name}&address={address}&phone={phone}":
Creates new instance of Customer with the provided fields and adds it to the database,
all fields should be provided.

"get/{id}"
Retrieves instance of customer with provided id.

"update/{id}?name={name}&address={address}&phone={phone}":
Updates instance of Customer with selected id, one or more of the fields should be provided.

"delete/{id}":
Deletes the instance with the selected id.
