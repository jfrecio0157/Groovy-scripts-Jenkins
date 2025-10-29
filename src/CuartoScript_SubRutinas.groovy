/**
 * Genera un nombre de usuario a partir del nombre y apellido proporcionados.
 * <p>
 * El nombre de usuario se compone de la primera letra del nombre en minúscula
 * seguida del apellido completo en minúscula.
 * <p>
 * Por ejemplo, si el nombre es "Juan" y el apellido es "Serrano", el resultado será "jserrano".
 *
 * @param firstName el nombre de pila del usuario
 * @param lastName el apellido del usuario
 * @return una cadena que representa el nombre de usuario generado
 */

String getUserName (String firstName, String lastName){
    return firstName.substring(0,1).toLowerCase() + lastName.toLowerCase()
}

assert getUserName("John", "Smith") == "jsmith" : "getUsername no esta trabajando bien"

void printCredencial (cred){
    println("Username is ${cred}");
}

printCredencial(getUserName("John", "Smith"))

// Lo hacemos con Arrays
String[] firstNames = ["JoanManuel", "Joaquin", "Luz"]
String[] lastNames = ["Serrat", "Sabina", "Casal"]

for (int i=0; i < firstNames.size(); i++ ){
    printCredencial(getUserName(firstNames[i], lastNames[i]))
}