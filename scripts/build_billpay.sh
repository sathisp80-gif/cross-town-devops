#!/bin/sh
cd $PWD/cross-town-devops/services/bill-pay
mvn clean package -DskipTests
cd -
