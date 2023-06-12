BRANCH_NAME='dev'
def gv
pipeline {
    agent any

    parameters{
        // string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    
    stages {
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
            when{
                expression{
                    params.executeTests 
                }
            }
            steps{
                script{
                    gv.testApp()
                }
            }
        }
        stage("deploy"){
            // input{
            //     message "Select the environment to deploy to"
            //     ok "Done"
            //     parameters{
            //         choice(name: 'ONE', choices: ['dev', 'staging', 'prod'], description: '')
            //         choice(name: 'TWO', choices: ['dev', 'staging', 'prod'], description: '')
            //     }
            // }
            steps{
                 script{
                    env.ENV = input message:  "Select the environment to deploy to", ok: "Done", 
                        parameters: [choice(name: 'ONE', choices: ['dev', 'staging', 'prod'], 
                        description: '')]
                    gv.deployApp()
                    echo "deploying to ${ENV}"
                    // echo "deploying to ${TWO}"
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