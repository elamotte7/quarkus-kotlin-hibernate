# quarkus-kotlin-hibernate

## Description

This project is a bug reproducer.

When you are calling Serch method from PersonneRepository you get the following stack trace
````
2021-09-29 13:54:13,180 ERROR [io.qua.ver.htt.run.QuarkusErrorHandler] (executor-thread-0) HTTP Request to /personnes?page=0&size=10 failed, error id: 61c5cd46-860e-4beb-9519-74724f8fc3af-1: org.jboss.resteasy.spi.UnhandledException: java.lang.NoSuchMethodError: 'java.lang.Object io.quarkus.hibernate.orm.panache.kotlin.runtime.KotlinJpaOperations.find(java.lang.Class, java.lang.Object, java.lang.Object[])'
at org.jboss.resteasy.core.ExceptionHandler.handleApplicationException(ExceptionHandler.java:106)
...
````

You can reproduce the bug by running the unit tests (mvn test) or by calling the Rest endpoint http://localhost:8080/personnes
when the application is started.
You can also use swagger at http://localhost:8080/q/swagger-ui/

## Components

This module is using the following components:
- agroal
- cdi
- hibernate-orm
- hibernate-orm-panache-kotlin
- jdbc-h2
- kotlin
- narayana-jta
- resteasy
- smallrye-context-propagation
- smallrye-openapi
- swagger-ui