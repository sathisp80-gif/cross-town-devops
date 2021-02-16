!#/bin/sh
cd $PWD/cross-town-devops/ansible
ansible-playbook -i $PWD/cross-town-devops/ansible/inventories/test/hosts main.yml
cd -
