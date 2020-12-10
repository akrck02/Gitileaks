// Parámetros por defecto
function minombrecompleto(nombre, apellido, capitalizado) {
    if (capitalizado === void 0) { capitalizado = true; }
    if (capitalizado) {
        return capitalizar(nombre) + ' ' + capitalizar(apellido);
    }
    else {
        return nombre + ' ' + apellido;
    }
}
function capitalizar(palabra) {
    return palabra.charAt(0).toUpperCase() + palabra.substr(1).toLowerCase();
}
var izena = minombrecompleto("barry", "white");
console.log(izena);
