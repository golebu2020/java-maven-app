def gv
pipeline{
    agent any
    stages{
         stage("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }
        
        stage("build"){
            steps{
                script{
                    gv.buildApp()
                }
            }
        }

        stage("test"){
            steps{
                script{
                    gv.testApp()
                }
                
            }
        }

        stage("deploy"){
            steps{
                script{
                    gv.deployApp()
                }
                
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