def buildApp(){
    echo "building the application..."
}
return this

def testApp(){
    echo "testing the application..."
}
return this

def deployApp(){
    echo "deploying the application"
    echo "Deploying version ${params.VERSION}"
}
return this
