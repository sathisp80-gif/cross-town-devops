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

