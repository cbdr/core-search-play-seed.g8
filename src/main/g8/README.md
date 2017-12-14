# Search Document Service Template
Brief description of the seed application

## Local Build Instructions

### Run the application inside a local docker container

#### Run Set Up docker steps

https://careerbuilder.atlassian.net/wiki/spaces/CRS/pages/18684493/Set+up+and+how-to+for+running+our+Docker+apps+like+production

Note make sure you add your AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY variables to the bash profile. So the docker container can use your AWS resources.

#### Run comands to compile the app and run inside a local docker container

The following will compile the app and run it inside docker, you will need to to setup the jenkins CI job before, see https://github.com/cbdr/core-search-play-seed.g8#setup-jenkins-ci-build

```sh
sbt clean stage
docker run -e AURORA_URL='jdbc:mysql://HOST:PORT' -e AURORA_USER='USER' -e AURORA_PASSWORD='PWD' -p 80:80 $name$ 
```

## Production configurations

### Adding application configurations per environment

Play configuration files can be customized using environment variables/and amazon parameter store. Review https://github.com/cbdr/CloudOps/blob/master/Documentation/ECS.md#configuration-and-secret-storage-for-ecs-applications for more information, just think that parameters at the parameter store are set as environment variables for the docker container and the play application may use it on it's configurations by setting it as \${?VARIABLE_NAME} on any play application configuration file (https://www.playframework.com/documentation/2.6.x/ProductionConfiguration#Using-environment-variables)

### Database configurations 

Add the AURORA_USER, AURORA_PASSWORD and AURORA_URL environment variables to the parameter store

### New relic configurations

Add the NEWRELIC_KEY and NEWRELIC_APPNAME environment variables to the parameter store.