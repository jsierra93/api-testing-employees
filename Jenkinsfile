pipeline {
    agent any
    tools {
        maven 'maven3.8.3'
    }
    stages {
         stage('Download code') {
    		    git url: ' https://github.com/jsierra93/api-testing-employees.git', branch: 'master'
            }
        stage('Run Test') {
            steps {
               sh 'mvn clean verify -Dtest="co.com.jsierra.runners.*"'
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