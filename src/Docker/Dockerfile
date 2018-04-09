FROM tomcat:8-jre8-slim
#FROM openjdk:8
#FROM tomcat:8.0.20-jre8
ADD epidemics-web.jar /usr/local/tomcat/webapps/app.jar
COPY . /
RUN bash -c 'touch /app.jar'
RUN bash -c 'chmod +x /wrapper.sh'
CMD ["catalina.sh", "run"]
ENTRYPOINT ["/bin/bash", "/wrapper.sh"]