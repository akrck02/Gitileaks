// JavaScript Document
var cajadatod, bd
function iniciar(){
	var solicitud=indexedDB.open('mibase');
	solicitud.addEventListener('error', errores);
	solicitud.addEventListener('success', crear);
	solicitud.addEventListener('upgradeneeded', crearbd);
	
	cajadatos=document.getElementById('cajadatos');
	var boton=document.getElementById('grabar');
	boton.addEventListener('click', agregarobjeto);
}
function errores(e){
	alert("Ha ocurrido un error");
} 
function crear(e){
	bd=e.target.result;
	mostrar()
}
function crearbd(e){
	var bd=e.target.result;
	var almacen=bd.createObjectStore('peliculas',{keyPath:'id'});
	almacen.createIndex('BuscarFecha','fecha',{unique:false});
}

function agregarobjeto(){
	var clave=document.getElementById('clave').value;
	var titulo=document.getElementById('texto').value;
	var fecha=document.getElementById('fecha').value;
	var transaccion=bd.transaction(['peliculas'],'readwrite');
	var almacen=transaccion.objectStore('peliculas');
	var solicitud=almacen.add({id: clave, nombre: titulo, fecha: fecha});
	solicitud.addEventListener('success',mostrar);
	document.getElementById('clave').value='';
	document.getElementById('texto').value='';
	document.getElementById('fecha').value='';
}
function mostrar(){
	cajadatos.innerHTML='';
	var transaccion=bd.transaction(['peliculas'],'readwrite');
	var almacen=transaccion.objectStore('peliculas');
	var nuevocusor=almacen.openCursor();
	nuevocusor.addEventListener('success', mostrarlista);
} 
function mostrarlista(e){
	var cursor=e.target.result;
	if (cursor){
		cajadatos.innerHTML+='<div>'+cursor.value.id+' - '+cursor.value.nombre+'- '+cursor.value.fecha+'<input type="button" onclick="eliminar(\''+cursor.value.id+'\')" value="Eliminar"></div>';
		cursor.continue();
	}
}
function eliminar(clave){
	if (confirm('¿Está seguro?')){
		var transaccion=bd.transaction(['peliculas'],'readwrite');
		var almacen=transaccion.objectStore('peliculas');
		var solicitud=almacen.delete(clave);
		solicitud.addEventListener('success',mostrar);
		solicitud.addEventListener('error', errores);
	}
}
window.addEventListener('load', iniciar);