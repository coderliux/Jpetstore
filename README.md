MyBatis JPetStore
=================


![mybatis-jpetstore](http://mybatis.github.io/images/mybatis-logo.png)

JPetStore 6 is a full web application built on top of MyBatis 3, Spring 3 and Stripes. It is available for downloading in the downloads section of MyBatis project site. In this section we will walk through this sample to understand how is it built and learn how to run it.

See: http://www.mybatis.org/spring/sample.html

## Other versions that you may want to know about

- JPetstore on top of Spring, Spring MVC, MyBatis 3, and Spring Security https://github.com/making/spring-jpetstore
- JPetstore with Spring boot https://github.com/igor-baiborodine/jpetstore-6

## Running with Jetty
Running JPetStore sample under embedded jetty (using gradle).
- Clone this repository
- Open command prompt/shell and change to cloned directory

gradle clean build jettyRun

- Run application in browser http://localhost:8080/jpetstore/ 
- Press Ctrl-C to stop the server.
