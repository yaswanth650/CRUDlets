pipeline {
  agent any 
  tools {
    maven 'Maven'
  }
  stages {
    stage ('Initialize') {
      steps {
        sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
            ''' 
      }
    }
    
    stage ('Check-Git-Secrets') {
      steps {
        sh 'rm trufflehog || true'
        sh 'docker run gesellix/trufflehog --json https://github.com/yaswanth650/CRUDlets.git > trufflehog'
        sh 'cat trufflehog'
      }
    }
    
     stage ('Build') {
      steps {
      sh 'mvn clean package'
       }
    }
    
     stage ('Deploy-To-Tomcat') {
            steps {
           sshagent(['tomcat']) {
                sh 'scp -o StrictHostKeyChecking=no target/*.jar ubuntu@65.2.4.199:/prod/apache-tomcat-9.0.65/webapps/webapp.jar'
              }      
           }       
    }
  }
}
