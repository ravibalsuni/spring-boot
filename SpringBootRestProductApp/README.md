# Rest API's In Spring Boot Application

This project was deployed on default Spring Boot Port - [http://localhost:8080](http://localhost:8080)

Component - ProductController is added along with the default behavior which gives provision to:

1) get (read) existing products from the ArrayList via json request in a GET method call, 3 products are added by default and further products can be added using a POST method call mentioned below

2) add a product into the existing ArrayList via json request in a POST call

	Soap UI Screenshot for points 1) and 2) is available in src/main/resource directory 

## Show me the important parts!
 
 [Class] (com.github.springboot.rest.controller.ProductController)

## logback.xml

Logback.xml is configured at src/main/resource


mylog.log is generated at application root - /SpringBootRestProductApp - it can be configured in logback.xml

## How does it work?

Using Soap UI or any rest client (Example - RestClient Extension for FireFox Web Browser)
 
1) Get request URl - No Input is required

		http://localhost:8080/SpringBootRestApp/product/getProducts

2) Post request Url - Input is required in json format

		http://localhost:8080/SpringBootRestApp/product/addProduct
		
		json Input sample - 

		{
		  			"name"             :    "fork",
		  			"supportEmail"     :    "support.fork@gmail.com"	
		}
		
### Running the application
You can build and run the process application with Spring Boot.

#### Manually
1. Build the application using:
```bash
mvn clean package
```
2. Run the *.jar file from the `target` directory using:
```bash
java -jar target/SpringBootRestProductApp-1.0.jar
```

For a faster 1-click (re-)deployment see the alternatives below.

#### Maven Spring Boot Plugin
1. Build and deploy the process application using:
```bash
mvn clean package spring-boot:run
```

#### Your Java IDE
1. Run the project as a Java application in your IDE using SpringBootRestProductApp as the main class.


## JUnit Jupiter Test Case 

1) Rest services - ProductController test cases goes here - com.github.springboot.rest.controller.ProductControllerTest


## Environment Restrictions
Built and tested against Spring Boot - 2.3.0.RELEASE

## License
[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
