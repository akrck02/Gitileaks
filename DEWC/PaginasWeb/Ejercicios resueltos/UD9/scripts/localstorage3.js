// JavaScript Document
function iniciar(){
	var boton=document.getElementById('grabar');
	boton.addEventListener('click', nuevoitem);
	addEventListener("storage", storagechange);
	mostrar();
}
function nuevoitem(){
	var clave=document.getElementById('clave').value;
	var valor=document.getElementById('texto').value;
	localStorage.setItem(clave,valor);
	document.getElementById('clave').value='';
	document.getElementById('texto').value='';
	mostrar();
} 
function storagechange(e){
	console.log(e.key);
	console.log(e.oldValue);
	console.log(e.newValue),
	console.log(e.url)
	console.log(e.storageArea)
	mostrar();
}
function mostrar(){
	var cajadatos=document.getElementById('cajadatos');
	cajadatos.innerHTML='';
	for(var f=0;f<localStorage.length;f++){
		var clave=localStorage.key(f);
		var valor=localStorage.getItem(clave);
		cajadatos.innerHTML+='<div>'+clave+' - '+valor+'</div>';
	}
}
window.addEventListener('load', iniciar);