# LoginApplication
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
