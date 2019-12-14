 # Spring Blog
Spring Blog is a lightweight blog system implemented with Spring Boot & Angular
This project is built with RESTful API
## Demo
Check the test site (running in docker) for demo online: [http://www.jinhao.me:8080](http://www.jinhao.me:8080).

## Frameworks and build tools
##### front end:
 - [Node.js](https://nodejs.org/en/) & [Angular CLI](https://cli.angular.io/) (as build tools)
 - [Angular](https://angular.io/) (as user end single page application framework)
 - [Thymeleaf](https://www.thymeleaf.org/) (as admin template)
##### back end:
 - [Spring Boot](https://spring.io/) (as server framework)
 - [Maven](https://maven.apache.org/) (as build tool)
##### database:
 - [MySQL](https://www.mysql.com/)
##### platform:
 - [Docker](https://www.docker.com/) (as container & deploy tool)

## Development
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
The default external resource path for spring blog is `User-Home-Directory/springblog/media`

## Version history
###### 0.3.1-SNAPSHOT
 - add pagination feature
###### 0.3.0-SNAPSHOT
 - rewrite front end (user) with Angular
###### 0.2.3-SNAPSHOT
 - add comment feature
 - fix bugs
###### 0.2.2-SNAPSHOT
 - embed CKEditor
###### 0.2.1-SNAPSHOT
 - add categores dash
 - add pages dash
###### 0.2.0-SNAPSHOT
 - build dash for admin
###### 0.1.3-SNAPSHOT
 - add widgets feature
 - add external link for pages
###### 0.1.2-SNAPSHOT
 - add blog/category features
###### 0.1.1-SNAPSHOT
 - start project
 - build front end with thymeleaf & bootstrap