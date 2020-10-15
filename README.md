### WarO_Java_9_Maven

* derived from [this project](https://github.com/cfdobber/maven-java9-jigsaw)
* example illustration building JDK 9 modules with Maven

### WarO_Java_9

WarO is a simple card game; the rules are documented [here](https://github.com/peidevs/WarO_Java/blob/master/Rules.md). The game is a [popular](https://github.com/peidevs/Resources/blob/master/Examples.md) exercise for members of the [Prince Edward Island (PEI) Developers](http://peidevs.github.io) user group to illustrate various technologies.

### Java 9 Features 

* This example contains 3 modules. They are somewhat arbitrary, as this project was
written without modules in mind.
* Overview:

<img style="float: center;" src="https://github.com/codetojoy/WarO_Java_9_Maven/blob/master/images/module_diagram_WarO.png"></img>

* `org.peidevs.waro.base`
    * requires Spring "automatic modules"
    * exports several utility packages
    * see module-info.java [here](https://github.com/codetojoy/WarO_Java_9_Maven/blob/master/org.peidevs.waro.base/src/main/java/module-info.java)
* `org.peidevs.waro.function`
    * requires `org.peidevs.waro.base` and Guava automatic module
    * exports functional packages 
    * see module-info.java [here](https://github.com/codetojoy/WarO_Java_9_Maven/blob/master/org.peidevs.waro.function/src/main/java/module-info.java)
* `org.peidevs.waro.main`
    * requires `org.peidevs.waro.base` and `org.peidevs.waro.function`
    * see module-info.java [here](https://github.com/codetojoy/WarO_Java_9_Maven/blob/master/org.peidevs.waro.main/src/main/java/module-info.java)

### Prerequisites

* JDK 9 b170+
* Maven 3.5.0+

### Build steps

* Right now, game configuration is simply defined in code. In `org.peidevs.waro.base` modules, edit `org.peidevs.waro.config.impl.Config.java`
* `mvn clean package`

### Steps to run game

* `./prepare.sh`
* `./run_waro_main.sh`

### Notes

* Unit tests now run! I believe due to resolution of [this JIRA issue](https://issues.apache.org/jira/projects/MCOMPILER/issues/MCOMPILER-294?filter=allopenissues).
* I'm a newbie with Maven (I'm more comfortable with Gradle). I'm sure there is a way to run the app using Maven, but for now, I use scripts to setup the runtime environment and run the app.
    * [This doc](http://www.mojohaus.org/exec-maven-plugin/examples/example-exec-for-java-programs.html) for the Exec Maven Plugin looks promising, but I couldn't get it to work. I encountered [this issue](https://github.com/mojohaus/exec-maven-plugin/issues/83). 


