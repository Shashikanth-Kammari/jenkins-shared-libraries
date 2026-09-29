pipeline {
        agent {
            label 'AGENT-1'
        }
        options {
            timeout(time: 30, unit: 'MINUTES')
            disableConcurrentBuilds()
            ansiColor('xterm')
        }
        environment{
            def appVersion = '' //variable declaration
            nexusUrl = pipelineGlobals.nexusURL()
            region = pipelineGlobals.region()
            account_id = pipelineGlobals.account_id()
            component = configMap.get("component")
            project = configMap.get("project")
            def releaseExists = ""
        }
        parameters{
            // which component you want to deploy
            // which environment
            // which version
        }
        stages {
            stage('Deploy'){
                steps{
                    script{
                        // deploy to specific environment like QA, UAT, PERF etc.
                    }
                }
            }
            stage('Integration tests') {
                steps {
                    script{
                    // Run integration tests
                    }
                }
            }
        }
        post {
            always { 
                echo 'I will always say Hello again!'
                deleteDir() //It will clear the directory after tests are done for free up the space.
            }
            success { 
                echo 'I will run when pipeline is success'
            }
            failure { 
                echo 'I will run when pipeline is failure'
            }
        }
    }