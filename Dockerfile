FROM jboss/wildfly

COPY ${PWD}/target/read.war /opt/jboss/wildfly/standalone/deployments/read.war