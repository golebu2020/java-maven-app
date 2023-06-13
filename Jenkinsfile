def gv
pipeline{
    agent any
    stages{
        stage("init"){
            steps{
                sh "mvn --version"
            }
        }
        stage("build"){
            steps{
                echo "mvn package"
            }
        }

        stage("test"){
            steps{
                echo "testing app.."
            }
        }

        stage("deploy"){

            steps{
                echo "deploying app.."
            }
        }
    }
    
}