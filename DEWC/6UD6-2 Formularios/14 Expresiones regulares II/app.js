// var reg1=RegExp("a");
// var reg2=/a/;
// i = insensible
// g = todas las apariciones
// m = multilinea



var texto = "Aeropuerto";
var texto2 = "La respuesta de la suma es: 45+60 = 105";
console.log(texto);

// Cualquier conjunto de vocales que se repitan dos veces

var arr = texto.match(/[aeiou]{2,2}/ig);
var arr2 = texto2.match(/\d{1,}|respuesta/g);

console.log(arr);
console.log(arr2);

// mozilla regular expresions