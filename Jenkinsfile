BRANCH_NAME='dev'
pipeline {
    agent any
    environment{
        NEW_VERSION='1.3.0'
        SERVER_CREDENTIALS = credentials('server-credentials')
    }
    stages {
        stage("build"){
            steps{
                echo "Building the application"
                echo "The new version is: $NEW_VERSION"
               
            }
        }
        stage("test"){
            when{
                expression{
                    BRANCH_NAME=='dev'
                }
            }
            steps{
                echo "Testing the application"
            }
        }
        stage("deploy"){
            steps{
                echo "Deploying the application"
                echo "Deploying with ${SERVER_CREDENTIALS}"
                sh "${SERVER_CREDENTIALS}"
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