#!/usr/bin/env groovy

pipeline{
    agent any
    stages{
        stage ("increment build"){
            steps{
                script{
                    sh "mvn build-helper:parseVersion versions:set \
                    -DnewVersion=\\\${parseVersion.majorVersion}.\\\${parseVersion.minorVersion}.\\\${parseVersion.nextIncrementVersion} versions:commit"
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
                    echo "Increment"
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