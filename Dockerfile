FROM jboss/wildfly:24.0.0.Final

COPY config/add-jdk-net-module.cli /opt/jboss/wildfly
RUN /opt/jboss/wildfly/bin/jboss-cli.sh --file=/opt/jboss/wildfly/add-jdk-net-module.cli
RUN rm -rf /opt/jboss/wildfly/standalone/configuration/standalone_xml_history

COPY target/jnosql-demo.war /opt/jboss/wildfly/standalone/deployments
