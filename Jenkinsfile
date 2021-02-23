pipeline {
    agent any
    stages {
        stage('X-Town Integ test - Started'){

            steps{
                sh 'echo "Started...!" '
            }
        }
            stage('Load X-Town platform scripts'){

            steps{
                sh 'sudo rm -r *;sudo git clone https://github.com/sathisp80-gif/cross-town-devops.git'
                 }
         }
        
        stage('Create Server instances'){

            steps{
                sh 'sudo pwd '
                sh 'whoami'
                sh 'sudo chmod +x ./cross-town-devops/scripts/*'
                sh 'sudo bash ./cross-town-devops/scripts/launch_env.sh'
				sh 'echo "All 3 Server Infrastructure provisioned successfully" '

            }
         }
	stage('Install Database & Load Test Data'){
		steps{
			sh 'sudo pwd '
			sh 'sudo chmod 400 ./cross-town-devops/ansible/crosstown.pem'
			sh 'sudo bash  ./cross-town-devops/scripts/archive_db.sh'
			sh 'sudo bash ./cross-town-devops/scripts/install_db.sh'
			sh 'echo "Database installed and Test Data loaded Successfully" '
		}
	}
        stage('Configure & Deploy webserver 1'){
		steps{
			sh 'sudo bash  ./cross-town-devops/scripts/build_billpay.sh'
			sh 'sudo bash  ./cross-town-devops/scripts/build_billpay_doc.sh'
			sh 'sudo bash  ./cross-town-devops/scripts/install_webserv1.sh'
			sh 'echo "Webserver 1 configuration & deployment complete" '
			sh 'echo "Docker container running Successfully" '
		}	
	}
	stage('Configure & Deploy webserver 2'){
		steps{
			sh 'sudo bash  ./cross-town-devops/scripts/build_statement.sh'
			sh 'sudo bash  ./cross-town-devops/scripts/build_statement_doc.sh'
			sh 'sudo bash  ./cross-town-devops/scripts/install_webserv2.sh'
			sh 'echo "Webserver 1 configuration & deployment complete" '
			sh 'echo "Docker container running Successfully" '
		}
	}
	stage('Run Automation Test'){
		steps{
			sh 'sudo sleep 10'
			sh 'sudo bash  ./cross-town-devops/scripts/runCucumber.sh'
			sh 'sudo bash ./cross-town-devops/scripts/generate_report.sh'
			sh 'echo "Automation test execution - Complete" '
			sh 'echo "Automation results loaded to the repository and amplied here - https://main.d1jdqnq0ozdlnz.amplifyapp.com/" '			
		}
	}
	stage('Destroy') {
      		input {
        		message "Can we destroy?"
      		}
	      steps {
        		 sh 'sudo bash  ./cross-town-devops/scripts/destroy_env.sh'
				 sh 'echo "All the server instances are destroyed successfully" '
      		}
    	}

    }
}
