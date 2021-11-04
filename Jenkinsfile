pipeline {
    agent any
    tools {
        maven 'maven3.8.3'
    }
    stages {
        stage('Prepare Code') {
          steps {
               git url: 'https://github.com/jsierra93/api-testing-employees.git', branch: 'master'
         }
        }
         stage('Build') {
          steps {
                sh 'mvn clean package'
         }
        }
        stage('Test') {
            steps {
               sh 'mvn verify -Dtest="co.com.jsierra.runners.*"'
              // sh 'mvn verify -Drestapi.baseurl=https://dummy-employee.getsandbox.com:443 -Dtest="co.com.jsierra.runners.*"'
            }
        }
        stage('Publish Report') {
            steps {
                publishHTML([allowMissing: false,
                            alwaysLinkToLastBuild: true,
                            keepAll: true,
                            reportDir: 'target/site/serenity',
                            reportFiles: 'index.html',
                            reportName: 'Serenity API Test'
                            ])
                }
        }
    }
}