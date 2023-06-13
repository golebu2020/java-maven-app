pipeline{
    agent any
    stages{
        stage("test"){
            steps{
                echo "Testing the applicaiton"
                echo "Executing the pipeline for branch $BRANCH_NAME"
            }
           
        }

        stage("build"){
            when{
                expression{
                    BRANCH_NAME == 'master'
                }
            }
            steps{
  
            }
        }
            when{
                expression{
                    BRANCH_NAME == 'master'
                }
            }
        stage("deploy"){
            steps{
       
            }
        }

    }
    
}