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


resource "aws_route53_zone" "testondemand" {
    name = "testondemand.ga"
    comment =""
  }

resource "aws_route53_record" "database" {
zone_id = aws_route53_zone.testondemand.Z07954263O9R4Y0C94383
name = "database.testondemand.ga"
type = "A"
ttl = "300"
records = [devops_01.database.public_ip]
}

