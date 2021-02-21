#!/bin/sh
cd $PWD/cross-town-devops/services/transaction-statement
docker build -t transaction-statement .
docker save -o transaction-statement.tar transaction-statement
cp transaction-statement.tar /tmp/transaction-statement.tar
cd -
