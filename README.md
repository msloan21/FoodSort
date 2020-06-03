# MGM Interview Food Sort

A sample application developed for MGMTP.

## Getting Started
There are two ways to run this application.  The first uses Spring Boot's Command Line Runner and can be ran by opening a Java IDE and running com.mgmtp.foodsort.ConsoleApplication

![ConsoleApplication.java](https://github.com/msloan21/FoodSort/blob/master/Screen%20Shot%202020-06-03%20at%204.31.01%20PM.png)

The other way is as a RESTful web service, in memory database and a simple React front end.  To start the service, open a Java IDE
and run com.mgmtp.foodsort.WebApplication.  Please do not change the default port configuration of 8080.

![WebApplication.java](https://github.com/msloan21/FoodSort/blob/master/Screen%20Shot%202020-06-03%20at%204.31.26%20PM.png)

Next open a command prompt and cd to:

%PROJECT_HOME%/FoodSort/Web Content/foodsort

Then start the included front end server using:

yarn start

![yarn start](https://github.com/msloan21/FoodSort/blob/master/Screen%20Shot%202020-06-03%20at%204.39.21%20PM.png)

Please do not change the default port configuration of 3000.


### Prerequisites

* JDK 1.8 or greater
* NPM
* Maven


## Running the tests

mvn test

## Built With

* [React](https://reactjs.org/) 
* [Spring Boot](https://spring.io/projects/spring-boot) 
* [Maven](https://maven.apache.org/)
