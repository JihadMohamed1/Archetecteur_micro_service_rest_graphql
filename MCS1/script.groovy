def buildJar(){
  echo 'build jar stage'
  sh 'ls'
  sh ' cd MCS1'
  sh 'ls'
  sh 'mvn package -f MCS1/pom.xml'
}
def buildImage(){
  echo 'build Image stage'
  whithCredentials(
    [usernamePassword(
      credentialsId : 'dockerhub_cred',
      passwordVariable : PASS,
      usernameVariable : USER
    )]
  ){
    sh 'docker build -t 67.205.176.30:8083:jma-2.0 .'
    sh "echo $PASS | docker login -u $USER --password-stdin 67.205.176.30:8083"
    sh 'docker push 67.205.176.30:8083:jma-2.0'
  }
}
def deployApp(){
  echo 'deploy stage'
  echo "deployed in ${env}"
}

return this
