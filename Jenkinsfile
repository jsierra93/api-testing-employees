pipeline {
    agent any

    tools {
        maven 'maven3.8.3'
    }

    stages {
        stage('Test') {
            steps {
                sh 'mvn verify -Drestapi.baseurl=https://dummy-employee.getsandbox.com:443 -Dtest="co.com.jsierra.runners.*"'
            }
            }
                   stage('Publish Report') {
                        steps {
                           publishHTML([allowMissing: false,
                                                               alwaysLinkToLastBuild: true,
                                                               keepAll: true,
                                                               reportDir: 'target/site/serenity',
                                                               reportFiles: 'index.html',
                                                               reportName: 'Serenity API Test']
                                                               )
                        }
                    }
    }
}