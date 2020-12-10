// Bloqueando el botón derecho del ratón

function validar(){

	var nombre = document.getElementById("txtNombre").value;
	var apellido = document.getElementById("txtApellido").value;	

	if (nombre.length < 1){
		return false;
	}

	if (apellido.length < 1){
		return false;
	}

	return true;

}

function getParamURL(name) {
  return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null
}

console.log(window.location.search);
console.log(window.location.search.split("&")); // Sacamos cada uno de los parámetros

console.log(getParamURL("txtNombre")); // Me da la información que contiene la caja de texto