def buildApp(){
  echo 'build stage'
}
def testApp(){
  echo 'test stage'
}
def deployApp(){
  echo 'deploy stage'
  echo "deployed in ${env}"
}

return this
