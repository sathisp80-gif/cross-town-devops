#!/bin/sh
for line in `cat $PWD/cross-town-devops/scripts/instance.cfg`
do
        echo "Destroy Database instance starts:"$line
        cd $PWD/cross-town-devops/terraform/$line
        /usr/bin/terraform destroy -auto-approve

        if [ $? -ne 0 ]
        then
                echo "Destroy  failed:"$line
                exit 1;
        fi
        cd -
done
