var heroe = "Txema";
var edad = 45;
var mensaje = imprimir(heroe, edad);
console.log(mensaje);
function imprimir(heroe, edad) {
    heroe = heroe.toLocaleLowerCase();
    edad = edad + 10;
    return heroe + " " + edad;
}
