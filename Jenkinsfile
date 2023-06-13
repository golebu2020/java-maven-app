pipeline{
    agent any
    stages{
        stage("build"){
            steps{
                echo "building application..."
            }
        }

        stage("test"){
            steps{
                echo "testing application..."
            }
        }

        stage("deploy"){
            steps{
                echo "deploying application..."
            }
        }
    }
    post{
        always{
            echo "This code will always be run"
        }

        success{
            echo "This code will be successful"
        }

        failure{
            echo "This code will be a failure"
        }
    }
}