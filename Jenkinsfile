node {
   def mvnHome
   def scannerHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git poll: true, url: 'https://github.com/amruthapbhat/java-maven-junit-helloworld.git'
      
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'Maven'
      scannerHome = tool 'Sonar'
   }
   stage('Build') {
      // Run the maven build
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean install/)      
   }
   
   stage ('Sonar Analysis') {
   //Running Sonar Analysis
   withSonarQubeEnv {
   bat(/"${scannerHome}\bin\sonar-scanner" -Dsonar.projectKey=java-maven-junit-helloworld -Dsonar.sources=./)
     }
   }   
}
