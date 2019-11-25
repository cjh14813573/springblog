 # Spring Blog
Spring Blog is a lightweight blog system implemented with Spring Boot.
Check the test site for demo online: [http://www.jinhao.me:8080](http://www.jinhao.me:8080)

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

