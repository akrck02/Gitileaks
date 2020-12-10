// JavaScript Document
function iniciar(){
	var boton=document.getElementById('grabar');
	boton.addEventListener('click', nuevoitem);
	mostrar();
} 
function nuevoitem(){
	var clave=document.getElementById('clave').value;
	var valor=document.getElementById('texto').value;
	localStorage.setItem(clave,valor);
	mostrar();
	document.getElementById('clave').value='';
	document.getElementById('texto').value='';
} 
function mostrar(){
	var cajadatos=document.getElementById('cajadatos');
	cajadatos.innerHTML='<div><input type="button" onclick="eliminarTodo()" value="Eliminar Todo"/><div>';
	for(var f=0;f<localStorage.length;f++){
		var clave=localStorage.key(f);
		var valor=localStorage.getItem(clave);
		cajadatos.innerHTML+='<div>'+clave+' - '+valor+'<br/><input type="button" onclick="eliminar(\''+clave+'\')" value="Eliminar"/></div>';
	}
} 
function eliminar(clave){
	if(confirm('¿Está Seguro?')){
		localStorage.removeItem(clave);
		mostrar();
	}
}
function eliminarTodo(){
	if(confirm('¿Está Seguro?')){
		localStorage.clear();
		mostrar();
	}
} 
window.addEventListener('load', iniciar);