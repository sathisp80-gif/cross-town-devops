#!/bin/sh
cd $PWD/cross-town-devops/services/bill-pay
docker build -t bill-pay .
docker save -o bill-pay.tar bill-pay
cp bill-pay.tar /tmp/bill-pay.tar
cd -
