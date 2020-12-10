//var reg1=RegExp("a");

var reg2 = /a/;

var texto = "Hola Mundo, 12345.\nQué tal?";
var texto2 = "Holaa Mundoo de nuevoooo";
console.log(texto2);

var arr1 = texto.match(/^H/);
var arr2 = texto.match(/^o/);

// i = insensible
// g = todas las apariciones
// m= multinlinea

var arr3 = texto.match(/[0-9]/);
var arr4 = texto.match(/[06789]/);
var arr5 = texto.match(/[a-zA-Z]/);
var arr6 = texto.match(/^H[aeiou]/);
var arr7 = texto.match(/[aeiou].$/);
var arr8 = texto.match(/\s/); // Patrón del espacio en blanco
var arr9 = texto.match(/[a-zA-Z0-9]/); // Números y letras

var arr10 = texto.match(/\w/); // Números y letras
var arr11 = texto.match(/\d/); // Solo números

var arr12 = texto.match(/\m/i); // Solo números
var arr13 = texto.match(/[aeiouáéíóú]/ig); // Solo números

var arr14 = texto2.match(/o/ig); // repeticiones

var arr15 = texto2.match(/o+/g); // 1 o más veces

var arr16 = texto2.match(/o{2,3}/g); // 1 o más veces

// /^ es el primer caracter

//	$/ es el ultimo
//	. es cualquiere caracter
// [] se emplea para rangos


//  Devuelve un arreglo si y solo sí aparece la expresión regular en el texto
//  caso contrario un null index devuelve la posición dentro del texto

// Caracteres especiales /

console.log(arr1);
console.log(arr2);
console.log(arr3);
console.log(arr4);
console.log(arr5);
console.log(arr6);
console.log(arr7);
console.log(arr8);
console.log(arr9);
console.log(arr10); //Lo mismo que la arr9
console.log(arr11);
console.log(arr12);
console.log(arr13);

console.log(arr14);

console.log(arr15);
console.log(arr16);