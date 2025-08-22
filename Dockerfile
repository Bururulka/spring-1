FROM tomcat
RUN rm -rf /usr/local/tomcat/webapps/*
COPY /target/root.war /usr/local/tomcat/webapps/


