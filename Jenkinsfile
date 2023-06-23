#!/usr/bin/env groovy

pipeline{
        agent any
        stages{
            stage("increment build version"){
                steps{
                    script{
                       sh "incrementer"
                    }
                }
            }

            stage("build and push"){
                steps{
                    script{
                        sh "build and push"
                    }
                }
            }

            stage("deploy"){
                steps{
                    script{
                        sh "deploying..."
                    }
                }
            }
        }
    
}