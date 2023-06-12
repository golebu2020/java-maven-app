BRANCH_NAME='dev'
pipeline {
    agent any

    stages {
        stage("build"){
            steps{
                echo "Building the application"
            }
        }
        stage("test"){
            when{
                expression{
                    BRANCH_NAME=='prod'
                }
            }
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