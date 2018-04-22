# Asthma-Control

### Docker Environment
- Current Docker version 18.03.0-ce, build 0520e24
- Current docker-compose version 1.18.0, build 8dd22a9


### Clone repo

```
$ git clone https://github.gatech.edu/gt-hit-spring2018/Asthma-Control.git
$ cd Asthma-Control/
```
### Point to desired FHIR Server URL
Navigate to [/src/main/resources/application.properties](https://github.gatech.edu/gt-hit-spring2018/Asthma-Control/blob/a724728af680a61f3596313ecb61e04713e0925a/src/main/resources/application.properties#L20-L25) and replace fhir_baseUrl config parameter with desired parameter 
```
fhir_baseUrl=http://localhost:8080/baseDstu3
```

### Running the Application
The project can be run either in docker, or locally.

#### A) Run in docker:

```
# docker maven build
$ mvn clean package docker:build

# start project
$ docker-compose up 
```

#### B) Test/Run locally

- run MySQL docker container

    ```
    $ docker run \
        -e MYSQL_ROOT_PASSWORD=p4$$W0rd \
        -e MYSQL_DATABASE=epidemics \
        -e MYSQL_USER=epidemics \
        -e MYSQL_PASSWORD=epidemics \
        -p 3306:3306 \
        --name mysql \
        --mount type=bind,source=/home/atalati/Documents/Asthma-Control/database/,target=/docker-entrypoint-initdb.d \
        mysql
    ```

- run FHIR docker container

    ```
    $ docker run
        -p 8080:8080 \
        --name fhir \
        johnson325/hapi-fhir-jpaserver:stu3-ext-6-patient
    ```

- After the MySQL is up, run following command to start the web server

    ```
    # local maven build
    $ mvn clean package
    
    # run web server locally (profiles.active=local)
    java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=local -jar target/epidemics-web.jar
    ```

_Web App URL [http://localhost:8081/](http://localhost:8081/)_

_Local FHIR Server URL [http://localhost:8080/](http://localhost:8080/)_
