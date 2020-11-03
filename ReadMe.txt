Camel Java Router Project
=========================

To build this project use

    mvn install

To run this project from within Maven use

    mvn exec:java


To run on camel K
=================

Using mysql DB Driver

kamel run --dev --property-file src/main/resources/application.properties -d mvn:mysql:mysql-connector-java:8.0.22 -d mvn:org.apache.commons:commons-dbcp2:2.8.0 src/main/java/org/example/MyRouteBuilder.java

