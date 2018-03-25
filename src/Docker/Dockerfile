FROM tomcat:8-jre8-slim
#FROM openjdk:8
#FROM tomcat:8.0.20-jre8
ADD epidemics-web.war /usr/local/tomcat/webapps/app.war
COPY . /
RUN bash -c 'touch /app.war'
RUN bash -c 'chmod +x /wrapper.sh'
CMD ["catalina.sh", "run"]
ENTRYPOINT ["/bin/bash", "/wrapper.sh"]
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/app.war"]
# $ java -jar -Dspring.profiles.active=production demo-0.0.1-SNAPSHOT.war
