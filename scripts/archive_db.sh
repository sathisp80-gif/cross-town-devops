#!/bin/sh
cd $PWD/cross-town-devops/database
tar cvf transaction.tar transaction
cp  transaction.tar /tmp/
cd -
