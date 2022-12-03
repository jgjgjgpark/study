# install docker

``` bash
sudo apt-get update
sudo apt-get install -y ca-certificates curl gnupg lsb-release
# skipped from here
```

# run docker hello world

``` bash
docker run hello-world
```
# docker application

``` bash
docker search mongo
docker run mongo
```
# building docker images

``` bash
docker run -it ubuntu:20.04 /bin/bash
apt-get update
apt-get install -y git
exit
docker commit ${container_id} ubuntu_with_git
docker images
```
# create docker application
## create python app

``` python
import os
print(f"hello {os.environ['NAME']}")
```

## docker file
``` dockerfile
FROM ubuntu:20.04
RUN apt-get update && \
    apt-get install -y python
ENV NAME jonggul
COPY hello.py .
ENTRYPOINT ["python", "hello.py"]
```
## build

``` bash
docker build -t ubuntu_with_python .
docker images
docker run -e NAME=park ubuntu_with_python
```
## docker networking

``` bash
docker run -d tomcat
docker logs ${container_id}
ifconfig docker0
```
## docker volume

``` bash
docker run -it -v ~/docker_ubuntu:/host_dir ubuntu:20.04 /bin/bash
touch /host_dir/test.txt
exit
ls ~/docker_ubuntu
```
## using names in docker

``` bash
docker run -d --name tomcat tomcat
docker stop tomcat
```

## docker clean up

``` bash
docker rm ${container_id}
docker container prune
docker run --rm hello-world
docker images
docker image prune -a
```






