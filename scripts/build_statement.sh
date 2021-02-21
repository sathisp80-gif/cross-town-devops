#!/bin/sh
cd $PWD/cross-town-devops/services/transaction-statement
mvn clean package -DskipTests
cd -
