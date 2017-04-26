# Core Search Play Seed
Skeleton Play Framework application with most of the dependencies and configurations that Core Search typically needs

# Recommended Usage
This repo is designed for forking and referencing for basic project setup.
Your Play Framework application probably does not require every library and configuration included in this repo.
In fact, it is highly unlikely. During your productionization process (or earlier), be sure to remove all unneeded
dependencies and configurations. Remember that includes the configurations made in your production.conf stored in S3.


# What's Included
* ScalaTest
* Mockito
* Akka TestKit (Akka is automatically included with Play)
* ScalaJ-HTTP
* Play Slick
* Play Slick Evolutions
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

### Nimbus
There is a [Nimbus template][1] for a typical Play Framework application and an example [Nimbus settings file][2] that you can reference.

### Chef
There is an [example Chef cookbook][3] that is referenced in the Nimbus file. It should get you most of the way to deployment, but you should make your own and use this as just a reference.

[1]: https://github.com/cbdr/TODO  "Play seed Nimbus template"
[2]: https://github.com/cbdr/TODO  "Play seed Nimbus settings file"
[3]: https://github.com/cbdr/TODO  "Play seed Chef cookbook"
[4]: https://github.com/cbdr/core-search-play-seed/blob/master/conf/application.conf "Play seed configuration file"
