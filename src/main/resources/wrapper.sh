#!/bin/bash
while ! exec 6<>/dev/tcp/${FHIR_HOST}/${FHIR_PORT}; do
    echo "Trying to reach FHIR server at ${FHIR_HOST}:${FHIR_PORT}..."
    sleep 5
done
echo ">> FHIR server is now REACHABLE! <<"
while ! exec 6<>/dev/tcp/${DATABASE_HOST}/${DATABASE_PORT}; do
    echo "Trying to connect to MySQL at ${DATABASE_HOST}:${DATABASE_PORT}..."
    sleep 5
done
echo ">> connected to MySQL database! <<"
echo ">> Starting web server <<"
java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /usr/local/tomcat/webapps/app.war
