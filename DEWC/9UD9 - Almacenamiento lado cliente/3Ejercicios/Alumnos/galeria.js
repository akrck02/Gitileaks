function abrirGaleria2() {
    window.open("galeria_2.html", "_self");
}
function abrirGaleria1() {
    window.open("galeria_1.html", "_self");
}
function guardarImagen() {
    var id = document.getElementById("id").value;
    var ruta = document.getElementById("ruta").value;
    var width = parseInt(document.getElementById("width").value);
    var height = parseInt(document.getElementById("height").value);
    localStorage.setItem(id, ruta + ";" + width + ";" + height);
    vaciarText();
}
function cargarGaleria() {
    for ( var i = 0; i < localStorage.length; i++){
        var id = localStorage.key(i);
        var split = localStorage.getItem(id).split(";");
        var img = document.createElement("img");
        img.setAttribute("src",split[0]);
        img.setAttribute("alt",id);
        img.setAttribute("width", "50");
        img.setAttribute("height", "50");
        img.setAttribute("onclick","verImagen(" + id + ")");
        document.getElementById("divimg").appendChild(img);
    }
}
function verImagen(id) {
    if (document.getElementById("imagen") == null){
        var img = localStorage.getItem(id).split(";");
        //Carga un div con la imagen y el botón de cerrar
        var div = document.createElement("div");
        div.setAttribute("id", "imagen");
        div.innerHTML = "<div style='position:relative ; left: -50%;'>"
                        + "<div><img src='" + img[0] + "' alt='" + img[0] + "' width='" + img[1] + "' height='" + img[2] + "' /></div>"
                        + "<button onclick='cerrarImagen()' style='margin:auto'>CERRAR</button></div>";
        div.setAttribute("style", "position: absolute; left: 50%;");
        document.body.appendChild(div);
    }
}
function cerrarImagen() {
    var element = document.getElementById("imagen");
    element.parentNode.removeChild(element);
}
function vaciarText() {
    document.getElementById("id").value = "";
    document.getElementById("ruta").value = "";
    document.getElementById("width").value = "";
    document.getElementById("height").value = "";
}