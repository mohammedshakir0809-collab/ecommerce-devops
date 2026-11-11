pipeline {
  agent any
  environment {
    IMAGE = "shakir0809/ecommerce-app"
    TAG = "${BUILD_NUMBER}"
  }
  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build and Test') {
      steps { sh 'mvn clean package' }
    }
    stage('Docker Build') {
      steps { sh 'docker build -t $IMAGE:$TAG .' }
    }
    stage('Docker Push') {
      steps {
        withCredentials([usernamePassword(
          credentialsId: 'dockerhub-creds',
          usernameVariable: 'DOCKER_USER',
          passwordVariable: 'DOCKER_TOKEN'
        )]) {
          sh """
          echo "$DOCKER_TOKEN" | docker login -u "$DOCKER_USER" --password-stdin
          docker push "$IMAGE:$TAG"
          docker logout
          """
        }
      }
    }
  }
}
