// JavaScript Document
var cajadatod, bd
function iniciar(){
	var solicitud=indexedDB.open('mibase');
	solicitud.addEventListener('error', errores);
	solicitud.addEventListener('success', crear);
	solicitud.addEventListener('upgradeneeded', crearbd);
	
	cajadatos=document.getElementById('cajadatos');
	var boton=document.getElementById('buscar');
	boton.addEventListener('click', buscarobjetos);
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

function buscarobjetos(){
	cajadatos.innerHTML='';
	var buscar=document.getElementById('fecha').value;
	var transaccion=bd.transaction(['peliculas']);
	var almacen=transaccion.objectStore('peliculas');
	var indice=almacen.index('BuscarFecha');
	var rango=IDBKeyRange.only(buscar);
	var cursor=indice.openCursor(rango);
	cursor.addEventListener('success', mostrarlista, false);
}

function mostrarlista(e){
	var cursor=e.target.result;
	if (cursor){
		cajadatos.innerHTML+='<div>'+cursor.value.id+' - '+cursor.value.nombre+'- '+cursor.value.fecha+'</div>';
		cursor.continue();
	}
}

window.addEventListener('load', iniciar);