pipeline {
   agent any

   tools {
      maven "M3"
   }

   stages {
    stage('checkout project') {
      steps {
        checkout scm
      }
    }
  }
}