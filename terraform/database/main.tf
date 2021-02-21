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


resource "aws_route53_zone" "database_testondemand_ga" {
name          = "database.testondemand.ga."
comment       = "Managed by Terraform, NS delegate for third party provider"
force_destroy = false
tags {
ManagedBy = "Terraform"
}
}

resource "aws_route53_record" "database_testondemand_ga_zone_ns_record" {
zone_id = "${aws_route53_zone.testondemand_com.Z07954263O9R4Y0C94383}"
name    = "database"
type    = "NS"
records = ["ns-477.awsdns-59.com", "ns-563.awsdns-06.net"] ttl     = "86400" 
} 
resource "aws_route53_record" "database_testondemand_ga_zone_default_ns_record" { 
zone_id = "${aws_route53_zone.testondemand_com.Z07954263O9R4Y0C94383}" 
type    = "NS" 
name    = "database.testondemand.ga" 
records = ["ns-477.awsdns-59.com.", "ns-563.awsdns-06.net."] ttl     = "86400" 
}

