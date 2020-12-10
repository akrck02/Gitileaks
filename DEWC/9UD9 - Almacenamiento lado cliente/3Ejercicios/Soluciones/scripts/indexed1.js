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
	solicitud.addEventListener('success', function(){mostrar(clave)},false);
	document.getElementById('clave').value='';
	document.getElementById('texto').value='';
	document.getElementById('fecha').value='';
}
function mostrar(clave){
	var transaccion=bd.transaction(['peliculas'],'readwrite');
	var almacen=transaccion.objectStore('peliculas');
	var solicitud=almacen.get(clave);
	solicitud.addEventListener('success', mostrarlista,false);
} 
function mostrarlista(e){
	var resultado=e.target.result;
	cajadatos.innerHTML='<div>'+resultado.id+' - '+resultado.nombre+'- '+resultado.fecha+'</div>';
}
window.addEventListener('load', iniciar);