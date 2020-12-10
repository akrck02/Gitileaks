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


/*function escribirProvincias(){
    document.write("<select name='provincias' id='prov' onchange='escribirMunicipio();'>");
    document.write("<option value='Blanco' selected>Seleccione provincia</option>");
    for(let i=0;i<provincias.length;i++){
        document.write("<option value='"+[i+1]+"'>"+provincias[i]+"</option>");
    }
    document.write("</select>");
}

function escribirMunicipio(){
    let prov=document.getElementById('prov').value;
    document.write("<select name='minuicipios' id='mun' onchange='escribirTodo();'>");
    for(let p=0;p<todosMunicipios[prov].length;p++){
        document.write("<option value='"+todosMunicipios[prov][p]+"'>"+todosMunicipios[prov][p]+"</option>");
    }
    document.write("</select>");
}


function escribirTodo(){
    let prov=document.getElementById('prov').value;
    prov=provincias[prov-1];
    let mun=document.getElementById('mun').value;
    document.write("Has seleccionado <b>"+mun+"</b> en <b>"+prov+"</b>");
}

window.onload= function (){
    escribirProvincias();
}*/