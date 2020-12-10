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

window.onload = function(){

    provincias.forEach(provincia => {
        var selectProv = document.getElementById("provincias");
        var option = document.createElement('option');
        option.innerHTML=provincia;
        option.setAttribute("name",provincia);
        selectProv.appendChild(option);           
    }); 


}

function cargarmunicipio(){
    var datos = document.getElementById("datos").innerHTML = "";
    
    var provinciaSel = document.getElementById("provincias");
    var minicipios = todosMunicipios[provinciaSel.selectedIndex];
    var selectMun = document.getElementById("municipios");
    
    while(selectMun.hasChildNodes()){
        selectMun.removeChild(selectMun.firstChild);	
    }

    if(provinciaSel.selectedIndex!=0){
        minicipios.forEach(municipio => { 
            var option = document.createElement('option');
            option.innerHTML=municipio;
            option.setAttribute("name",municipio);
            selectMun.appendChild(option);           
        }); 
    }else{
        var option = document.createElement('option');
        option.innerHTML="Seleccione Municipio";
        option.setAttribute("name","Seleccione Municipio");
        selectMun.appendChild(option); 
    }
    
}

function mostrarDatos(){
    var municipioSel = document.getElementById("municipios");
    var municipioIndex = municipioSel.selectedIndex;
    if(municipioIndex!=0){
        var provincia = document.getElementById("provincias").value;
        var municipio = municipioSel.value;
        
        var datos = document.getElementById("datos");
        datos.innerHTML = `Ha seleccionado <strong>${municipio}</strong> en <strong>${provincia}</strong>`;
    }else{
        var datos = document.getElementById("datos").innerHTML = "";
    }
}

