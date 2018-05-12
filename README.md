JavaMelody UI Module for SpringBootAdmin v1
=========================

This module adds a view that displays the javamelody monitoring for each
registered application in [SpringBootAdmin v1](http://codecentric.github.io/spring-boot-admin/1.5.7/) (SBA)

  * Add the module to your classpath in the pom.xml of your SBA server:
```xml
<!-- https://github.com/javamelody/spring-boot-admin-server-ui-javamelody -->
<dependency>
    <groupId>net.bull.javamelody</groupId>
    <artifactId>spring-boot-admin-server-ui-javamelody</artifactId>
    <version>1.5.7.0</version>
</dependency>
<dependency>
    <groupId>net.bull.javamelody</groupId>
    <artifactId>javamelody-core</artifactId>
    <version>1.72.0</version>
</dependency>
```

  * Optionally add parameters for the SBA server in your application.yml or application.properties file. [Available parameters](https://github.com/javamelody/javamelody/wiki/UserGuideAdvanced#2-deployment-of-the-webapp-of-monitoring) are: storage-directory, resolution-seconds, warning-threshold-millis, severe-threshold-millis, graphite-address, influxdb-url, cloudwatch-namespace, datadog-api-key, admin-emails, mail-session, mail-periods. For example in application.yml:
```yml
javamelody:
  collectserver.enabled: true
  init-parameters:
    storage-directory: /tmp/javamelody
```

  * Make sure each application that is registered with SBA has [javamelody client](https://github.com/javamelody/javamelody/wiki/SpringBootStarter) support enabled and can be reached at the default endpoint `/monitoring`, with the javamelody client in the pom.xml of your applications:
```xml
<!-- https://github.com/javamelody/javamelody/wiki/SpringBootStarter -->
<dependency>
    <groupId>net.bull.javamelody</groupId>
    <artifactId>javamelody-spring-boot-starter</artifactId>
    <version>1.72.0</version>
</dependency>
```

Latest javamelody version: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/net.bull.javamelody/javamelody-core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/net.bull.javamelody/javamelody-core)

License [ASL](http://www.apache.org/licenses/LICENSE-2.0)

This JavaMelody module is not currently compatible with Spring Boot Admin V2. Volunteers are welcome.
