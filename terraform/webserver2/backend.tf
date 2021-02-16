terraform {
  backend "s3" {
    bucket = "sathisp"
    key    = "webserver2/terraform.tfstate"
    region = "us-east-1"
  }
}