def gv
pipeline{
    parameters{
        choice(name: 'SELECT', choices: ['dev', 'stage', 'prod'], description: '')
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
                    env.ENV = input message: "Please select the deployment mode", ok: "Done", parameters: [
                        choice(name: 'ONE', choices: ['dev', 'stage', 'prod'], description: '')
                    ] 
                    echo "Deploying to ${ENV}"
                }
                
            }
        }
    }
    post{
        always{
            echo "This code will always be run"
            echo "The choice is ${params.SELECT}"
        }

        success{
            echo "This code will be successful"
        }

        failure{
            echo "This code will be a failure"
        }
    }
}