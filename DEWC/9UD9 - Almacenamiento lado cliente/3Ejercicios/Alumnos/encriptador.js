function registrar() {
    var nom = document.getElementById("nombre").value;
    var apellidos = document.getElementById("apellidos").value;
    var dni  = document.getElementById("dni").value;
    var pass = encriptar(document.getElementById("pass").value, dni);
    localStorage.setItem(dni, nom + ";" + apellidos + ";" + pass);
    
    ver(dni);
    vaciar();
}
function ver(dni) {
    var split = localStorage.getItem(dni).split(";");
    document.getElementById("pdni").innerHTML = '<b>DNI: </b>' + dni;
    document.getElementById("pnombre").innerHTML = '<b>Nombre: </b>' + split[0];
    document.getElementById("papellidos").innerHTML = '<b>Apellidos: </b>' + split[1];
    document.getElementById("ppass").innerHTML = '<b>Contraseña: </b>' + desencriptar(split[2], dni);
}
function encriptar(pass, dni){
    var str = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789';
    var pos = damepos(dni, str.length);
    var newpass = "";
    
    for ( var i = 0; i < pass.length; i++){
        var char = pass.charAt(i);
        var index = str.indexOf(char);
        var j = index+pos;
        while (j > str.length){
            j -= str.length;
        }
        newpass += str.charAt(j);
    }
    return newpass;
}
function desencriptar(pass, dni) {
    var str = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789';
    var pos = damepos(dni, str.length);
    var newpass = "";
    
    for ( var i = 0; i < pass.length; i++){
        var char = pass.charAt(i);
        var index = str.indexOf(char);
        var j = index-pos;
        while (j < 0){
            j += str.length;
        }
        newpass += str.charAt(j);
    }
    return newpass;
}
function vaciar() {
    document.getElementById("nombre").value = "";
    document.getElementById("apellidos").value = "";
    document.getElementById("dni").value = "";
    document.getElementById("pass").value = "";
}
function damepos(dni, len) {
    var dninum = 1;
    for (var i = 0; i < dni.length-1; i++){
        var n = parseInt(dni.charAt(i));
        if (n != 0){
            dninum *= n;
        }
    }
    return dninum % len;
}