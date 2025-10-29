//Declaración de variables
String name = "Pepe Garcia "
int courseCount = 14
float salary = 99999999.9
BigDecimal salaryActual = 99999999.9
Boolean isProgrammer = true

//Imprimir cadenas
println name + "ha creado " + courseCount + " cursos."
println name + "es un programador?: " + isProgrammer.toString().capitalize() //La primera letra en mayúsculas.
println name + "desea tener un salario de: " + String.format("%.2f", salary) //Darle formato de dos decimales.
println name + "tiene un salario actual de: \$" + salaryActual //Con BigDecimal no hace falta formato