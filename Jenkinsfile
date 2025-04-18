pipeline {
    agent any

    environment {
        // ✅ Updated your real API token here
        APP_CENTER_API_TOKEN = '0b20d9c01c29de04b3f4fd2c8d382f41f2557941'
        APP_CENTER_OWNER_NAME = 'AlphaEngg'      // Your App Center org or user name
        APP_CENTER_APP_NAME = 'Calculator'       // Your App Center app name
        APK_PATH = 'app/build/outputs/apk/debug/app-debug.apk'  // Path to your APK after build
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/AlphaEngg/Calculator_LinearLayout_CICD'
            }
        }

        stage('Build APK') {
            steps {
                script {
                    sh './gradlew assembleDebug'  // Build the debug APK
                }
            }
        }

        stage('Upload to App Center') {
            steps {
                script {
                    sh """
                    curl -X POST https://api.appcenter.ms/v0.1/apps/${APP_CENTER_OWNER_NAME}/${APP_CENTER_APP_NAME}/release_uploads \
                    -H "X-API-Token: ${APP_CENTER_API_TOKEN}" \
                    -H "Content-Type: application/json" \
                    -d '{}'
                    """ + " > upload_response.json"

                    def uploadId = sh(script: "cat upload_response.json | jq -r '.upload_id'", returnStdout: true).trim()
                    def uploadUrl = sh(script: "cat upload_response.json | jq -r '.upload_url'", returnStdout: true).trim()

                    sh """
                    curl -X POST "$uploadUrl" \
                    -F "file=@${APK_PATH}" \
                    -H "X-API-Token: ${APP_CENTER_API_TOKEN}"
                    """

                    sh """
                    curl -X PATCH https://api.appcenter.ms/v0.1/apps/${APP_CENTER_OWNER_NAME}/${APP_CENTER_APP_NAME}/release_uploads/$uploadId \
                    -H "X-API-Token: ${APP_CENTER_API_TOKEN}" \
                    -H "Content-Type: application/json" \
                    -d '{ "status": "committed" }'
                    """
                }
            }
        }
    }

    post {
        success {
            echo '🎉 APK successfully uploaded to App Center!'
        }
        failure {
            echo '❌ Pipeline failed. Check errors above.'
        }
    }
}
