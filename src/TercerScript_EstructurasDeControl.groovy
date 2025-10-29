Boolean isProgrammer = true
int counterCourse = 3
String[] singers = ["Serrat", "Sabina", "Luz Casal", "Ricardo Arjona"]

//if--else
if (isProgrammer){
    println "Es un programador"
}
else {
    println "No es un programador"
}
println()

//for loop
for (int i=0; i<counterCourse; i++) {
    println "Pepe Garcia con for ha hecho " + (i+1) + " cursos"
}
println()

//for in

for(String singer: singers){
    println singer
}
println()

//for each. Se pueden hacer de las dos formas.
singers.each {x -> println(x)}
singers.each {println(it)}

println()
//while
int z = 0
while (z < counterCourse){
    println "Pepe Garcia con while ha hecho " + (z+1) + " cursos"
    z++
}