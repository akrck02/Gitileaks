var provincias = new Array("Araba", "Bizkaia", "Gipuzkoa", "Nafarroa", "Lapurdi", "Zuberoa", "Nafarroa Beherea")

var municipios_1 = new Array("Seleccione Municipio", "Vitoria-Gasteiz", "Amurrio", "El Ciego", "La Guardia");
var municipios_2 = new Array("Seleccione Municipio", "Bilbao", "Barakaldo", "Durango", "Elorrio", "Muzkiz");
var municipios_3 = new Array("Seleccione Municipio", "Donostia-San Sebastián", "Arrasate-Mondragón", "Eibar");
var municipios_4 = new Array("Seleccione Municipio", "Iruña", "Burlada", "Estella-Lizarra", "Tafalla");
var municipios_5 = new Array("Seleccione Municipio", "Baiona", "Bastida", "Hendaya", "Miarritze");
var municipios_6 = new Array("Seleccione Municipio", "Maule", "Barkoxe", "Sohüta");
var municipios_7 = new Array("Seleccione Municipio", "Baigorri", "Garazi", "Oztibarre");

var todosMunicipios = [
    [],
    municipios_1,
    municipios_2,
    municipios_3,
    municipios_4,
    municipios_5,
    municipios_6,
    municipios_7,
];

function muni_default(){
    var opcion=document.createElement("option");
    opcion.innerHTML="Seleccione Municipio";
    opcion.setAttribute("value", "Seleccione Municipio");
    document.getElementById("municipios").appendChild(opcion);
    document.getElementById("mensaje").innerHTML="";
}
window.onload=function(){
    provincias.forEach(provincia => {
        var opcion=document.createElement("option");
        opcion.innerHTML=provincia;
        opcion.setAttribute("value", provincia);
        document.getElementById("provincias").appendChild(opcion);
    });
    muni_default();
};
function cargarMunicipios(){
    var elemento=document.getElementById("municipios");
    while(elemento.hasChildNodes()){
        elemento.removeChild(elemento.firstChild);
    }
    var indice=document.getElementById("provincias").options[document.getElementById("provincias").selectedIndex]; 
    indice=indice.getAttribute("value");
    indice=provincias.indexOf(indice)+1;
    if(indice==0){
        muni_default();
    }
    console.log(indice);
    var munis=todosMunicipios[indice];
    munis.forEach(muni => {
        var opcion=document.createElement("option");
        opcion.innerHTML=muni;
        opcion.setAttribute("value", muni);
        document.getElementById("municipios").appendChild(opcion);
    });
}
function mensaje(){
    var elem=document.getElementById("municipios");
    var seleccionado=elem.options[elem.selectedIndex].getAttribute("value");
    if(seleccionado!="Seleccione Municipio"){
        var provs=document.getElementById("provincias");
        var prov=provs.options[provs.selectedIndex].getAttribute("value");
        document.getElementById("mensaje").innerHTML=`Ha seleccionado <strong>${seleccionado}</strong> en <strong>${prov}</strong>`;
    }
    else{
        document.getElementById("mensaje").innerHTML="";
    }
}