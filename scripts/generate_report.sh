#!/bin/sh
root_dir=$PWD
home_dir=$PWD/cross-town-devops/scripts
cd $home_dir
git clone https://github.com/sathisp80-gif/crosstown-reports.git
mkdir -p crosstown-reports//`date +%d%m%Y-%HH%MM` && cp -rf ../qa/api-test-suite/target/site/cucumber-reports/cucumber-html-reports/* "$_"
cd crosstown-reports
bash generate_report.sh
find * -type d -ctime +10 -exec rm -rf {} \;
git config --global user.name "sathisp80-gif"
git add .
git commit -m "Added the report for the date `date +%d%m%Y`"
git push https://sathisp80-gif:Shashu12@github.com/sathisp80-gif/crosstown-reports.git --all
cd ..
cd $root_dir
