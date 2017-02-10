 properties([[$class: 'GitLabConnectionProperty', gitLabConnection: ''], [$class: 'RebuildSettings', autoRebuild: false, rebuildDisabled: false], pipelineTriggers([[$class: 'GitHubPRTrigger', events: [[$class: 'GitHubPROpenEvent']], spec: '* * * * *', triggerMode: 'CRON']])])
node {
def mvnHome
   def scannerHome 

    String path = '/tmp/jenkins/upstream-repo'
    sh "rm -rf ${path}"
    ws(path) {
        sh 'git --version'
        sh 'git init'
        sh 'touch README.md; git add README.md; git commit -m "init"'
        sh 'git checkout -b pull-requests/1/from'
        sh 'touch file.txt; git add file.txt; git commit -m "Add file"'
    }
    // sh "git clone ${path} ."
    sh 'pwd; tree; ls;'
    checkout([
        $class: 'GitSCM',
        branches: [[name: 'refs/heads/master']],
        userRemoteConfigs: [[
            name: 'origin',
            refspec: 'pull-requests/1/from',
            url: path
        ]],
        extensions: [
        [
            $class: 'PreBuildMerge',
            options: [
                fastForwardMode: 'NO_FF',
                mergeRemote: 'origin',
                mergeStrategy: 'MergeCommand.Strategy',
                mergeTarget: 'master'
            ]
        ],
        [
            $class: 'LocalBranch',
            localBranch: 'master'
        ]]
    ])
    sh 'git log -n 10 --graph --pretty=oneline --abbrev-commit --all --decorate=full'
         
  // stage('Build') {
      // Run the maven build
       //  bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean install/)      
 //  }
   
  // stage ('Sonar Analysis') {
   //Running Sonar Analysis
  // withSonarQubeEnv {
 //  bat(/"${scannerHome}\bin\sonar-scanner" -Dsonar.projectKey=java-maven-junit-helloworld -Dsonar.sources=./)
     //}
 //  }  
 
}
