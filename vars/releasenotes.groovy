import groovy.io.FileType
import com.cloudbees.groovy.cps.NonCPS

import java.text.SimpleDateFormat

//Al ponerlo como def call es necesario que este script este en vars.
//Tambien es necesario definir en Jenkins, en Administrar Jenkins -> System la parte de "Global Trusted Pipeline Libraries"
def call(Map config = [:]) {
    def ws = pwd()
    def content = buildReleaseNotes(ws)       // @NonCPS: recorre el FS y devuelve String
    writeFile file: "${ws}/releasenotes.txt", text: content
    echo "Release notes generadas en ${ws}/releasenotes.txt"

    //Fecha y hora actuales
    def date = new Date()
    def sdf = new SimpleDateFormat('MM/dd/yyyy HH:mm:ss')
    echo "Fecha y hora actuales: " + sdf.format(date)


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

