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

/**
resource "aws_route53_zone" "main" {
  name = "testondemand.ga"
}

resource "aws_route53_zone" "database" {
  name = "database.testondemand.ga"

  tags = {
    Environment = "database"
  }
}

resource "aws_route53_record" "database-ns" {
  zone_id = aws_route53_zone.main.Z07954263O9R4Y0C94383
  name    = "database.testondemand.ga"
  type    = "NS"
  ttl     = "30"
  records = aws_route53_zone.database.ns-477.awsdns-59.com.
}
**/


