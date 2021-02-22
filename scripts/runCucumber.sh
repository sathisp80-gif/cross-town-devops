#!/bin/sh
cd $PWD/cross-town-devops/qa/api-test-suite
mvn clean verify -DforkCount=0 -DreuseForks=false -Dtest=RunCucumberTest.java
cd -
