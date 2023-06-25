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

                     withCredentials([usernamePassword(credentialsId: 'github-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        
                        // sh "git config --global user.email 'cgolebu@gmail.com'"
                        // sh "git config --global user.name 'chinedu'"
                        sh "git status"
                        sh "git config --list"
                        sh "git branch"

                        sh 'echo "Username length: ${#USER}"'
                        sh 'echo "Password length: ${#PASS}"'
                        // sh ''
                        // sh "touch chined.txt"
                        sh '''
                            if [ "$(ls -A $/var/jenkins_home/workspace/java-maven-job)" ]; 
                            then
                                echo "huzzah"
                            else 
                                echo "has no files"
                            fi
                                                
                        '''

                        // env.PAT = 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
                        // sh "git remote set-url origin git@github.com:golebu2020/java-maven-app.git"  
                        // sh "git remote set-url origin https://${USER}:${PASS}@github.com/golebu2020/java-maven-app.git"
                        // sh 'git add .'  
                        // // sh "git remote -v"  
                        // sh 'git commit -m "ci: version bump"'  
                        // sh 
                        // sh 'git push https://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@github.com/golebu2020/java-maven-app.git master'

                        // sh 'GIT_SSH_COMMAND="ssh -i $keyfile"'  
                        // sh 'git push -u origin master' //need to specify the branch name here. Because  
                       


                     }
                }
            }
        }


    }
}