// Parámetros opcionales ?
function minombreCompleto(nombre, apellido) {
    if (apellido) {
        return nombre + ' ' + apellido;
    }
    else {
        return nombre;
    }
}
var minombre = minombreCompleto("Barry");
console.log(minombre);
