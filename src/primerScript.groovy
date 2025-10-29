//definicion de la variable x, inicializada con valor 5
def x= 5
//Se incrementa en 3
x+=3
//se imprime en consola
println x

//se comprueba el resultado
// - Si ponemos 8, dara resultado ok
//assert x==8
// - Si ponemos distinto de 8, dara una excepcion y podemos escribir un mensaje
assert x==11: "El valor de x no es 11"