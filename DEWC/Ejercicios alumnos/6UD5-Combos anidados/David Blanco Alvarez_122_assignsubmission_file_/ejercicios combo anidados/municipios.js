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

window.onload= function(){
    provincias.forEach( provincia =>{
       var nuevoElemento= document.createElement("option");
        nuevoElemento.innerHTML=provincia;
        nuevoElemento.setAttribute("value", provincia);
        document.getElementById("provincias").appendChild(nuevoElemento);
    })
}

function cargarMunicipios(){
    //acceder al elemento seleccionado y cargar el segundo selects
    var munis = document.getElementById("municipio");
    munis.removeAll
    while (munis.hasChildNodes()){
        munis.removeChild(munis.firstChild);
    }
    var selec =document.getElementById("provincias");
    var seleccionado =selec.options[selec.selectedIndex].value;
    var ind =  provincias.indexOf(seleccionado);
    console.log(ind);
    var arrayMun = todosMunicipios[ind+1];
    console.log(arrayMun);
    arrayMun.forEach(i=>{
        var nuevoElemento= document.createElement("option");
        nuevoElemento.innerHTML=i;
        nuevoElemento.setAttribute("value", i);
        document.getElementById("municipio").appendChild(nuevoElemento);
    })

}

function mostrar(){
    var prov= document.getElementById("provincias");
    var nomProv = prov.options[prov.selectedIndex].value;
    var m= document.getElementById("municipio");
    var nomMun = m.options[m.selectedIndex].value;
    var resultado= "Ha seleccionado " + nomMun + " en " + nomProv;
    var res =document.getElementById("resultado");
    res.innerHTML=resultado;
}