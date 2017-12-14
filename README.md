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
name [core-search-play-seed]:
scala_version [2.11.11]:
scalatestplusplay_version [2.0.0]: 
play_version [2.5.14]: 
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

#### Setup jenkins CI build
Follow the instructions at :https://github.com/cbdr/CloudOps/blob/master/Jenkins/Readme.md to add a jenkins job for building your application and publishing an artifact of your appliction into dockerhub.

#### Setup jenkins jobs to deploy the application into the search docker clusters
Follow the instructions at :https://github.com/cbdr/CloudOps/blob/master/Documentation/ECS.md to create and run the jenkins deployment jobs.

#### Production configurations
Containers resources 

### Nimbus(deprecated)
There is a [Nimbus template][1] for a typical Play Framework application and an example [Nimbus settings file][2] that you can reference.

### Chef(deprecated)
There is an [example Chef cookbook][3] that is referenced in the Nimbus file. It should get you most of the way to deployment, but you should make your own and use this as just a reference.

[1]: https://github.com/cbdr/TODO  "Play seed Nimbus template"
[2]: https://github.com/cbdr/TODO  "Play seed Nimbus settings file"
[3]: https://github.com/cbdr/TODO  "Play seed Chef cookbook"
[4]: https://github.com/cbdr/core-search-play-seed.g8/blob/master/src/main/g8/conf/application.conf "Play seed configuration file"

