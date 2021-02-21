provider "aws" {
    region = "us-east-2"
}

resource "aws_instance" "devops_01" {
    ami = "ami-02ac93c05ae3662c5"
    instance_type = "t2.micro"
    key_name = "crosstown"

    tags = {
        Name = "database"
    }
}

resource "aws_route53_record" "database" {
zone_id = aws_route53_zone.testondemand.Z07954263O9R4Y0C94383
name = "www.testondemand.ga"
type = "A"
ttl = "300"

weighted_routing_policy {
weight = 10
}

set_identifier = "database"
records = ["database.testondemand.ga"]
}

output "name_server" {
	value=aws_route53_zone.easy_aws.name_servers
}
