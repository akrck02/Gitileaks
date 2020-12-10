function saludar(nombre) {
    console.log("Hola " + nombre)
}
// Y para llamar:
saludar("Txema");

// O de esta forma

let saludo = function(nombre) {
    console.log("Hola " + nombre)
}

// Y para llamar:
saludo("Jose Mari");

let saludoLargo = (nombre, edad) => {
        console.log("Hola %s tienes %d años", nombre, edad)
    }
    // Y para llamar:
saludoLargo("Luis", 30);

// Variables de retorno

let sumar = (primerNumero, segundoNumero) => {
    return primerNumero + segundoNumero;
}

console.log(sumar(12, 18));

// Como callbacks

[1, 2, 3].forEach(function(numero) {
    console.log(numero);
});

//Flecha
[1, 2, 3].forEach(numero => {
    console.log(numero)
});

[2, 3, 5].map(function(numero) {
    //O numero ** 2
    // O Math.pow(numero, 2)
    console.log(numero * numero);
});

//Flecha
[2, 3, 5].map(numero => console.log(numero * numero));