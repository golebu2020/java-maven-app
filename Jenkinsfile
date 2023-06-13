pipeline{
    agent any
    tools {
        maven 'Maven'
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
                    // withCredentials(usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')){
                    //     sh 'docker build --tag golebu2020/maven-repo:1.0 .'
                    //     sh "echo $PASS | docker login -u $USER --password-stdin"
                    //     sh 'docker push golebu2020/maven-repo:1.0'
                    // }
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')]){
                        sh "docker build --tag golebu2020/maven-repo:jma-3.0 ."
                        sh "docker login -u $USER -p $PASS"
                        sh "docker push golebu2020/maven-repo:jma-3.0"
                    }
                    // sh 'docker build --tag golebu2020/maven-repo:1.0 .'
                    // sh 'docker login -u golebu2020 -p Nedu123@#'
                    // sh 'docker push golebu2020/maven-repo:1.0'
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