pipeline {
    agent any

    tools {
        jdk 'JDK-17'
    }

    environment {
        GRADLE_OPTS = "-Dorg.gradle.jvmargs='-Xmx1024m'"
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Clonando repositorio desde GitHub..."
                checkout scm
            }
        }

        stage('Compilar proyecto') {
            steps {
                echo "Ejecutando build sin tests..."
                sh './gradlew clean build -x test'
            }
        }

        stage('Ejecutar pruebas automatizadas') {
            steps {
                echo "Ejecutando pruebas..."
                sh './gradlew test'
                sh './gradlew aggregate'   // Para Serenity si aplica
            }
        }

        stage('Publicar reportes') {
            steps {
                echo "Publicando reportes JUnit y/o Serenity..."

                junit 'build/test-results/test/*.xml'

                publishHTML([
                    reportDir: 'build/reports/tests/test',
                    reportFiles: 'index.html',
                    reportName: 'Reporte de Tests'
                ])

                publishHTML([
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'Reporte Serenity'
                ])
            }
        }
    }

    post {
        always {
            echo "Guardando artefactos..."
            archiveArtifacts artifacts: 'build/**/*', fingerprint: true
        }
        success {
            echo "Pipeline finalizado exitosamente."
        }
        failure {
            echo "Pipeline falló. Revisar logs."
        }
    }
}