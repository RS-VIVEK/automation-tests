pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Use your actual repo URL here
                git url: 'https://github.com/RS-VIVEK/automation-tests.git', branch: 'main'
            }
        }
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t automation-tests .'
            }
        }
        stage('Run Tests in Docker') {
            steps {
                // Mount Jenkins workspace/target to container /app/target
                bat 'docker run --rm -v %WORKSPACE%\\target:/app/target automation-tests'
            }
        }
        stage('Publish Reports') {
            steps {
                // If using Maven Surefire plugin (JUnit-style XMLs)
                junit '**/target/surefire-reports/*.xml'

                // If you prefer TestNG native reports, install TestNG plugin and use:
                // testng '**/test-output/testng-results.xml'
            }
        }
    }
    post {
        always {
            echo "Build finished with status: ${currentBuild.currentResult}"
        }
        failure {
            emailext(
                subject: "Automation Tests FAILED (Build #${env.BUILD_NUMBER})",
                body: "Check Jenkins logs and reports for details.",
                to: "your-team@example.com"
            )
        }
        success {
            emailext(
                subject: "Automation Tests PASSED (Build #${env.BUILD_NUMBER})",
                body: "All tests passed successfully.",
                to: "your-team@example.com"
            )
        }
    }
}
