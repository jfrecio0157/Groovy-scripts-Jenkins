@Library('releasenotes@main')

node {
  stage ("SCM") {
   echo "Stage SCM..."
  }

  stage ("Build") {
   echo "Building..."
   //echo "Rama brV01R00F00"

    // Genera releasenotes.txt en la raíz del workspace (Windows)
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