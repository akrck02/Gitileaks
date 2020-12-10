// Parámetros Rest
// Todo lo que venga por parámetro juntar en un array
function nombrecompleto(nombre) {
    var losDemasParametros = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        losDemasParametros[_i - 1] = arguments[_i];
    }
    return nombre + " " + losDemasParametros.join(" ");
}
var Hulk = nombrecompleto("Bruce", "Howard");
var Ironman = nombrecompleto("Antony", "Eward");
console.log(Hulk);
console.log(Ironman);
