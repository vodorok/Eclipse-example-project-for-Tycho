# Eclipse example project for Tycho

## Preface 

__This is a work in progress project, treat it accordingly, suggestions, contributions, and corrects are very welcome.__

The project feature and plugin words are overloaded in this context, but I'll try to be as clear as I can get.

## Reasons

The main reason that this project was created, is that to be able to mimic the easy inclusion of 3rd party libs (that aren't available on p2 repositories), of maven dependency import.

## Goals

The goals of this project:

* An easy way to start (or to migrate) a project with Maven-Tycho with 3rd party libs with the following benefits:
* Be usable from the IDE as well as from terminal.
* Fully configured testing with unit and functional/gui testing.
* Easy integration with CI (Travis.).
* Update-site.

The initial structure of the project is closely following the [vogella][vogella link] example project structure, but without a product project. Using the feature level is sufficient for eclipse plugins for publishing them on update sites.

## Requirements

* Apache Maven (reasonably new, 3.5.2 was on the dev machine).
* Tycho 1.3.0
* Eclipse NEON 3 (4.6.3) was used to generate the related projects.

## Build

type the following at the root of the project 

```mvn clean verify```

## Folder Structure

There is a brief explanation for every major part of the project

```bash

.
├── bundles                             /* In the bundles directory lie
│   ├── example.plugin1                  * the plugins. The plugins are 
│   │   ├── bin                          * smallest coherent unit in the 
│   │   │   └── example                  * eclipse universe. */
│   │   │       └── plugin1
│   │   │           └── Activator.class
│   │   ├── build.properties
│   │   ├── .classpath
│   │   ├── .gitignore
│   │   ├── META-INF                    /* In pomless builds, the 
│   │   │   └── MANIFEST.MF              * MANIFEST file regulates the
│   │   ├── .project                     * maven build properties. */
│   │   ├── .settings
│   │   │   └── org.eclipse.jdt.core.prefs
│   │   └── src
│   │       └── example
│   │           └── plugin1
│   │               └── Activator.java
│   └── pom.xml                         /* only in the bundles folder */
│
│
├── features                            /* features are the smallest
│   ├── example.feature                  * deployable units, consiting
│   │   ├── build.properties             * of plugins. 
│   │   ├── feature.xml                  * Features are also pomless. */
│   │   └── .project
│   └── pom.xml                         /* only in the root fetures */
│
├── .mvn                                /* pomless  build setup gets
│   └── extensions.xml                   * specified here. */
│
├── pom.xml                             /* There is a root project, with
├── .project                             * a root pom file. */
├── README.md
└── releng                              /* The build config project, and
    └── example.configuration            * its pom lives here. */
        ├── pom.xml
        └── .project

```

## Useful links for better understanding the used concepts

* [The Project structure][vogella link]
* [The plugin that creates the local update site][mvn p2 link]



[vogella link]: http://www.vogella.com/tutorials/EclipseTycho/article.html
[mvn p2 link]: https://github.com/reficio/p2-maven-plugin