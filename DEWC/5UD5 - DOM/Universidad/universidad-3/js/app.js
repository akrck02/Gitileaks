// document.getElementsByClassName

let enlaces = document.getElementsByClassName('enlace');
// console.log(enlaces);
enlaces[0].style.color = 'red';
enlaces[2].textContent = 'Nuevo Enlace';
enlaces[3].textContent = 'Hola!!!!';
console.log(enlaces[0]);

// Tambien se pueden mezclar las funciones
let listaEnlaces = document.querySelector('ul').getElementsByClassName('links');

console.log(listaEnlaces);

// document.getElementsByTagName
enlaces = document.getElementsByTagName('li');
console.log(enlaces[0]);

enlaces[0].style.color = 'red';
enlaces[0].textContent = 'Hola!!';

// Convertir collecion hTML en arreglo
enlaces = Array.from(enlaces);
console.log(enlaces);

enlaces.forEach(function(li) {
    console.log(li.textContent);
});

// document.querySelectorAll
// retorna un nodelist

enlaces = document.querySelectorAll('nav .enlace');
console.log('Array de enlaces')
console.log(enlaces);

console.log('Text Content de cada enlace');
enlaces.forEach(function(enlace) {
    console.log(enlace.textContent);
});

const links = document.querySelectorAll('#principal a:nth-child(odd)');

console.log(links);

// Para los enlaces seleccionados tomamos el fondo rojo y el texto blanco
links.forEach(function(impar) {
    impar.style.backgroundColor = 'red';
    impar.style.color = 'white';
});

const impares = document.querySelectorAll('ul li:nth-child(odd)');

console.log(impares);

const liPares = document.querySelectorAll('ul li:nth-child(even)');

console.log(liPares);