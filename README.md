 # Spring Blog
Spring Blog is a lightweight blog system implemented with Spring Boot & Angular
Check the test site (running in docker) for demo online: [http://www.jinhao.me:8080](http://www.jinhao.me:8080).

## frameworks and build tools
##### front end:
 - Node.js & Angular CLI (as build tools)
 - Angular (as user end single page application framework)
 - Thymeleaf (as admin template)
##### back end:
 - Spring Boot (as server framework)
 - Maven (as build tool)
##### database:
 - MySQL
##### platform:
 - Docker (as container & deploy tool)

## development
This project is still under development and has no stable release.
### how to use
Spring Blog is built with Maven. To install Maven, see the official site of [Apache Maven Project](https://maven.apache.org/install.html)
```
$ git clone https://github.com/cjh14813573/springblog

$ cd springblog

$ mvn spring-boot:run
or
$ mvn clean package
$ java -jar target/springblog-0.0.1-SNAPSHOT.jar
```
Spring Blog uses MySQL as database, make sure you modified `src/main/resources/application.yml` before compiling.
The default external resource path for spring blog is `~/springblog/media`
