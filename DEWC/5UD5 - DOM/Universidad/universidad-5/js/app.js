// Crear Enlace

const enlace = document.createElement('a');

// Agregamos una clase
enlace.className = 'enlace';

// Agregamos un id
enlace.id = 'nuevo-id';

//Agregamos un href
enlace.setAttribute('href', 'http://www.google.com');

// Añadir Texto
enlace.textContent = 'Google';

// Agregamos al html

document.querySelector('#secundaria').appendChild(enlace);

console.log(enlace);