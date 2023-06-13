def gv
pipeline{
    parameters{
        choice(name: 'SELECT-TYPE', choices: ['dev', 'stage', 'prod'], description: '')
        booleanParam(name: 'executeDeploy', defaultValue:true, description: '')
    }

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
            when{
                expression{
                    params.executeDeploy == true
                }
            }
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
            echo "The choice is ${params.SELECT-TYPE}"
        }

        success{
            echo "This code will be successful"
        }

        failure{
            echo "This code will be a failure"
        }
    }
}