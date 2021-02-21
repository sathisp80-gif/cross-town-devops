#!/bin/sh
home_dir=$PWD/cross-town-devops/scripts
for line in `cat $PWD/cross-town-devops/scripts/instance.cfg`
do
	IP=`aws ec2 describe-instances  --filters "Name=tag:Name,Values=$line" --query "Reservations[*].Instances[*].PublicIpAddress"   --output=text`

        sed -e "s/INSTANCE/$line/g"  $home_dir/template.json >$home_dir/$line.json
        if [[ "$?" != "0" ]]
        then
                echo "$me : sed replace INSTANCE FAILED";
                exit 503;
        fi

        sed -e "s/TODO/DELETE/g" $home_dir/${line}.json > $home_dir/${line}_1.json
        if [[ "$?" != "0" ]]
        then
                echo "$me : sed replace ACTION FAILED";
                exit 503;
        fi

        sed -e "s/IP/$IP/g" $home_dir/${line}_1.json > $home_dir/${line}.json

        if [[ "$?" != "0" ]]
        then
                echo "$me : sed replace IP FAILED";
                exit 503;
        fi

        rm $home_dir/${line}_1.json


        changeInfo=`aws route53 change-resource-record-sets --hosted-zone-id Z07954263O9R4Y0C94383 --change-batch file://$home_dir/${line}.json | jq -r '.ChangeInfo.Id'`;

        echo "Destroy $line instance starts:"
        cd $PWD/cross-town-devops/terraform/$line
        /usr/bin/terraform destroy -auto-approve

        if [ $? -ne 0 ]
        then
                echo "Destroy  failed:"$line
                exit 1;
        fi
        cd -
done
