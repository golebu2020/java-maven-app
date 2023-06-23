#!/usr/bin/env groovy

pipeline{
    agent any
    stages{
        stage ("increment build"){
            steps{
                script{
                    sh "mvn build-helper:parseVersion versions:set \
                    -DnewVersion=\\\${parseVersion.majorVersion}.\\\${parseVersion.minorVersion}.\\\${parseVersion.nextIncrementVersion} versions:commit"

                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }
        
        stage ("build artifact"){
            steps{
                script{
                    echo "mvn clean package"
                }
            }
        }

        stage ("build image & push"){
            steps{
                script{
                    echo "Increm"
                }
            }
        }

        stage ("deploy"){
            steps{
                script{
                    echo "increment"
                }
            }
        }
    }
}