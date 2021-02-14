#!/bin/sh
for line in `cat instance.cfg`
do
        echo "Destroy Database instance starts:"$line
        cd ../terraform/$line
        /usr/bin/terraform destroy -auto-approve

        if [ $? -ne 0 ]
        then
                echo "Destroy  failed:"$line
                exit 1;
        fi
        cd -
done
