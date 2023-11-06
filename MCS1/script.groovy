def BuildApp(){
  echo 'build stage'
}
def TestApp(){
  echo 'test stage'
}
def DeployApp(){
  echo 'deploy  stage vesion ${params.VERSION}'
}
