// Promise

// result se jeceuta cuando la promesa se cumple
// reject se ejecuta cuando la promesa no se cumple

// Se ejecuta el promise una que resolve haya terminado

const esperando = new Promise(function(resolve, reject) {
    setTimeout(function() {
        resolve('Se ejecutó');
    }, 5000);
});

// Todas las promesas van con then asociado
esperando.then(function(mensaje) {
    console.log(mensaje);
})

// Promise con reject
const aplicarDescuento = new Promise(function(resolve, reject) {
    const descuento = false;
    if (descuento) {
        resolve('Descuento aplicado');
    } else {
        reject('No se puede aplicar el descuento');
    }
});

aplicarDescuento.then(function(resultado) {
    console.log(resultado);
}).catch(function(error) {
    console.log(error);
});