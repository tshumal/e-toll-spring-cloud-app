FROM fabric8/java-jboss-openjdk8-jdk:1.2.4

MAINTAINER Lingani Tshuma <tshumal@gmail.com.com>

ENV JAVA_APP_JAR e-toll-config-server.jar
ENV AB_OFF true

EXPOSE 8888

ADD target/$JAVA_APP_JAR /deployments/