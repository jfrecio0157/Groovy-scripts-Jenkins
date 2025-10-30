@Library('releasenotes@main') _

node {
  stage ("SCM") {
   echo "Stage SCM..."
   //Jenkins hace checkout del código desde GitHub al workspace antes de llamar a releasenotes
   checkout scm
  }

  stage ("Build") {
   echo "Building..."
   //echo "Rama brV01R00F00"

    // Se ejecuta el releasenotes.groovy
    // Con glob: Genera releasenotes.txt en la raíz del workspace (Windows)
    // Puedes ajustar glob/excludes si quieres afinar:
    releasenotes(
      glob: '**/*',
      excludes: '**/.git/**,**/.svn/**,**/.hg/**,**/.idea/**,**/target/**,**/build/**'
    )

  }

  stage("Test") {
   echo "Testing..."
  }

  stage ("Deploy") {
   echo "Deploying..."
   archiveArtifacts artifacts: 'releasenotes.txt', onlyIfSuccessful: true
  }
}
