// JavaScript Document

function nuevoitem(){
	var clave=document.getElementById('clave').value;
	var valor=document.getElementById('texto').value;
	sessionStorage.setItem(clave,valor);
	//sessionStorage.clave=valor;
	//sessionStorage[clave]=valor;
	mostrar(clave);
} 
function mostrar(clave){
	var cajadatos=document.getElementById('cajadatos');
	//var valor=sessionStorage.getItem(clave);
	var valor=sessionStorage.clave;
	var valor=sessionStorage[clave];
	cajadatos.innerHTML='<div>'+clave+' - '+valor+'</div>';
} 
window.addEventListener('load', iniciar);
function iniciar(){
	var boton=document.getElementById('grabar');
	boton.addEventListener('click', nuevoitem);
}
/*window.onload=function(){
	document.getElementById("grabar").onclick=nuevoitem
}*/
