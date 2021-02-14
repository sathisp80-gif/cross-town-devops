pipeline {
    agent any
    stages {
        stage('Create Servers'){

            steps{
                sh 'chmod +x ./script/*'
                sh 'bash ./script/launch_env.sh'

            }
        }
 }

}