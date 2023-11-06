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
      passwordVariable : 'PASS',
      usernameVariable : 'USER'
    )]
  ){
    echo "$USER $PASS"
    sh 'docker build -t 67.205.176.30:8083:jma-2.0 .'
      echo "after build"
    sh "echo $PASS | docker login -u $USER --password-stdin 67.205.176.30:8083"
     echo "after login"
    sh 'docker push 67.205.176.30:8083:jma-2.0'
     echo "after push"
  }
}
def deployApp(){
  echo 'deploy stage'
  echo "deployed in ${env}"
}

return this
