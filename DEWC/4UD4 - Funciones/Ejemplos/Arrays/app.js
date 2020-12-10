// Crear un arreglo
const numeros = [10, 20, 30, 40, 50];
console.log(numeros);

// Arreglo de strings con meses
const meses = new Array('Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio');
console.log(meses);

// Arreglo de todo mezclado
const deTodo = ["Hola", 10, true, "si", null];
console.log(deTodo);

// Saber cuantos elementos hay un array.
console.log(meses.length);

// saber si es un arreglo
let nombre = 'Juan';
console.log(Array.isArray(nombre));

// Acceder a un elemento del arreglo
console.log(meses[3]);

// Añadir al arreglo
meses[3] = 'Diciembre';
console.log(meses);

// Encontrar un valor en el arreglo
console.log(meses.indexOf('Diciembre'));

// Agregar algo al arreglo al final
meses.push('Noviembre');

// añade al principio
meses.unshift('Mes 0');

// Eliminar del final
meses.pop();

// Eliminar del principio
meses.shift();

// Quitar un rango
meses.splice(0, 2);

// Reverse
meses.reverse();
console.log(meses);

// unir un arreglo a otro
let arreglo1 = [1, 2, 3];
let arreglo2 = [9, 8, 7];
console.log(arreglo1.concat(arreglo2));

// ordenar
let frutas = ['Platano', 'Manzana', 'Fresa', 'Naranja'];

frutas.sort();

console.log(frutas);

// Ordenar numeros;
arreglo1 = [1, 3, 100, 4, 6, 7, 3, 2, 14, 67];

// Ordenar de menor a mayor
arreglo1.sort(function(x, y) {
    return x - y;
});

// Ordenar de mayor a menor
arreglo1.sort(function(x, y) {
    return y - x;
});


console.log(arreglo1);