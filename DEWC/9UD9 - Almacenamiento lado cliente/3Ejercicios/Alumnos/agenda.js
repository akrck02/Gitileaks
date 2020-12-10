function verTodo() {
    window.open("agenda_2.html","_self");
}
function nuevaTarea() {
    window.open("agenda_1.html","_self");
}

function guardar() {
    var clave = document.getElementById("clave");
    var tarea = document.getElementById("tarea");
    var importancia = document.getElementById("importancia");
    localStorage.setItem(clave.value, tarea.value + "#" + importancia.value);
    clave.value = "";
    tarea.value = "";
    importancia.value = "";
}

function cargarTareas() {
    var len = len = localStorage.length;
    for ( var i = 0; i < len; i++ ) {
        var clave = localStorage.key(i);
        var split = localStorage.getItem(clave).split('#');
        var tarea = split[0];
        var importancia = split[1];
        var tr = document.createElement("tr");
        var tdclave = document.createElement("td");
        tdclave.innerHTML = clave;
        var tdtarea = document.createElement("td");
        tdtarea.innerHTML = tarea;
        var tdimportancia = document.createElement("td");
        tdimportancia.innerHTML = importancia;
        var tdboton = document.createElement("td");
        tdboton.innerHTML = "<button onclick=\'eliminar(" + clave + ")\'>Eliminar</button>";
        tr.appendChild(tdclave);
        tr.appendChild(tdtarea);
        tr.appendChild(tdimportancia);
        tr.appendChild(tdboton);
        document.getElementById("tareas").appendChild(tr);
    }
}

function eliminar(clave) {
    localStorage.removeItem(clave);
    location.reload();
}