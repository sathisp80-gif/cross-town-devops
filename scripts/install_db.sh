#!/bin/sh
cd $PWD/cross-town-devops/ansible
ansible-playbook -i inventories/test/hosts main.yml --tags "db-configuration" -v
cd -
