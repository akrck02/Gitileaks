// Forma antigua

function add(a, b) {
    return a + b;
}
console.info(add(2, 4)); // 6
console.info(add(4, 4)); // 8
console.info(add(1, 2)); // 3


// Función de flecha

var suma = (x, y) => x + y;

console.info(suma(2, 4)); // 6
console.info(suma(4, 4)); // 8
console.info(suma(1, 2)); // 3

// Un sólo parámetros

var double = x => x * 2;

console.info(double(2)); // 4
console.info(double(5)); // 10


// Si no necesitamos parámetros, tenemos que incluir el paréntesis vacío:

var hi = () => 'Hello World';

console.info(hi()); // Hello World

// El objeto arguments no funciona

var test = () => arguments;

console.info(test('foo', 'bar')); // ERROR: arguments is not defined

// Sin embargo, el operador de arrastre sí lo hace correctamente:

var test = (...args) => args;

console.info(test('foo', 'bar')); // [ 'foo', 'bar' ]