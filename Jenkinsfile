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
bat 'docker build -t mathapp5-demo .'
}
}

stage('Run Container') {
steps {
bat 'docker run --rm mathapp5-demo'
}
}
}
}
