# TrendingNewsAPI
Spring boot project for Trending News application

## Compile Instructions

### Prerequisite
* Please make sure you have latest version of JAVA and MAVEN installed on your machine. 
  * For more details refer `https://maven.apache.org/install.html` and `https://www.oracle.com/java/technologies/javase-jdk11-downloads.html`
* Please make sure that JAVA_HOME and MAVEN_HOME paths are set in environment variables as follows:

  * `JAVA_HOME: C:\Program Files\Java\jdk1.8.0_181` 
  * `MAVEN_HOME: C:\Users\apache-maven-3.6.0`

* If not, then add both the above paths to the environment variable 'PATH' as follows:` %MAVEN_HOME%\bin` `%JAVA_HOME%\bin`


### Using Command Line Utility:
* First we need to install maven dependencies
  * To install maven dependencies, navigate to the root folder and run `mvn install`
* Navigate to the target folder and execute `java -jar trendingNewsAPI-0.0.1-SNAPSHOT.jar` command

### Using IDE
* Open your project using any IDE. We would recommend to use Eclipse as it provides an out-of-box support for maven projects or you can use Spring Tool Suite(STS). For more details refer: https://spring.io/tools
* Install maven plugin
* Click on the project and run `maven install`
* Once you have installed all the dependencies, run the project as Java or Spring Boot application.
* This will start with the Tomcat server and will host APIs on port 4200 port
* To test the application, navigate to `http://localhost:4200/test`  

