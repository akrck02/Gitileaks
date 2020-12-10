function sumar(a, b) {
    return a + b;
}
function saludar(nombre) {
    return "Hola, soy " + nombre;
}
function salvarMundo() {
    console.log('El mundo está salvado');
}
var miFuncion1;
var miFuncion2;
miFuncion1 = sumar;
console.log(miFuncion1(5, 5));
miFuncion2 = saludar;
console.log(miFuncion2('Txema'));
var miFuncion3;
miFuncion3 = salvarMundo;
miFuncion3();
miFuncion3 = salvarMundo;
