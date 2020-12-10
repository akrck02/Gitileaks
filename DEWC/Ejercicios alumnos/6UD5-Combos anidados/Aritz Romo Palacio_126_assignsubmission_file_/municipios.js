var provincias = new Array("Araba", "Bizkaia", "Gipuzkoa", "Nafarroa", "Lapurdi", "Zuberoa", "Nafarroa Beherea")

var municipios_1 = new Array("Seleccione Municipio", "Vitoria-Gasteiz", "Amurrio", "El Ciego", "La Guardia");
var municipios_2 = new Array("Seleccione Municipio", "Bilbao", "Barakaldo", "Durango", "Elorrio", "Muzkiz");
var municipios_3 = new Array("Seleccione Municipio", "Donostia-San Sebastián", "Arrasate-Mondragón", "Eibar");
var municipios_4 = new Array("Seleccione Municipio", "Iruña", "Burlada", "Estella-Lizarra", "Tafalla");
var municipios_5 = new Array("Seleccione Municipio", "Baiona", "Bastida", "Hendaya", "Miarritze");
var municipios_6 = new Array("Seleccione Municipio", "Maule", "Barkoxe", "Sohüta");
var municipios_7 = new Array("Seleccione Municipio", "Baigorri", "Garazi", "Oztibarre");

var todosMunicipios = [
    municipios_1,
    municipios_2,
    municipios_3,
    municipios_4,
    municipios_5,
    municipios_6,
    municipios_7,
];

function insertarOption(padre, valor, texto){
    const option = document.createElement("option");
    option.setAttribute("value",valor);
    option.innerHTML = texto;
    padre.appendChild(option);
}

function mostrarMunicipios(iProv){
    const mun = document.querySelector("#mun");
    mun.innerHTML = "";

    if(iProv==-1){
        insertarOption(mun, "Seleccione Municipio", "Seleccione Municipio");
    }
    else{
        const arrayMun = todosMunicipios[iProv];
        arrayMun.forEach(municipio => {
        insertarOption(mun, municipio, municipio);
    }); 
    }

    mun.addEventListener("change", (evento) =>{
        const munSelec = evento.target.value;
        const p = document.querySelector("#abajo");

        if(munSelec!="Seleccione Municipio"){
            p.innerHTML = "Has seleccionado <strong>"+munSelec+"</strong> en <strong>"+provincias[iProv]+"</strong>";
        }
        else{
            p.innerHTML = "";
        }
    })
    
}

window.onload = () => {
    const prov = document.querySelector("#prov");
    

    prov.addEventListener("change", (evento)=>{
        const indice = provincias.indexOf(evento.target.value);
        const p = document.querySelector("#abajo");
        p.innerHTML = "";
        mostrarMunicipios(indice);
    })

    insertarOption(prov, "Seleccione Provincia", "Seleccione Provincia");
    provincias.forEach(provincia => {
        insertarOption(prov, provincia, provincia);
    });

    mostrarMunicipios(-1);
}