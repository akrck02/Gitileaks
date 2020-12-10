let elemento;

elemento = document;
console.log(elemento);
elemento = document.all;
console.log(elemento);
elemento = document.all[0];
console.log(elemento);
elemento = document.head;
console.log(elemento);
elemento = document.body;
console.log(elemento);
elemento = document.domain;
console.log(elemento);
elemento = document.URL;
console.log(elemento);
elemento = document.characterSet;
console.log(elemento);
elemento = document.contentType;
console.log(elemento);
elemento = document.forms;
console.log(elemento);
elemento = document.forms[0];
console.log(elemento);
elemento = document.forms[0].id;
console.log(elemento);
elemento = document.forms[0].method;
console.log(elemento);
elemento = document.forms[0].action;
console.log(elemento);
elemento = document.links;
console.log(elemento);
elemento = document.links[0].id;
console.log(elemento);
elemento = document.links[0].className;
console.log(elemento);
elemento = document.forms[0].classList;
console.log(elemento);
elemento = document.forms[0].classList[0];
console.log(elemento);

elemento = document.images;
console.log(elemento);

elemento = document.scripts;
console.log(elemento);

elemento = document.images[2].getAttribute('src');
console.log(elemento);

// Loop a los scripts
let scripts = document.scripts;
let scriptsArr = Array.from(scripts);

scriptsArr.forEach(function(script) {
    console.log(script);
});

// Array de imágenes:

let imagenes = document.images;
let imagenesArr = Array.from(imagenes);

console.log(imagenesArr);

imagenesArr.forEach(function(imagen) {
    console.log(imagen);
});