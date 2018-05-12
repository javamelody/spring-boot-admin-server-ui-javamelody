JavaMelody UI Module for SpringBootAdmin v1
=========================

This module adds a view of the javamelody monitoring for each
registered application in [SpringBootAdmin v1](http://codecentric.github.io/spring-boot-admin/1.5.7/) (SBA)

  1. Add the module to your classpath in the pom.xml of your SBA server:
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

  2. Optionally add parameters for the SBA server in your application.yml or application.properties file. [Available parameters](https://github.com/javamelody/javamelody/wiki/UserGuideAdvanced#2-deployment-of-the-webapp-of-monitoring) are: storage-directory, resolution-seconds, warning-threshold-millis, severe-threshold-millis, graphite-address, influxdb-url, cloudwatch-namespace, datadog-api-key, statsd-address, admin-emails, mail-session, mail-periods. For example in application.yml:
```yml
javamelody:
  collectserver.enabled: true
  init-parameters:
    storage-directory: /tmp/javamelody
```

  3. Make sure each application that is registered with SBA has [javamelody client](https://github.com/javamelody/javamelody/wiki/SpringBootStarter) support enabled and can be reached at the default endpoint `/monitoring`, with the javamelody client in the pom.xml of your applications:
```xml
<!-- https://github.com/javamelody/javamelody/wiki/SpringBootStarter -->
<dependency>
    <groupId>net.bull.javamelody</groupId>
    <artifactId>javamelody-spring-boot-starter</artifactId>
    <version>1.72.0</version>
</dependency>
```

 4. Optionally add parameters for the monitored application(s) in the application.yml or application.properties file(s). Main [available parameters](https://github.com/javamelody/javamelody/wiki/UserGuide#6-optional-parameters) are: allowed-addr-pattern, url-exclude-pattern, http-transform-pattern, sql-transform-pattern, jpa-transform-pattern, spring-transform-pattern, error-transform-pattern, log-transform-pattern, job-transform-pattern, jsp-transform-pattern, log, rum-enabled, sampling-seconds, maven-repositories. For example in application.yml (allowed-addr-pattern is recommended in order to restrict access to the monitoring page to the SBA server and to forbid access to anyone else):
```yml
spring.boot.admin:
  url: http://192.168.1.1:8080  

javamelody:
  # Enable JavaMelody auto-configuration (optional, default: true)
  enabled: true
  # Enable monitoring of Spring services and controllers (optional, default: true)
  spring-monitoring-enabled: true
  init-parameters:
    # restrict access to the monitoring page to the SBA server of ip address 192.168.1.1
    allowed-addr-pattern: 192\.168\.1\.1
    # log http requests
    #log: true
    # to exclude images, css, fonts and js urls from the monitoring:
    #url-exclude-pattern: (/webjars/.*|/css/.*|/images/.*|/fonts/.*|/js/.*)
    # to aggregate digits in http requests
    #http-transform-pattern: \d+
```

Latest javamelody version: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/net.bull.javamelody/javamelody-core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/net.bull.javamelody/javamelody-core)

License [ASL](http://www.apache.org/licenses/LICENSE-2.0)

This JavaMelody module is not currently compatible with Spring Boot Admin 2. Volunteers are welcome. But the [JavaMelody Spring Boot Starter](https://github.com/javamelody/javamelody/wiki/SpringBootStarter) is compatible with Spring Boot 2.
