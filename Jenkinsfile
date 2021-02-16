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
	stage('Configure ansible'){
		steps{
			sh 'sudo pwd '
			sh 'whoami'
			sh 'sudo bash ./cross-town-devops/scripts/configure_ssh.sh'
		}
	}
    }
}
