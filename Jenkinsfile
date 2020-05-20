pipeline {
  agent any
  stages {
    stage('checkout project') {
      steps {
        checkout scm
      }
    }

    stage('test') {
      steps {
        sh 'mvn -Dmaven.test.failure.ignore=true clean package'
      }
    }

    stage('report') {
      steps {
        sh '**/target/surefire-reports/TEST-*.xml'
        junit '**/target/surefire-reports/TEST-*.xml'
      }
    }

  }
}