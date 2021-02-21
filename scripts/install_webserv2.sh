#!/bin/sh
cd $PWD/cross-town-devops/ansible
ansible-playbook -i inventories/test/hosts main.yml --tags "webserver2-configuration" -v
cd -
