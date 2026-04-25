pipeline {
    agent any

    tools {
        maven 'Maven-3.9.12'
        jdk 'JDK-25'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Verify Tools') {
            steps {
                bat 'mvn -version'
                bat 'java -version'
                bat 'docker version'
            }
        }

        stage('Build + Test') {
            steps {
                bat 'mvn clean test package'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t mathapp5-demo:latest .'
            }
        }

        stage('Deploy to Staging') {
            steps {
                bat 'docker rm -f mathapp5-staging 2>nul'
                bat 'docker run -d --name mathapp5-staging -e APP_ENV=staging -e KEEP_ALIVE_SECONDS=120 mathapp5-demo:latest'
            }
        }

        stage('Staging Verification') {
            steps {
                bat 'docker ps -a'
                bat 'docker logs mathapp5-staging'
            }
        }

        stage('Deploy to Production') {
            steps {
                bat 'docker rm -f mathapp5-production 2>nul'
                bat 'docker run -d --name mathapp5-production -e APP_ENV=production -e KEEP_ALIVE_SECONDS=120 mathapp5-demo:latest'
            }
        }

        stage('Production Verification') {
            steps {
                bat 'docker ps -a'
                bat 'docker logs mathapp5-production'
            }
        }
    }
}