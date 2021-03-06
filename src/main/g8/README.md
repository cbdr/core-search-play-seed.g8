# $name$ 
Explain what is the purpose of the application

## Local Build Instructions

### Run the application inside a local docker container

#### Run Set Up docker steps

https://careerbuilder.atlassian.net/wiki/spaces/CRS/pages/18684493/Set+up+and+how-to+for+running+our+Docker+apps+like+production

Note make sure you add your AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY variables to the bash profile. So the docker container can use your AWS resources.

#### Run commands to compile the app and run inside a local docker container

The following will compile the app and run it inside a local docker container. This is good to catch environment problems before moving on to production and simulate a real production environment.

```sh
sbt clean stage
docker build -t $name$ .
docker run -e AURORA_URL='jdbc:mysql://HOST:PORT' -e AURORA_USER='USER' -e AURORA_PASSWORD='PWD' -p 80:80 $name$ 
```

You can see the application running at: http://localhost/

Note: If you see a new relic error don't worry, or if you want to send data from your local container just add the NEWRELIC_KEY and NEWRELIC_APPNAME environment variables.

### Run the application on your local server

This is the recommended aproach during development stages

```sh
sbt run -DAURORA_URL=jdbc:mysql://HOST:PORT -DAURORA_USER=USER -DAURORA_PASSWORD=PWD
```

You can see the application running at: http://localhost:9000/

## Build and deploy process for CI

The following link has the information required: https://github.com/cbdr/core-search-play-seed.g8#deployment
