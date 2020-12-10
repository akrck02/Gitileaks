// SELECCIONAR ELEMENTOS DEL DOM
console.log(document.getElementById('encabezado'));

// Obtener datos del elemento
console.log(document.getElementById('encabezado').id);
console.log(document.getElementById('encabezado').className);
console.log(document.getElementById('encabezado').textContent);

// cambiar el CSS
// Texto en rojo sobre fondo gris

let encabezado = document.getElementById('encabezado');
encabezado.style.background = '#333'; // Gris
encabezado.style.color = '#FFF'; // Blanco
encabezado.style.padding = '20px';

// Cambiar Contenido
encabezado.textContent = 'Los Mejores Cursos';
// otra forma
encabezado.innerText = 'Los Mejores Cursos';


// Query selector con Id
encabezado = document.querySelector('#encabezado');

// Query Selector con Clase
const subtitulo = document.querySelector('.subtitulo');

// Query selector con etiqueta
const h1 = document.querySelector('h1');

// si hay distintos solo tomara el primero
// también se puede hacer nesting como css: ul li
let imagenes = document.querySelector('.card img');

// Te retorna la primera imagen

console.log(h1.style.color = 'red');

// li:nth-child(3)  o li:last-child  o li:first-child
let enlace;

enlace = document.querySelector('#principal a:last-child');
enlace = document.querySelector('#principal a:nth-child(2)');
enlace = document.querySelector('#principal a:first-child');