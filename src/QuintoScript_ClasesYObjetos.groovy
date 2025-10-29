
/**
 * Representa un usuario con nombre y apellido, y proporciona métodos para generar un nombre de usuario.
 */

class User {
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

//Se dan de alta usuarios de la clase User
User[] users = [
        new User(firstName: "JoanManuel", lastName: "Serrat"),
        new User(firstName: "Joaquin", lastName: "Sabina"),
        new User(firstName: "Luz", lastName: "Casal")
]

//Recorre users, imprimiendo lo obtenido en getUserName
users.each {user -> println("UserName is ${user.UserName()}")};