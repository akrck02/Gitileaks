let aprendiendo;

aprendiendo = function() {
    console.log('Aprendiendo JavaScript');
}

aprendiendo = () => {
    console.log('Aprendiendo JavaScript');
}

// Una línea no requiere llave
aprendiendo = () => console.log('Aprendiendo JavaScript');
aprendiendo();

// Retorna valor
aprendiendo = () => 'Aprendiendo JavaScript';
console.log(aprendiendo());

// Retornar objeto
aprendiendo = () => ({ aprendiendo: 'Aprendiendo JavaScript' });
console.log(aprendiendo());
// Paso de parametros

aprendiendo = (tecn1, tecn2) => console.log(`Aprendiendo ${tecn1} y ${tecn2}`);

aprendiendo('ES6', 'JavaScript');

const productos = ['Disco', 'Camisa', 'Guitarra'];


/* Con callback
const letrasProducto = productos.map(function(producto) {
    return producto.length;
});
*/
const letrasProducto = productos.map((producto) => {
    return producto.length;
});

console.log(letrasProducto);

// Ejemplo con forEach
/*
productos.forEach(function(producto) {
    console.log(producto);
})
*/
productos.forEach(producto => { console.log(producto); })