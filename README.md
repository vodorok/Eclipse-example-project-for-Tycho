# Eclipse example project for Tycho

[![Build Status](https://travis-ci.org/Vodorok/Eclipse-example-project-for-Tycho.svg?branch=master)](https://travis-ci.org/Vodorok/Eclipse-example-project-for-Tycho)

## Preface

__This is a work in progress project, treat it accordingly, suggestions, contributions, and corrections are very welcome.__

The project feature and plugin words are overloaded in this context, but I'll try to be as clear as I can get.

## Reasons

The main reason that this project was created, is that to be able to mimic the easy inclusion of 3rd party libs (that aren't available on p2 repositories), of maven dependency import.

## Goals

The goals of this project:

* An easy way to start (or to migrate) a project with Maven-Tycho with 3rd party libs with the following benefits:
* Be usable from the IDE as well as from terminal.
* Fully configured testing with unit and functional/gui testing.
* Easy integration with CI (Travis).
* Update-site.

The initial structure of the project is closely following the [vogella][vogell_ link] example project structure, but without a product project. Using the feature level is sufficient for eclipse plugins for publishing them on update sites.

## Requirements

* Apache Maven (reasonably new, 3.5.2 was on the dev machine).
* Tycho 1.3.0
* Eclipse NEON 3 (4.6.3) was used to generate the related projects.

## How To use

### Building

Type the following at the root of the project.

__before the build:__

```shell

cd ./mavendeps

mvn p2:site
mvn jetty:run (you should start in the background.)

```
_wait for the site to generate and the server to start._

__Then__

In the root of the project ```mvn clean verify```.

### Adding a non OSGi dependency for the plugins.

Extend the ```mavendeps/pom.xml``` 's ```<artifacts>``` section with a new artifact, as the following signature shows.

```xml 

<artifact><id>groupId:artifactId:version</id></artifact>

```

In this minimal example the ```DD Plist``` library was added. This could be it, but this lib has got a dependency on ```javax.xml.parsers```, so that also needs to be included, even though it's part of the standard JRE. For more information see [IBM's Guide][ibm_osgi_link] to OSGi.

You are not completely hopeless on which dependency needs to be included. Eclipse will notify you when an added dependency couldn't be resolved, in a target definition with this warning:
![alt text][target_error]

__BUT__

This is not everything. Your plugin will be buildable, and the IDE will see your dependencies. but for deploying your plugin, you should also specify your dependency in the update sites ```category.xml```. With this way the dependency will be included at compile time to the update-site, and therefore the mavendeps p2 site is not needed for deploying your plugin.


## Folder Structure

There is a brief explanation for every major part of the project.

(Excuse for the makeshift diff style color coding.)

```diff

 .
+├── bundles
-│   ├── example.plugin1                    │ In the bundles directory lie
-│   │   ├── bin                            │ the plugins. The plugins are
-│   │   │   └── example                    │ smallest coherent unit in the
-│   │   │       └── plugin1                │ eclipse universe.
-│   │   │           └── Activator.class
-│   │   ├── build.properties
-│   │   ├── .classpath
!│   │   ├── META-INF                       │ In pomless builds, the
!│   │   │   └── MANIFEST.MF                │ MANIFEST file regulates the
!│   │   │                                  │ maven build properties. (no pom)
-│   │   ├── .project
-│   │   ├── .settings
-│   │   │   └── org.eclipse.jdt.core.prefs
-│   │   └── src
-│   │       └── example
-│   │           └── plugin1
-│   │               └── Activator.java
+│   └── pom.xml                            │ pom only in the bundles folder
 │
!├── mavendeps                              | 3rd party dependencies needed to
!│   └── pom.xml                            | defined here.
 │
+├── features                               │ features are the smallest
-│   ├── example.feature                    │ deployable units, consisting of
-│   │   ├── build.properties               │ plugins.
!│   │   ├── feature.xml                    │ Features are also pomless.
-│   │   └── .project
+│   └── pom.xml                            │ Pom file only in the features.
 │
!├── .mvn                                   │ pomless  build setup gets
!│   └── extensions.xml                     │ specified here.
 │
+├── pom.xml                                │ There is a root project, with
+├── .project                               │ a root pom file.
 ├── README.md
+└── releng                                 │ The build config project, and the
+    │                                      │  update site project resides here
-    ├── example.configuration
-    │   ├── pom.xml
-    │   └── .project
#    ├── example.update                     │ The update site that publishes the
#    │   ├── category.xml                   │ that is configured to publish the
#    │   ├── pom.xml                        │ feature.
#    │   └── .project
+    └── pom.xml

```

## Useful links for better understanding the used concepts

* [The Project structure][vogella_link]
* [The plugin that creates the local update site][mvn_p2_link]
* [OSGi guidance][ibm_osgi_link]



[vogella_link]: http://www.vogella.com/tutorials/EclipseTycho/article.html
[mvn_p2_link]: https://github.com/reficio/p2-maven-plugin
[ibm_osgi_link]: https://www.ibm.com/support/knowledgecenter/en/SSGMCP_5.5.0/applications/developing/java/dfhpj_osgiframework.html

[target_error]: ./docs/img/target_def_error.png