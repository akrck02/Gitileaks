// Funciones Básicas
function sumar(a, b) {
    return a + b;
}
console.log(sumar(4, 10));
var micontar = function (heroes) {
    return heroes.length;
};
var misuperHeroes = ["Flash", "Arrow", "Superman", "Linterna Verde"];
console.log(micontar(superHeroes));
//Parametros por defecto
function millamarBatman(llamar) {
    if (llamar === void 0) { llamar = true; }
    if (llamar) {
        console.log("Batiseñal activada");
    }
}
console.log(millamarBatman());
// Rest?
function miunirheroes() {
    var personas = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        personas[_i] = arguments[_i];
    }
    return personas.join(", ");
}
//console.log(miunirheroes(superHeroes[]));
// Tipo funcion
function minoHaceNada(numero, texto, booleano, arreglo) {
}
// Crear el tipo de funcion que acepte la funcion "noHaceNada"
var minoHaceNadaTampoco;
minoHaceNadaTampoco = minoHaceNada;
