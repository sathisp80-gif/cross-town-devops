#!/bin/sh
cd $PWD/cross-town-devops/ansible
ansible-playbook -i inventories/test/hosts main.yml --tags "webserver1-configuration" -v
cd -
