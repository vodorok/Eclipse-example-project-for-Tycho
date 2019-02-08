# Eclipse example project for Tycho

## This is a work in progress project, treat it accordingly, suggestions, contributions, and corrects are very welcome.

## Reasons

The main reason that this project was created, is that to be able to mimic the easy inclusion of 3rd party libs (that aren't available on p2 repositories), of maven dependency import.

## Goals

The goals of this project:

* An easy way to start (or to migrate) a project with Maven-Tycho with 3rd party libs with the following benefits:
* Be usable from the IDE as well as from terminal.
* Fully configured testing with unit and functional/gui testing.
* Easy integration with CI (Travis.).
* Update-site.

The initial structure of the project is closely following the [vogella](http://www.vogella.com/tutorials/EclipseTycho/article.html) example project structure, but without a product project. Using the feature level is sufficient for eclipse plugins for publishing them on update sites.

## Requirements

* Maven (reasonably new)
* Tycho 1.3.0