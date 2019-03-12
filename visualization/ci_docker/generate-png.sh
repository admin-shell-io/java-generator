#!/bin/sh

### This script has to be executed in the Docker container!

OLDPWD=$PWD
cd "$(dirname "$0")"
cd ../../   # switch to ids-infomodel-codegen main dir
mvn clean package -P CI -pl :visualization -s bamboo-config/maven-settings.xml
cd visualization
export PLANTUML_LIMIT_SIZE=16384
java -Djava.awt.headless=true -jar /usr/share/plantuml/plantuml.jar all_classes.plantuml