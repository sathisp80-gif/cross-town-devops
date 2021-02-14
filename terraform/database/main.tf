provider "aws" {
    region = "us-east-1"
}

resource "aws_instance" "devops_01" {
    ami = "ami-04b9e92b5572fa0d1"
    instance_type = "t2.micro"
    key_name = "devops"

    tags = {
        Name = "db-instance"
    }
}

