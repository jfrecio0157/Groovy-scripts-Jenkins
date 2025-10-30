import groovy.io.FileType
import com.cloudbees.groovy.cps.NonCPS

def call(Map config = [:]) {
    def ws = pwd()
    def content = buildReleaseNotes(ws)       // @NonCPS: recorre el FS y devuelve String
    writeFile file: "${ws}/releasenotes.txt", text: content
    echo "Release notes generadas en ${ws}/releasenotes.txt"
}

@NonCPS
private String buildReleaseNotes(String rootPath) {
    def dir = new File(rootPath)
    def sb  = new StringBuilder()
    dir.eachFileRecurse(FileType.ANY) { file ->
        if (file.isDirectory()) {
            sb.append("${file.name}\n")
        }
        sb.append("\t${file.name}\t${file.length()}\n")
    }
    return sb.toString()
}

