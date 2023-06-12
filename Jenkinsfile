BRANCH_NAME='dev'
pipeline {
    agent any
    parameters{
        // string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description)
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    
    stages {
        stage("build"){
            steps{
                echo "Building the application"
            }
        }
        stage("test"){
         
            steps{
                echo "Testing the application"
            }
        }
        stage("deploy"){
            steps{
                echo "Deploying the application"
            }
        }
    }
    post{
        always{
            echo "Always run!!"
        }
        success{
            echo "Was successful"
        }
        failure{
            echo "Was not successful"
        }
    }
}