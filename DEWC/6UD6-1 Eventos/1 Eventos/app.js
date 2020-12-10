// Eventos

function evento(arg) {
    console.log("Me disparé");
    console.log(arg.x, arg.y);
}

var objeto = document.getElementById("objdemo");

objeto.addEventListener("click", evento);