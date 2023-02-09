// import jenkins-auto-approve-script.groovy

job('Job-pTienda') {
    description('Job Padre para crear una tarea Hija que despliegue la App Tienda')
    scm {
        git('https://github.com/PedritoBF03/jenkinsPTienda.git', 'master') {
            node ->
                node / gitConfigName('PedritoBF03')
                node / gitConfigEmail('pedrobf2003@gmail.com')
        }
    }
    triggers {
        //  scm('H/5 * * * *')
        githubPush()
    }

    steps {
        shell('bash install.sh')
    }
}
