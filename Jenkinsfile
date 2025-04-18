pipeline {
    agent any

    environment {
        // Define environment variables
        APP_CENTER_API_TOKEN = 'your-app-center-api-token'  // Replace with your App Center API token
        APP_CENTER_OWNER_NAME = 'your-app-center-owner-name'  // Replace with your App Center owner name
        APP_CENTER_APP_NAME = 'your-app-center-app-name'  // Replace with your App Center app name
    }

    stages {
        // Checkout code from GitHub
        stage('Checkout') {
            steps {
                git 'https://github.com/yourusername/yourrepo.git'  // Replace with your GitHub repository URL
            }
        }

        // Install dependencies (e.g., Node.js, Python, etc.)
        stage('Install Dependencies') {
            steps {
                script {
                    // For Node.js
                    sh 'npm install'
                }
            }
        }

        // Run Linting (if applicable, like for JavaScript code)
        stage('Linting') {
            steps {
                script {
                    // For Node.js, example using ESLint
                    sh 'npm run lint'
                }
            }
        }

        // Build the application (e.g., compile or bundle)
        stage('Build') {
            steps {
                script {
                    // For Node.js or JavaScript-based app
                    sh 'npm run build'
                }
            }
        }

        // Run Tests (Unit tests, integration tests, etc.)
        stage('Test Execution') {
            steps {
                script {
                    // Run your tests (e.g., using Jest or Mocha for Node.js)
                    sh 'npm test'
                }
            }
        }

        // Deploy to App Center after a successful build and test
        stage('Deploy to App Center') {
            steps {
                script {
                    sh '''
                    curl -X POST https://api.appcenter.ms/v0.1/apps/${APP_CENTER_OWNER_NAME}/${APP_CENTER_APP_NAME}/releases \
                    -H "Content-Type: application/json" \
                    -H "X-API-Token: ${APP_CENTER_API_TOKEN}" \
                    -d '{
                        "build": "true",
                        "notify_testers": "true",
                        "group": "Testers",
                        "file": "path/to/your/app.apk"  // Replace with the correct path to your app binary
                    }'
                    '''
                }
            }
        }
    }
}
