pipeline {
    agent any
    stages {
        stage('Terraform Started'){

            steps{
                sh 'echo "Started...!" '
            }
        }
            stage('git clone'){

            steps{
                sh 'sudo rm -r *;sudo git clone https://github.com/sathisp80-gif/cross-town-devops.git'
                 }
         }
        
        stage('Create Servers'){

            steps{
                sh 'sudo pwd '
                sh 'whoami'
                sh 'sudo chmod +x ./cross-town-devops/scripts/*'
                sh 'sudo bash ./cross-town-devops/scripts/launch_env.sh'

            }
         }
	stage('Install and Configure Database'){
		steps{
			sh 'sudo pwd '
			sh 'sudo chmod 400 ./cross-town-devops/ansible/crosstown.pem'
			sh 'sudo bash  ./cross-town-devops/scripts/archive_db.sh'
			sh 'sudo bash ./cross-town-devops/scripts/install_db.sh'
		}
	}
        stage('Configure & Deploy webserver 1'){
		steps{
			sh 'sudo bash  ./cross-town-devops/scripts/build_billpay.sh'
			sh 'sudo bash  ./cross-town-devops/scripts/build_billpay_doc.sh'
			sh 'sudo bash  ./cross-town-devops/scripts/install_webserv1.sh'
		}	
	}
	stage('Configure & Deploy webserver 2'){
		steps{
			sh 'sudo bash  ./cross-town-devops/scripts/build_statement.sh'
			sh 'sudo bash  ./cross-town-devops/scripts/build_statement_doc.sh'
			sh 'sudo bash  ./cross-town-devops/scripts/install_webserv2.sh'
		}
	}
	stage('Run Automation Test'){
		steps{
			sh 'sudo bash  ./cross-town-devops/scripts/runCucumber.sh'
		}
	}

    }
}
