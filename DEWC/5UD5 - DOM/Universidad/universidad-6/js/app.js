// Reemplazar elementos

const nuevoEncabezado = document.createElement('h2');

// Agregar un id

nuevoEncabezado.id = 'encabezado';

// Nuevo texto al Encabezado
nuevoEncabezado.appendChild(document.createTextNode('Los Mejores Cursos'));
console.log(nuevoEncabezado);

// Ya está creado. Ahora vamos a reemplazar
// Lo que queremos reemplazar.
const anterior = document.querySelector('#encabezado');

// Elemento padre

const elPadre = document.querySelector('#lista-cursos');

// Reemplazar

elPadre.replaceChild(nuevoEncabezado, anterior);

console.log(anterior.parentElement);