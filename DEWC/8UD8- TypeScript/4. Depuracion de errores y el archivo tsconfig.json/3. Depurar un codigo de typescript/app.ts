

let heroe:string = "Txema";
let edad:number = 45;

let mensaje = imprimir(heroe,edad);

console.log(mensaje);

function imprimir(heroe:string, edad:number):string{
    heroe = heroe.toLocaleLowerCase();
    edad = edad + 10;

    return heroe + " " +edad;
}