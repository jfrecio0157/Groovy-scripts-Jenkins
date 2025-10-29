
/**
 * Representa un usuario con nombre y apellido, y proporciona métodos para generar un nombre de usuario.
 */

abstract class Usuario{
    //Nombre de pila del usuario
    String firstName
    //Primer apellido del usuario
    String lastName


    /**
     * Devuelve el nombre de usuario generado a partir del nombre y apellido del usuario.
     *
     * El nombre de usuario se compone de la primera letra del nombre en minúscula
     * seguida del apellido completo en minúscula.
     *
     * Por ejemplo, si el nombre es "Juan" y el apellido es "Serrano", el resultado será "jserrano".
     *
     * @return el nombre de usuario generado
     */

    public String UserName () {
        return getUsername (this.firstName, this.lastName);
    }


    /**
     * Genera un nombre de usuario a partir del nombre y apellido proporcionados.
     *
     * Este método es privado y se utiliza internamente por la clase.
     *
     * @param firstName el nombre de pila
     * @param lastName el apellido
     * @return una cadena que representa el nombre de usuario generado
     */
    private String getUsername (String firstName, String lastName){
        return firstName.substring(0,1).toLowerCase() + lastName.toLowerCase();
    }
}

//Generamos dos clases, Artistas y Productores, de la clase abstracta Usuario
class Artistas extends Usuario {
    public String[] Canciones;
}

class Productores extends Usuario {
    public void Produce () {
        println("Album COMPLETO");
    }
}

//Se dan de alta usuarios, tanto Artistas como Productores
Usuario[] users = [
        new Artistas(firstName: "JoanManuel", lastName: "Serrat", Canciones: ["Mediterráneo", "Penélope"]),
        new Productores(firstName: "Pepe", lastName: "Garcia"),
        new Artistas(firstName: "Joaquin", lastName: "Sabina", Canciones: ["19 dias y 500 noches"]),
        new Artistas(firstName: "Luz", lastName: "Casal", Canciones: ["Piénsame"])
]

//Recorre users, imprimiendo en función de si es un Artista o un Productor.
users.each { user ->
    if (user instanceof Artistas) {
        println("UserName is ${user.UserName()}") //Imprime el Artista
        user.Canciones.each {println("${it}")}; //Imprime la lista de canciones
    }
    else{
        user.Produce(); //Ejecuta el método Produce() de Productores
    }
}