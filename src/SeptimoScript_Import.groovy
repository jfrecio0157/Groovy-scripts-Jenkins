import groovy.json.JsonException
import groovy.json.JsonSlurper

//Se trae music.json desde el pc
//String filePath = "C:\\Users\\jfrecios\\workspace\\Groovy-scripts-Jenkins\\src\\music.json"
//Se trae music.json del propio proyecto
String filePath = "../src/music.json"
File jsonFile = new File(filePath)

//Se valida la existencia del fichero json
if (!jsonFile.exists()){
    println "El archivo no existe: $filePath"
    return
}

//Se mete el tratamiento en un try-catch para manejar la excepción
try {
    def jsonSluper = new JsonSlurper()
/**
 * data es una lista de mapas: Cuando haces jsonSlurper.parse(...),
 * Groovy convierte el JSON en una estructura de objetos tipo Map y List.
 * En este caso, data es una ArrayList de Map, donde cada Map representa un artista.
 */
    ArrayList data = jsonSluper.parse(new File(filePath))

    //println(data.getClass())
    println("JSON VALIDO. Procesando...")
/**
 * artist es una variable que toma cada elemento de la lista data.
 * No necesitas decirle a Groovy qué tipo es, porque lo deduce automáticamente
 */
    for (artist in data) {
        println(artist.name)
        for (album in artist.albums) {
            println('\t Title: ' + album.title)
            for (song in album.songs) {
                println('\t\t' + song.title + ' (' + song.length + ')')
            }
            println('\t Description: ' + album.description)
            println()
        }
    }

}catch (JsonException e){
    println ("Error al procesar el JSON: ${e.message}")
}
