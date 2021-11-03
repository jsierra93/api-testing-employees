pipeline {
    agent any

    tools {
        maven 'maven3.8.3'
        jdk 'jdk8'
    }

    stages {
        stage('Test') {
            steps {
                sh 'mvn verify -Drestapi.baseurl=https://dummy-employee.getsandbox.com:443 -Dtest="co.com.jsierra.runners.*"
            }
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml, **/build/reports/integration-tests/TEST-*.xml'
                }
            }
        }
    }
}