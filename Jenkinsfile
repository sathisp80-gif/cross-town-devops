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
                sh 'echo "Started...!" '
                sh 'chmod +x ./cross-town-devops/script/*'
                sh 'bash ./cross-town-devops/script/launch_env.sh'

            }
         }
    }
}
