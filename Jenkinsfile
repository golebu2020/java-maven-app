pipeline{
    agent any
    tools{
        maven: 'Maven'
    }
    stages{
        stage("build jar"){
            steps{
                script{
                    echo "building the application..."
                    sh 'mvn package'
                }
            }
        }
        stage("build image"){
            steps{
                script{
                    echo "building the docker image..."
                    withCredentials(usernamePassword(credentialsId: 'github-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')){
                        sh 'docker build --tag golebu2020/maven-repo:1.0 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push golebu2020/maven-repo:1.0'
                    }
                }
            }
        }

        stage("deploy"){
            steps{
                script{
                    echo "deploying the application"
                }
            }
        }
    }
    
}