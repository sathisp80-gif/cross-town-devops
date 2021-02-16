#!/bin/sh
for line in `cat $PWD/cross-town-devops/scripts/instance_ip.cfg`
do
	echo $line
	instance_name=`echo $line|cut -d'=' -f1`
	if [ "$instance_name" = "database" ]
	then
		DATABASE=`echo $line | cut -d'=' -f2`
	fi
	if [ "$instance_name" = "webserver1" ]
	then
		WEBSERVER1=`echo $line | cut -d'=' -f2`;
	fi
	if [  "$instance_name" = "webserver2" ]
	then
		WEBSERVER2=`echo $line | cut -d'=' -f2`;
	fi

done
cat $PWD/cross-town-devops/ansible/ssh.cfg.template | sed -e "s/DATABASE/$DATABASE/g" >  $PWD/cross-town-devops/ansible/ssh.cfg.1
cat $PWD/cross-town-devops/ansible/ssh.cfg.1 | sed -e "s/WEBSERVER1/$WEBSERVER1/g"  >  $PWD/cross-town-devops/ansible/ssh.cfg.2
cat $PWD/cross-town-devops/ansible/ssh.cfg.2 | sed -e "s/WEBSERVER2/$WEBSERVER2/g"  >  $PWD/cross-town-devops/ansible/ssh.cfg
rm $PWD/cross-town-devops/ansible/ssh.cfg.2
rm $PWD/cross-town-devops/ansible/ssh.cfg.1
