
# jars

mkdir -p jars
cd jars

wget http://central.maven.org/maven2/aopalliance/aopalliance/1.0/aopalliance-1.0.jar
wget http://central.maven.org/maven2/commons-logging/commons-logging/1.2/commons-logging-1.2.jar 

wget http://central.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
wget http://central.maven.org/maven2/junit/junit/4.11/junit-4.11.jar

wget http://central.maven.org/maven2/org/springframework/spring-aop/4.1.5.RELEASE/spring-aop-4.1.5.RELEASE.jar
wget http://central.maven.org/maven2/org/springframework/spring-expression/4.1.5.RELEASE/spring-expression-4.1.5.RELEASE.jar

# automatic modules

cd ..
mkdir -p mjars
cd mjars

wget http://central.maven.org/maven2/com/google/guava/guava/18.0/guava-18.0.jar
mv guava-18.0.jar guava.jar

wget http://central.maven.org/maven2/org/springframework/spring-beans/4.1.5.RELEASE/spring-beans-4.1.5.RELEASE.jar 
mv spring-beans-4.1.5.RELEASE.jar spring-beans.jar

wget http://central.maven.org/maven2/org/springframework/spring-context/4.1.5.RELEASE/spring-context-4.1.5.RELEASE.jar 
mv spring-context-4.1.5.RELEASE.jar spring-context.jar

wget http://central.maven.org/maven2/org/springframework/spring-core/4.1.5.RELEASE/spring-core-4.1.5.RELEASE.jar 
mv spring-core-4.1.5.RELEASE.jar spring-core.jar

cd ..
echo "Ready."

