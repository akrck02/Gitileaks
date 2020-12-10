// Bloqueando el botón derecho del ratón

document.onmousedown = function(arg) {

    if (arg.button === 2) { // Botón derecho se bloquea
        alert("click bloqueado");
        return;
    }

    console.log("No hay problema");
    console.log(arg);
}

document.onmouseup = function(arg) {

    var texto = window.getSelection().toString();
    if (arg.button === 2) { // Botón derecho se bloquea
        alert("click bloqueado");
        return;
    }

    console.log(texto);
}