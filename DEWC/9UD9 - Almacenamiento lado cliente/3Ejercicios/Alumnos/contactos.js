function aniadirContacto() {
    var clave = localStorage.length +1;
    var inpnombre = document.getElementById("nombre");
    var inptelef = document.getElementById("telefono");
    var inpemail = document.getElementById("email");
    var inpcp = document.getElementById("cp");
    var valor = inpnombre.value + ";" + inptelef.value + ";" + inpemail.value + ";" + inpcp.value;
    localStorage.setItem(clave, valor);
    inpnombre.value = "";
    inptelef.value = "";
    inpemail.value = "";
    inpcp.value = "";
    window.open("contactos_1.html","_self");
}


function cargarTodos() {
    vaciarTabla();
    for ( var i = 0; i < localStorage.length; i++){
        var clave = localStorage.key(i);
        var split = localStorage.getItem(clave).split(';');
        var tr = document.createElement('tr');
        tr.setAttribute("name", "contacto");
        var nombre = document.createElement('td');
        nombre.innerHTML = split[0];
        var telefono = document.createElement('td');
        telefono.innerHTML = split[1];
        var email = document.createElement('td');
        email.innerHTML = split[2];
        var cp = document.createElement('td');
        cp.innerHTML = split[3];
        var boton = document.createElement("td");
        boton.innerHTML = "<button onclick=\'eliminar(" + clave + ")\'>Eliminar</button>";
        tr.appendChild(nombre);
        tr.appendChild(telefono);
        tr.appendChild(email);
        tr.appendChild(cp);
        tr.appendChild(boton);
        document.getElementById("contactos").appendChild(tr);
    }
}
function buscar() {
    vaciarTabla();
    var busqueda = document.getElementById("busqueda").value.trim();
    if (busqueda == ""){
        cargarTodos();
    } else {
        var contactos = [];
        for ( var i = 0; i < localStorage.length; i++){
            var clave = localStorage.key(i);
            var split = localStorage.getItem(clave).split(';');
            if (split[0].toLowerCase().includes(busqueda.toLowerCase())){
                var tr = document.createElement('tr');
                tr.setAttribute("name", "contacto");
                var nombre = document.createElement('td');
                nombre.innerHTML = split[0];
                var telefono = document.createElement('td');
                telefono.innerHTML = split[1];
                var email = document.createElement('td');
                email.innerHTML = split[2];
                var cp = document.createElement('td');
                cp.innerHTML = split[3];
                var boton = document.createElement("td");
                boton.innerHTML = "<button onclick=\'eliminar(" + clave + ")\'>Eliminar</button>";
                tr.appendChild(nombre);
                tr.appendChild(telefono);
                tr.appendChild(email);
                tr.appendChild(cp);
                tr.appendChild(boton);
                document.getElementById("contactos").appendChild(tr);
                contactos.push(clave);
            }
        }
        if (contactos.length == 0){
            var tr = document.createElement('tr');
            tr.setAttribute("name", "contacto");
            var td = document.createElement('td');
            td.setAttribute("colspan", "5");
            td.innerHTML = "No hay resultados para la búsqueda";
            tr.appendChild(td);
            document.getElementById("contactos").appendChild(tr);
        }
    }
}
function eliminar(clave){
    localStorage.removeItem(clave);
    location.reload();
}
function abrirAniadir() {
    window.open("contactos_2.html","_self");
}
function vaciarTabla() {
    var tabla = document.getElementById("contactos");
    var contactos = document.getElementsByName("contacto");
    var len = contactos.length;
    for (var n = 0; n < len; n++){
        var contacto = contactos[0];
        tabla.removeChild(contacto);
    }
}