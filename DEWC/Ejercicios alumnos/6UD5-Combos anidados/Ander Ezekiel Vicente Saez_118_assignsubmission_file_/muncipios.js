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

    function cargaProvincias(){
        
        var provinciaSeleccionada = document.formulario.provincias[document.formulario.provincias.selectedIndex].value;
        
        if(provinciaSeleccionada!=0){

            document.getElementById("mensajeFinal").innerHTML = " ";

            var municipios = todosMunicipios[provinciaSeleccionada];
            var numTotalMunicipios = municipios.length;

            document.formulario.municipios.length = numTotalMunicipios;
            for(var i=0; i<numTotalMunicipios; i++){
                document.formulario.municipios.options[i].value = municipios[i];
                document.formulario.municipios.options[i].text = municipios[i];
            }
        }
        else{
            document.formulario.municipios.length=1;

            document.formulario.municipios.options[0].value="-";
            document.formulario.municipios.options[0].text="Seleccione Municipio";
        }

        document.formulario.municipios.options[0].selected=true;
    }



    function mostrarDatos(){

        var provincia = document.formulario.provincias.value-1;
        var municipio = document.formulario.municipios.value;

        if(municipio!="-" && municipio!="Seleccione Municipio"){
            document.getElementById("mensajeFinal").innerHTML = "<p>Ha seleccionado <b>" + municipio + "</b> en <b>" + provincias[provincia] + "</p>";
        }
        else{
            document.getElementById("mensajeFinal").innerHTML = "";
        }



    }