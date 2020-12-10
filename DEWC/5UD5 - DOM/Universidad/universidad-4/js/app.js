// Traversing
let elemento;

let enlaces = document.querySelector('#principal');
const listaEnlaces = document.querySelector('.enlace');

// Get ChildNodes // Nodelist de todo
elemento = enlaces.childNodes;

// get Children // elementos
elemento = enlaces.children;

// Arrayde enlaces
console.log(elemento);
// elemento = enlaces.children[0].nodeName;
//  elemento = enlaces.children[0].nodeType;
// 1 = Elemento
// 2 - Atributo
// 3 - Text node
// 8 - Commentario
// 9 - Documento
// 10 doctype


// Hacemos un arry de las cards

let cursos = document.querySelectorAll('.card');
console.log(cursos);

console.log(cursos[0].childElementCount);

// Cambio el texto del tercer enlace

enlaces.children[2].textContent = 'Hola';

// hijo del hijo
//elemento = enlaces.children[3].children[0].textContent;

// First Child
elemento = enlaces.lastChild;
elemento = enlaces.lastElementChild;

console.log('Ultimo elemento ' + elemento);

// Primer Hijo
elemento = enlaces.firstChild;
elemento = enlaces.firstElementChild;

console.log('Primer elemento ' + elemento);

// Contar los elementos
elemento = enlaces.childElementCount;

console.log(elemento);

console.log('El padre de la Lista de enlaces');
enlaces = document.querySelectorAll('.enlace');
console.log(enlaces[0].parentElement); // nav id="principal"

// Padre
let enlace = document.querySelector('li');

// Parent Node
elemento = enlace.parentNode;
elemento = enlace.parentElement;
elemento = enlace.parentElement.parentElement.parentElement;
console.log(elemento);


// Seguimos con los cursos
// Hacemos un treversing desde una card para cambiar el contenido del Titulo

console.log(cursos[0].parentElement.parentElement.parentElement.children[0].textContent = 'Hola desde traversing');


// siBLING (siguiente)
console.log(enlaces[0].nextElementSibling.nextElementSibling.parentElement.children[1]);