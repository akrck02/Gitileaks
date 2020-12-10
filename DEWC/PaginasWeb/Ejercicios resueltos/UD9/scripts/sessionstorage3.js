// JavaScript Document
function iniciar(){
	var boton=document.getElementById('grabar');
	boton.addEventListener('click', nuevoitem);
	mostrar();
} 
function nuevoitem(){
	var clave=document.getElementById('clave').value;
	var valor=document.getElementById('texto').value;
	sessionStorage.setItem(clave,valor);
	mostrar();
	document.getElementById('clave').value='';
	document.getElementById('texto').value='';
} 
function mostrar(){
	var cajadatos=document.getElementById('cajadatos');
	cajadatos.innerHTML='<div><input type="button" onclick="eliminarTodo()" value="Eliminar Todo"/><div>';
	for(var f=0;f<sessionStorage.length;f++){
		var clave=sessionStorage.key(f);
		var valor=sessionStorage.getItem(clave);
		cajadatos.innerHTML+='<div>'+clave+' - '+valor+'<br/><input type="button" onclick="eliminar(\''+clave+'\')" value="Eliminar"/></div>';
	}
} 
function eliminar(clave){
	if(confirm('¿Está Seguro?')){
		sessionStorage.removeItem(clave);
		mostrar();
	}
}
function eliminarTodo(){
	if(confirm('¿Está Seguro?')){
		sessionStorage.clear();
		mostrar();
	}
} 
window.addEventListener('load', iniciar);