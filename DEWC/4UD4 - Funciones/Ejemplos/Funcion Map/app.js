// Recorrer un arreglo
let pendientes = ['Tarea', 'Comer', 'Proyecto', 'Estudiar JavaScript'];

for (let i = 0; i < pendientes.length; i++) {
    console.log(pendientes[i]);
}

// Recorrer por un Foreach
pendientes.forEach(function(pendiente, index) {
    console.log(`${index} : ${pendiente}`);
});

// MAP recorrer arreglo de objetos
const carrito = [
    { id: 1, producto: 'Libro' },
    { id: 2, producto: 'Camisa' },
    { id: 3, producto: 'Disco' }
];

const nombreProducto = carrito.map(function(carrito) {
    return carrito.producto;
});

console.log(nombreProducto);

// Otro método
let automovil = {
    modelo: 'Camaro',
    motor: '6.0',
    anio: '1969',
    marca: 'Chevrolet'
}

for (let auto in automovil) {
    console.log(`${auto} : ${automovil[auto]}`);
}