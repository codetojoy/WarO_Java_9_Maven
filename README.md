### WarO_Java_9_Maven

* derived from [this project](https://github.com/cfdobber/maven-java9-jigsaw)
* example illustration building JDK 9 modules with Maven

### Prerequisites

* JDK 9 b170+
* Maven 3.5.0+

### Build steps

* Right now, game configuration is simply defined in code. In `org.peidevs.waro.base` modules, edit `org.peidevs.waro.config.impl.Config.java`
* `mvn clean package`

### Steps to run game

* `./prepare.sh`
* `./run_waro_main.sh`

### WarO_Java_9

WarO is a code kata based on a simple card game. Rules are documented [here](https://github.com/peidevs/WarO_Java/blob/master/README.md).

### Java 9 Features 

* This example contains 3 modules. They are somewhat arbitrary, as this project was
written without modules in mind.
* org.peidevs.waro.base
    * requires Spring "automatic modules"
    * exports several utility packages
* org.peidevs.waro.function
    * requires `org.peidevs.waro.base` and Guava automatic module
    * exports functional packages 
* org.peidevs.waro.main
    * requires `org.peidevs.waro.base` and `org.peidevs.waro.function`
