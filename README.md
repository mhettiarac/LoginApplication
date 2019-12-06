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
docker container logs docker-whale

# Deply to EC2
Save the Docker image as a tar file:
docker save -o <tar file> <image name>
Copy your image to a new system with regular file transfer tools such as cp, scp or rsync(preferred for big files). 
After that you will have to load the image into Docker:
docker load -i <tar file>