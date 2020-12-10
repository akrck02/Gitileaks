// Eliminar elemento

const enlaces = document.querySelectorAll('.enlace');
const navegacion = document.querySelector('#principal');

// Eliminamos el primer enlace: cualquiera de las dos opciones

enlaces[0].remove();
//navegacion.removeChild(enlaces[0]);

console.log(enlaces);

// Selecciono el primer enlace
const primerLi = document.querySelector('.enlace');
console.log(primerLi);

let elemento;

// Obtener clases de CSS
elemento = primerLi.className;
console.log(elemento);

elemento = primerLi.classList.add('nueva-clase');

elemento = primerLi.classList;
console.log(elemento);

// Leer atributos

elemento = primerLi.getAttribute('href');
console.log(elemento); // Muestra #
primerLi.setAttribute('href', 'http://facebook.com');

elemento = primerLi;
console.log(elemento); // 

primerLi.setAttribute('data-id', 20);
elemento = primerLi.hasAttribute('data-id');


/* Para quitar el atributo
primerLi.removeAttribute('data-id');
*/

console.log(elemento);