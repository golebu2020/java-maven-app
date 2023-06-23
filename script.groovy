def buildJar(){
    echo "building the application..."
    sh 'mvn clean package'
}
return this

def buildImage(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')]){
        sh "docker build --tag golebu2020/maven-repo:jma-3.0 ."
        sh "echo ${PASS} | docker login -u ${USER} --password-stdin"
        sh "docker push golebu2020/maven-repo:jma-3.0"
    }
}
return this

def deployApp(){
    echo "deploying application..."
}
return this