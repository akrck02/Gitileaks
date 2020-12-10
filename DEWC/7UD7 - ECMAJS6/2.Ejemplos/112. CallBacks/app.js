// Listado de paises

const paises = ['Francia', 'España', 'Portugal', 'Australia', 'Inglaterra', 'Irlanda'];

// Se agrega un nuevo país después de 2 segundo
function nuevoPais(pais, callback) {
    setTimeout(function() {
        paises.push(pais);
        callback();
    }, 2000);
}

// Los paises se muestran después de 1 segundo
function mostrarPaises() {
    setTimeout(function() {
        let html = '';
        paises.forEach(function(pais) {
            html += `<li>${pais}</li>`;
        });
        document.getElementById('app').innerHTML = html;
    }, 1000);
}

// Agregar nuevo Pais

nuevoPais('Alemania', mostrarPaises);

// Mostrar los paises
mostrarPaises();

// Los callBacks son como funciones en cadena