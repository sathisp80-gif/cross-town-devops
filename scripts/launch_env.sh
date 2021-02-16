#!/bin/sh

for line in `cat $PWD/cross-town-devops/scripts/instance.cfg`
do
        echo "Launch $line instance Starts";
        cd $PWD/cross-town-devops/terraform/$line
        /usr/bin/terraform init -input=false
        if [ $? -ne 0 ]
        then
                echo "Terraform Int failed for the instance :" $line
        fi
        /usr/bin/terraform apply -input=false -auto-approve
         if [ $? -ne 0 ]
         then
                 echo "Terraform apply failed for the instance :"$line
                 exit 1;
         fi
         cd -
done