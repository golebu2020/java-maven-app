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
            
        stage("deploy"){
            when{
                expression{
                    BRANCH_NAME == 'master'
                }
            }
            steps{
       
            }
        }

    }
    
}