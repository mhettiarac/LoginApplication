# Run locally
To run the application use following cmd:
mvn spring-boot:run

# Run using Docker 

To run the docker:
start docker

To create the docker image:
docker build -t docker-whale -f Dockerfile.txt .

Run the above image as a container:
docker container run --name login -p 8080:8080 -d docker-whale

Check the logs in the docker container:
docker container logs login

# Deply to EC2

Save the Docker image as a tar file:
docker save -o <tar file> <image name>

Copy your image to a new system with regular file transfer tools such as cp, scp or rsync(preferred for big files). 

After that you will have to load the image into Docker:
docker load -i <tar file>


# Attach JaCoCo Agent when Using Docker

You need to have downloaded both `jacocoagent.jar` and `jacococli.jar` before executing below commands

Go to ```DockerfileWithJacoco.txt``` file and update following line to point to jacocoagent.jar

```COPY <path-to-jacoco-agent>/jacocoagent.jar .```

To run the docker:
```
start docker
```

Compile project
```
mvn clean install
```

To create the docker image:
```
docker build -t demoappwithjacoco -f DockerfileWithJacoco.txt .
```

Run the above image as a container:
```
docker container run --name loginappwithjacoco -p 8080:8080 -p 9999:9999 -d demoappwithjacoco
```


**In test project** - To run functional tests:
```
mvn clean install -Dmaven.test.failure.ignore=true
```

To create JaCoCo report:
```
java -jar jacococli.jar report <path-to-integration-tests-repo>\IntegrationTest\target\jacocotogo\myserver_jacoco.exec --classfiles <path-to-classfiles-in-sample-app>\LoginApplication\target\classes\com --sourcefiles <path-to-source-files-in-sample-app>\LoginApplication\src\main\java --html <report-dir-name>
```
