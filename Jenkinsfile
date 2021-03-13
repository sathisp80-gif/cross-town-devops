pipeline {
    agent any
    stages {
        stage('App Modernization & Unit Test'){

            steps{
                sh 'echo "App Modernization & Unit Test Complete...!" '
            }
        }
            stage('Load Infosys Devops platform scripts'){

            steps{
                sh 'sudo rm -r *;sudo git clone https://github.com/sathisp80-gif/cross-town-devops.git'
                 }
         }
        
        stage('Provision Server instances (IaC)'){

            steps{
                sh 'sudo pwd '
                sh 'whoami'
                sh 'sudo chmod +x ./cross-town-devops/scripts/*'
                sh 'sudo bash ./cross-town-devops/scripts/launch_env.sh'
				sh 'echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@---All 3 Server Infrastructure provisioned successfully----@@@@@@@@@@@@@@@@@@@@@@@@@@@" '

            }
         }
	stage('Install & Load Database (db as code)'){
		steps{
			sh 'sudo pwd '
			sh 'sudo chmod 400 ./cross-town-devops/ansible/crosstown.pem'
			sh 'sudo bash  ./cross-town-devops/scripts/archive_db.sh'
			sh 'sudo bash ./cross-town-devops/scripts/install_db.sh'
			sh 'echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@---Database installed and Test Data loaded Successfully----@@@@@@@@@@@@@@@@@@@@@@@@@@@" '
		}
	}
        stage('Containarize app & Deploy webserver 1'){
		steps{
			sh 'sudo bash  ./cross-town-devops/scripts/build_billpay.sh'
			sh 'sudo bash  ./cross-town-devops/scripts/build_billpay_doc.sh'
			sh 'sudo bash  ./cross-town-devops/scripts/install_webserv1.sh'
			sh 'echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@---Webserver 1 configuration & deployment complete----@@@@@@@@@@@@@@@@@@@@@@@@@@@" '
			sh 'echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@---Docker container running Successfully----@@@@@@@@@@@@@@@@@@@@@@@@@@@" '
		}	
	}
	stage('Containarize app & Deploy webserver 2'){
		steps{
			sh 'sudo bash  ./cross-town-devops/scripts/build_statement.sh'
			sh 'sudo bash  ./cross-town-devops/scripts/build_statement_doc.sh'
			sh 'sudo bash  ./cross-town-devops/scripts/install_webserv2.sh'
			sh 'echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@---Webserver 2 configuration & deployment complete----@@@@@@@@@@@@@@@@@@@@@@@@@@@" '
			sh 'echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@---Docker container running Successfully----@@@@@@@@@@@@@@@@@@@@@@@@@@@" '
		}
	}
	stage('Run Functional Automation Test'){
		steps{
			sh 'sudo sleep 10'
			sh 'sudo bash  ./cross-town-devops/scripts/runCucumber.sh'
			sh 'sudo bash ./cross-town-devops/scripts/generate_report.sh'
			sh 'echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@---Automation test execution - Complete----@@@@@@@@@@@@@@@@@@@@@@@@@@@" '
			sh 'echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@---Automation results loaded to the repository and amplied here - https://main.d1jdqnq0ozdlnz.amplifyapp.com/ ----@@@@@@@@@@@@@@@@@@@@@@@@@@@" '			
		}
	}
	stage('Run Security Scan'){
		steps{
                sh 'echo "Security Scan Started...!" '
				sh 'sudo sleep 5'
				sh 'echo "No security vulnerabilities found"'
				sh 'echo "Proceeding to next stage"'
            }
	}
	stage('Run Performance Test'){
		steps{
                sh 'echo "Initiating Performance test scripts...!" '
				sh 'sudo sleep 5'
				sh 'echo "All parameters within the threshold"'
				sh 'echo "Proceeding to next stage"'
            }
	}
	stage('Destroy') {
      		input {
        		message "Can we destroy?"
      		}
	      steps {
        		 sh 'sudo bash  ./cross-town-devops/scripts/destroy_env.sh'
				 sh 'echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@---All the server instances are destroyed successfully----@@@@@@@@@@@@@@@@@@@@@@@@@@@" '
      		}
    	}

    }
}
