provider "aws" {
    region = "us-east-2"
}

resource "aws_instance" "devops_01" {
    ami = "ami-0996d3051b72b5b2c"
    instance_type = "t2.micro"
    key_name = "crosstown"

    tags = {
        Name = "webserver2"
    }

    provisioner "local-exec" {
    command = "echo ${aws_instance.devops_01.private_ip} >> private_ips.txt"
  }
}