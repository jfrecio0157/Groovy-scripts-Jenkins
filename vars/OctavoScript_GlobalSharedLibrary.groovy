import groovy.io.FileType

def call(Map config=[:]) {
    def dir = new File("C:\\Users\\jfrecios\\workspace\\Groovy-scripts-Jenkins")

    //Escribe los recursos de la dirección pasada en el path a un fichero releasenotex.txt, que se guarda en la raiz del proyecto
    new File(dir.path + '\\releasenotes.txt').withWriter('utf-8') {
        writer ->
            dir.eachFileRecurse(FileType.ANY) { file ->
                if (file.isDirectory()) {
                    writer.writeLine((file.name))
                }
                writer.writeLine('\t' + file.name + '\t' + file.length())
            }
    }
}