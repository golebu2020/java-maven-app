#!/usr/bin/env groovy




pipeline{
    agent any
    stages{
        stage ("increment build"){
            steps{
                script{
                    sh "mvn build-helper:parse-version versions:set \
                    -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit"

                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }
        
        stage ("build artifact"){
            steps{
                script{
                    sh "mvn clean package"
                }
            }
        }

        stage ("build image & push"){
            steps{
                script{
                    sh "docker build --tag golebu2020/maven-repo:${IMAGE_NAME} ."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USR', passwordVariable: 'PASS')]){
                        echo "${USR} -- ${PASS}"
                        sh "echo ${PASS} | docker login -u ${USR} --password-stdin"
                        sh "docker push golebu2020/maven-repo:${IMAGE_NAME}"
                    } 
                }
            }
        }

        stage ("deploy"){
            steps{
                script{
                    echo "deploying imagedd..."
                }
            }
        }
        stage ("commit version update"){
            steps{
                script{
                    git credentialsId: 'github-credentials', url: 'https://github.com/golebu2020/java-maven-app.git'
                    gitAdd all: true
                    gitCommit branch: 'master', message: 'Modify Jenkinsfile'
                    sh "git push origin master"



                    //  withCredentials([usernamePassword(credentialsId: 
                    //  'github-credentials', usernameVariable: 'USR', 
                    //  passwordVariable: 'PASS')]){
                    //     sh "git config --global user.email 'jenkins@example.com'"
                    //     sh "git config --global user.name 'Jenkins'"
                    //     sh "git status"
                    //     sh "git branch"
                    //     sh "git config --list"

                    //     sh "git remote set-url origin https://${USR}:${PASS}@github.com/golebu2020/java-maven-app.git"
                    //     sh "git add ."
                    //     sh "git commit -m 'version bump'"
                    //     sh "git push origin master"
                           
                    // } 
                }
            }
        }


    }
}