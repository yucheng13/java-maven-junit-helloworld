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

    stage('test report') {
      steps {
        junit '**/target/surefire-reports/TEST-*.xml'
      }
    }

    stage('archive') {
      steps {
        archiveArtifacts 'target/*.jar'
      }
    }

  }
}