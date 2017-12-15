# Core Search Play Seed
This template generates a skeleton Play Framework application with most of the dependencies and configurations that Core Search typically needs.
# Prerequisites
You must install Giter8 and SBT to use this template.
```sh
brew install giter8
brew install sbt
```
# Running
If you want to create a project
```sh
sbt new cbdr/core-search-play-seed.g8
```
You will be prompted to enter some variables
```sh
scala_version [2.12.2]:
scalatestplusplay_version [3.0.0]: 
play_version [2.6.0]: 
```
If you do not enter your own values, the defaults in the brackets will be used (you should definitely override the name).

For even faster project generation
```sh
sbt new cbdr/core-search-play-seed.g8 --name=my-awesome-play-app
```
This will forgo the prompts and create your Play app with the name _my-awesome-play-app_ with the default values for the other parameters.
# Recommended Usage
This template is designed for basic project setup.
Your Play Framework application probably does not require every library and configuration included in this repo.
In fact, it is highly unlikely. During your productionization process (or earlier), be sure to remove all unneeded
dependencies and configurations. Remember that includes the configurations made in your production.conf stored in S3.

# What's Included
* ScalaTest
* Mockito
* Akka TestKit (Akka is automatically included with Play)
* Play Slick
* Slick Extensions
* MySQL Driver
* AWS SDK

### Database Configurations
The following tables are configured for Aurora and MS SQL in US Staging, United States, and the European Union.
* SearchData
* SearchRefeed
* SearchFeed
* SearchTrans

Reference [the configuration file][4] for specific naming of each connection.

### Configuration
The production config file can be found in S3: framework-secrets/play-seed

_Note: This file should be used as a template and not as the actual production config file for your application._

# Deployment

### AWS ECS
The following steps will guide to the the process of setting up a Jenkins build job for your application and creating the jobs for deploying the application into the search team AWS ecs cluster.

#### Setup jenkins CI build
Go to https://jenkins.cloudops.careerbuilder.com/job/Shared/job/CIJobMaker/ and click on build with parameters where and set the values: JobPath: Search/search-seed(replace with the name you during the instance creation)/Build the other parameters are self explanatory, that will create a pull request at: https://github.com/cbdr/CloudOps which you need cloudops to approve and a build job will be added to https://jenkins.cloudops.careerbuilder.com/job/Search/ . Additional information can be found at:https://github.com/cbdr/CloudOps/blob/master/Jenkins/Readme.md 

Note: Make sure the application generated is added into the cbdr github account, and add the repo to Search team as a collaborator admin, also a webhook to https://jenkins.cloudops.careerbuilder.com/github-webhook/ should be added to auto trigger builds on push.

#### Setup jenkins jobs to deploy the application into the search ECS clusters
Follow the instructions at :https://github.com/cbdr/CloudOps/blob/master/Documentation/ECS.md to create and run the jenkins deployment jobs for all your production environments.

##### Adding application configurations per environment
Play configuration files can be customized using environment variables/and amazon parameter store. Review https://github.com/cbdr/CloudOps/blob/master/Documentation/ECS.md#configuration-and-secret-storage-for-ecs-applications for more information, just think that parameters at the parameter store are set as environment variables for the docker container and the play application may use it on it's configurations by setting it as \${?VARIABLE_NAME} on any play application configuration file (https://www.playframework.com/documentation/2.6.x/ProductionConfiguration#Using-environment-variables)

##### Database configurations required by the seed generated application
Add the AURORA_USER, AURORA_PASSWORD and AURORA_URL environment variables to the parameter store

##### New relic configurations required by the seed generated application
Add the NEWRELIC_KEY and NEWRELIC_APPNAME environment variables to the parameter store.

##### Production configurations
Configurations regarding healthcheck, containers autoscale and container resources required can be found at: https://github.com/cbdr/CloudOps/tree/master/terraform/search the main.tf of each environment of your application hosts those configurations.

Instances hosting ECS can be customized at: https://github.com/cbdr/CloudOps/blob/cb76dc6d22cf6fcb8a00e66db1c6c8be0aae4df0/Jenkins/Config/ECSClusters.json

### Nimbus(deprecated)
There is a [Nimbus template][1] for a typical Play Framework application and an example [Nimbus settings file][2] that you can reference.

### Chef(deprecated)
There is an [example Chef cookbook][3] that is referenced in the Nimbus file. It should get you most of the way to deployment, but you should make your own and use this as just a reference.

[1]: https://github.com/cbdr/TODO  "Play seed Nimbus template"
[2]: https://github.com/cbdr/TODO  "Play seed Nimbus settings file"
[3]: https://github.com/cbdr/TODO  "Play seed Chef cookbook"
[4]: https://github.com/cbdr/core-search-play-seed.g8/blob/master/src/main/g8/conf/application.conf "Play seed configuration file"

