terraform {
  backend "s3" {
    bucket = "sathisp"
    key    = "webserver1/terraform.tfstate"
    region = "us-east-1"
  }
}