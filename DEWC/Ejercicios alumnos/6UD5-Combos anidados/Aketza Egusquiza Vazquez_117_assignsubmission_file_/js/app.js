
//CAMBIA LA PROVINCIA
function cambiarProvincia(){
    document.querySelector("#mensaje").innerHTML = "";
    const provincia = document.lugares.provincia[document.lugares.provincia.selectedIndex].value;
    
    if(provincia != 0){ 
        const municipios = ddbb[provincia];
        crearMunicipios(municipios);
    }else vaciarMunicipios();
}

//VACIA MUNICIPIOS 
function vaciarMunicipios(){
    document.lugares.municipio.innerHTML = '';
    
    const lugar = document.createElement("option");
    lugar.value = "-";
    lugar.innerHTML = "Seleccione Municipio";
    document.lugares.municipio.appendChild(lugar);
}

//REPUEBLA LOS MUNICIPIOS
function crearMunicipios(municipios){

    municipios.forEach(municipio => {
        const lugar = document.createElement("option");
        lugar.value = municipio;
        lugar.innerHTML = municipio;
        document.lugares.municipio.appendChild(lugar);
    });
}

//MUESTRA DATOS
function muestraDatos() {
    const provincia = document.lugares.provincia.value;
    const municipio = document.lugares.municipio.value;

    if (municipio != "-")
        document.getElementById("mensaje").innerHTML = "<p>Ha seleccionado <b>" + municipio + "</b> en <b>" + provincia + "</b>";
    else 
        document.getElementById("mensaje").innerHTML = "";   
}
