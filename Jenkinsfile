BRANCH_NAME='dev'
pipeline {
    agent any
    environment{
        NEW_VERSION='1.3.0'
        SERVER_CREDENTIALS = credentials('server-credentials')
    }
    tools{
        maven 'Maven'
    }
    stages {
        stage("build"){
            steps{
                echo "Building the application"
                echo "Building version ${NEW_VERSION}"
                sh 'mvn install'
               
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
                //echo "Deploying with ${SERVER_CREDENTIALS}"
                //sh "${SERVER_CREDENTIALS}"
                withCredentials([
                    usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PWD)
                ]){
                    sh "Some scripts ${USER} ${PWD}"

                }
              
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