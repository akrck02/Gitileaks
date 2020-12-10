// Funciones de Tiempo

setTimeout(function() {

    console.log("Pasó un segundo");


}, 1000);




var segundos = 0;

var intervalo = setInterval(function() {

    segundos++;

    if (segundos === 3) {
        clearInterval(intervalo);
    }
    console.log("seg", segundos);

}, 1000);



var txema = {
    nombre: "Txema",
    edad: 50,
    imprimir: function() {

        var self = this; // Dentro de esta función apunta al elemento correcto
        setTimeout(function() {
            console.log(self.nombre, self.edad);
        }, 4000);
    }
};


txema.imprimir();