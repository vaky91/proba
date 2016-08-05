
# campus-pager

## About

Write a basic description of the project.

## Authors

Your individual and/or team names & e-mails go here.

## Usage

How to use it? APIs, GUIs, lib code snippets, etc.

## Docker build

Building of service docker image _is not_ enabled by default.

Activate `dockerBuild` maven profile to build service docker image at `package` phase.

Activate `dockerPush` maven profile to push built docker image to docker.ib-ci.com repo at `package` phase.

### Building on remote docker host

Use property `docker.build.host` to specify which docker host to use to build the image.
Host `http://ci-al-dock-2.infobip.local:4243` is used by default.

```
mvn clean verify -P dockerBuild
```

### Building on local machine

If you want to build image on your local machine using `DOCKER_HOST` environment variable then set `docker.build.host` to empty string:

```
mvn clean verify -Ddocker.build.host="" -P dockerBuild
```

### Pushing docker image to remote artifactory docker repo

To push docker image do artifactory activate `dockerPush` maven profile.

```
mvn clean verify -P dockerBuild -P dockerPush
```

**Note:** 
After docker images is pushed to remote docker repo it will be removed from build host. 
This is done to avoid piling up of built docker images on docker build host. 
Use `docker pull docker.ib-ci.com/imagename:tag` to pull built image from remote repo.

## Deployment Notes

### Using Deployment Manager

For standalone java app instance type set **script option**:

    * Option: -e 
    * Value: org.springframework.boot.loader.JarLauncher

### Docker deploy

Docker image is build and deployed to artifactory: https://ci-server.ib-inet.com/artifactory/webapp/#/artifacts/browse/tree/General/docker-local/

Inside container app is started using `infobip-remoting-template-service/docker/app/start.sh`.
You can use this to further customize service startup.

To start local docker container and connect to IO environment just type (expose other ports as needed):

```
docker run --rm -it -p 9090:9090 -p 3490:3490 -p 3491:3491 docker.ib-ci.com/infobip-remoting-template-service:version
```

In DM specify exposed ports and volumes using --DOCKER_PORT and --DOCKER_VOLUME in additional instance options:

```
--DOCKER_PORT 9090:9090
--DOCKER_PORT 3490:3490
--DOCKER_VOLUME /some/folder/on/host:/some/folder/in/container
...
```
