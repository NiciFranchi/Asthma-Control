FROM openjdk:8
ADD epidemics-web.jar app.jar
COPY . /
RUN bash -c 'touch /app.jar'
RUN bash -c 'chmod +x /wrapper.sh'
ENTRYPOINT ["/bin/bash", "/wrapper.sh"]
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/app.jar"]
# $ java -jar -Dspring.profiles.active=production demo-0.0.1-SNAPSHOT.jar