// json

// http://json.org

// Importante para comprimir informacuón

var objetoJS = {
	nombre:"Txema",
	edad:47,

	// La función no puede transmitir se a JSON
	imprimir:function(){
		console.log(this.nombre, this.edad);
	}
};

console.log("Objeto literal:",objetoJS);

var jsonString = JSON.stringify(objetoJS);

console.log(jsonString);



// Vemos en http://json.parse.online.fr para ver si es correcto


var objetoDesdeJson = JSON.parse(jsonString);

// Ya evaluado el JSON

console.log(objetoDesdeJson);

console.log(objetoDesdeJson.nombre);
console.log(objetoDesdeJson.edad);

