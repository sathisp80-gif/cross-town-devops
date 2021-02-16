# ansible-install-docker
ansible script to install docker:
ansible -i inventories/test/hosts -m ping all
ansible-playbook -i inventories/test/hosts main.yml
