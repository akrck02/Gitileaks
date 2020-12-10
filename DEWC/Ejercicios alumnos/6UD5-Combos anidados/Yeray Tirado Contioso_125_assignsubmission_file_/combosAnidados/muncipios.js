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

function cambiar() {

    document.getElementById("mensaje").innerHTML = "";

    var provincia;
    provincia = document.formulario.provincia[document.formulario.provincia.selectedIndex].value;

    if (provincia != 0) {
        mis_municipios = todosMunicipios[provincia]
        num_municipios = mis_municipios.length;
        document.formulario.municipio.length = num_municipios;
        for (i = 0; i < num_municipios; i++) {
            document.formulario.municipio.options[i].value = mis_municipios[i]
            document.formulario.municipio.options[i].text = mis_municipios[i]
        }
    } else {
        document.formulario.municipio.length = 1; 
        document.formulario.municipio.options[0].value = "-";
        document.formulario.municipio.options[0].text = "Seleccione Municipio";

    }
    document.formulario.municipio.options[0].selected = true;

}

function resultado() {
    var provincia = document.formulario.provincia.value - 1;
    var municipio = document.formulario.municipio.value;

    if (municipio != "Seleccione Municipio") {
        document.getElementById("mensaje").innerHTML = "<p>Ha seleccionado <b>" + municipio + "</b> en <b>" + provincias[provincia] + "</b>";
    } else {
        document.getElementById("mensaje").innerHTML = "";
    }
}