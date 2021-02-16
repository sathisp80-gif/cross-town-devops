terraform {
  backend "s3" {
    bucket = "sathisp"
    key    = "database/terraform.tfstate"
    region = "us-east-1"
  }
}