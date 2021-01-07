// Comparar con el 1 porque no salen los hospitales

const urlBase =
    "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/top_euskadi/opendata/top-euskadi.json?callback=jsonCallback"
    //"http://opendata.euskadi.eus/contenidos/ds_localizaciones/hospitales_en_euskadi/opendata/hospitales.json?callback=jsonCallback";
document.addEventListener("DOMContentLoaded", () => crearScript(urlBase));
let script;
let mapa;
let tipo = "";
let markers = [];

let emoticon; // modificado 20/04
let legend = null;
legend = document.getElementById("legend");
let inicio = false;

function jsonCallback(data) {
    var valores = getGET();

    //Modificado 20/04 --------------------------------

    if (emoticon === undefined) {
        //recogemos los valores que nos envia la URL en variables para trabajar
        //con ellas
        tipo = "capitales";
    } else {
        // no se ha recibido ningun parametro por GET
        tipo = emoticon;
    }

    // console.log("Este tipo es:" + tipo);

    fichero = cargarDatos(tipo);

    initMap();

    if (tipo === "capitales") {
        let newDatos = data;

        data = newDatos.filter(dato => {
            let filtro =
                dato.documentName === "San Sebastián" ||
                dato.documentName === "Bilbao" ||
                dato.documentName === "Vitoria-Gasteiz";
            return filtro;
        });
    }

    colocarPines(data, tipo);
}

function crearScript(url) {
    //console.log("La url es:" + url);
    script = document.createElement("script");
    script.src = url;
    document.getElementsByTagName("head")[0].appendChild(script);
}

function getGET() {
    // capturamos la url
    var loc = document.location.href;

    // si existe el interrogante
    if (loc.indexOf("?") > 0) {
        // cogemos la parte de la url que hay despues del interrogante
        var getString = loc.split("?")[1];

        // obtenemos un array con cada clave=valor
        var GET = getString.split("&");
        var get = {};

        // recorremos todo el array de valores
        for (var i = 0, l = GET.length; i < l; i++) {
            var tmp = GET[i].split("=");
            get[tmp[0]] = unescape(decodeURI(tmp[1]));
        }
        return get;
    }
}

function initMap() {
    const LatLong = {
        lat: 43.2603479,
        lng: -2.933411
    };
    //console.log(latLng);
    this.mapa = new google.maps.Map(document.getElementById("mapa"), {
        center: LatLong,
        zoom: 9
    });

    return;
}

function colocarPines(data, tipo) {
    let lat;
    let lng;
    let nombre;
    let provincia;
    let municipio;
    let direccion;
    let paginaWeb;
    let estrellas;
    let infoWindowActivo;

    /********************** */

    var iconBase = "https://maps.google.com/mapfiles/kml/shapes/";
    var icons = {
        capitales: {
            name: "capitales",
            icon: iconBase + "capital_big_highlight.png"
        },
        hoteles: {
            name: "hoteles",
            icon: iconBase + "lodging_maps.png"
        },
        museos: {
            name: "museos",
            icon: iconBase + "museum_maps.png"
        },
        aeropuertos: {
            name: "aeropuertos",
            icon: iconBase + "airports_maps.png"
        },
        restaurantes: {
            name: "restaurantes",
            icon: iconBase + "dining_maps.png"
        },
        hospitales: {
            name: "hospitales",
            icon: iconBase + "hospitals_maps.png"
        },
        topturismo: {
            name: "topturismo",
            icon: iconBase + "camera_maps.png"
        }
    };
    let nombreSitio = [];
    let sitioSeleccionado = [];
    let indice;
    let marker;

    let tipoEstablecimiento;

    if (!inicio) {
        for (var key in icons) {
            var type = icons[key];
            var name = type.name;
            var icon = type.icon;
            var div = document.createElement("div");
            div.setAttribute("id", "leyenda");
            var enlace =
                '<a href="' +
                "index.html?tipo=" +
                name +
                '"><img src="' +
                icon +
                '">' +
                name +
                "</a>";
            div.innerHTML = enlace;

            legend.appendChild(div);
        }

        inicio = true;
    }

    this.mapa.controls[google.maps.ControlPosition.RIGHT_BOTTOM].push(legend);

    /********************** */
    //console.log("El tipo es:" + tipo);
    //console.log("losDatos", data, tipo);

    data.forEach(element => {
        tipoEstablecimiento = tipo;
        estrellas = element.category;
        lat = element.latwgs84;
        lng = element.lonwgs84;
        nombre = element.documentName;
        provincia = element.territory;
        municipio = element.municipality;
        direccion = element.address;
        telefono = element.phone;
        michelin = element.michelinStar;
        descripcion = element.turismDescription;
        // console.log(element);
        if (tipo === "hospitales") {
            paginaWeb = element.webpage;
        } else {
            paginaWeb = element.web;
        }
        //console.log("Nombre es:" + nombre);
        //console.log("Elment0", element);
        if (lat != null || lng != null) {
            lat = lat.replace(",", ".");
            lng = lng.replace(",", ".");
        }

        const coordenadas = {
            lat: Number(lat),
            lng: Number(lng),
            tipo: tipoEstablecimiento
        };

        //console.log(coordenadas, nombre);

        /*************** 

                        Rellenar todos los datos del hospital

                        ************** */

        let marker = new google.maps.Marker({
            position: coordenadas,
            map: this.mapa,
            icon: icons[coordenadas.tipo].icon,
            tipo: tipoEstablecimiento
        });
        markers.push(marker);

        let infoWindow = crearInfoWindow(
            nombre,
            provincia,
            municipio,
            direccion,
            telefono,
            paginaWeb,
            tipoEstablecimiento,
            descripcion,
            estrellas,
            michelin
        );

        marker.addListener("click", () => {
            if (infoWindowActivo) {
                infoWindowActivo.close();
            }

            infoWindow.open(this.mapa, marker);
            infoWindowActivo = infoWindow;
        });
    });

    return;
}

function crearInfoWindow(
    nombre,
    provincia,
    municipio,
    direccion,
    telefono,
    paginaWeb,
    tipo,
    descripcion,
    estrellas,
    michelin
) {
    //console.log("Tipo:" + tipo);
    //console.log("Pagina web:" + paginaWeb);
    if (tipo === "hospitales") {
        if (paginaWeb == undefined) {
            paginaWeb = "http://www.osakidetza.net";
        } else if (paginaWeb == "/r85-ghodon00/es") {
            paginaWeb = "http://www.osakidetza.net" + paginaWeb;
        } else if (paginaWeb == "/r85-ghhpsq00/es/") {
            paginaWeb = "http://www.osakidetza.net";
        } else if (paginaWeb == "85-ghrsmb00/es/") {
            paginaWeb = "http://www.osakidetza.net";
        }
    } else {
        if (paginaWeb === undefined) {
            {
                if (tipo === "restaurantes") {
                    paginaWeb =
                        "https://www.restopolitan.es/restaurante/euskadi-49207.html";
                } else if (tipo === "museo") {
                    paginaWeb =
                        "http://www.euskadi.eus/directorio-de-museos/web01-a2muszen/es/";
                }
            }
        } else {
            if (paginaWeb.substr(1, 3) === 'www') {
                paginaWeb = "http://" + paginaWeb;
                console.log(paginaWeb);
            }
        }
    }
    let marcaStar = `<img src='http://maps.google.com/mapfiles/kml/pal4/icon47.png'>`;
    let marcaMich = `<img src='http://maps.google.com/mapfiles/kml/pal4/icon47.png'>`;

    // <b>Estrellas:</b> ${estrellas}
    //console.log("URL modificada:" + paginaWeb);
    let markerInfo = `
    <h1>${nombre}</h1>`;

    stars = (Number)(estrellas);
    for (i = 1; i < stars; i++) {
        marcaStar += `<img src='http://maps.google.com/mapfiles/kml/pal4/icon47.png'>`;
    }

    let michelines = (Number)(michelin);

    for (i = 1; i < michelines; i++) {
        marcaMich += `<img src='http://maps.google.com/mapfiles/kml/pal4/icon47.png'>`;
    }
    if ((tipo === 'hoteles') && stars > 1) {
        markerInfo += `${marcaStar}`;
    } else if ((tipo === 'restaurantes') && (michelines > 0)) {
        markerInfo += `${marcaMich}`;
    }

    markerInfo += `
    <br><b>Dirección</b>: ${direccion} 
    <br><b>Teléfono</b>: ${telefono}
    <br><b>Municipio</b>: ${municipio}
    <br><b>Provincia</b>: ${provincia}`;

    if ((descripcion != "") && (descripcion != undefined)) {
        markerInfo += `
        <br><b>Descripcion</b>: ${descripcion}</br>
        `;
    }

    markerInfo += `
    <br><b>Más información</b>: <a href='${paginaWeb}'< target='_blank'/a>Sitio Web</p> 
    `;

    infoWindow = new google.maps.InfoWindow({
        content: markerInfo
    });

    return infoWindow;
}

function cargarDatos(tipo) {
    let fichero;
    switch (tipo) {
        case "restaurantes":
            //console.log("Restaurante");
            fichero =
                "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/restaurantes_sidrerias_bodegas/opendata/restaurantes.json?callback=jsonCallback";
            break;

        case "hoteles":
            //console.log("Hotel");
            fichero =
                "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/hoteles_de_euskadi/opendata/alojamientos.json?callback=jsonCallback";
            break;

        case "hospitales":
            //console.log("Hospital");
            fichero =
                "http://opendata.euskadi.eus/contenidos/ds_localizaciones/centros_salud_en_euskadi/opendata/centros-salud.json?callback=jsonCallback";
            break;

        case "aeropuertos":
            //console.log("Aeropuerto");
            fichero =
                "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/aeropuertos_euskadi/opendata/transporte.json?callback=jsonCallback";
            break;

        case "museos":
            //console.log("museos");
            fichero =
                "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/museos_centros_interpretacion/opendata/museos.json?callback=jsonCallback";
            break;

        case "topturismo":
            //console.log("turismo");
            fichero =
                "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/top_euskadi/opendata/top-euskadi.json";
            break;

        case "capitales":
            //console.log("capital");
            fichero =
                "http://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/top_euskadi/opendata/top-euskadi.json";
            break;
    }
    //if (fichero === "capital") {
    // Colocamos pin de capital
    //} else {

    return fichero;
    //}
}

function abrirFichero(fichero) {
    // console.log(fichero);
    var script = document.createElement("script");
    script.src = `${fichero}`;
    document.getElementsByTagName("head")[0].appendChild(script);
}

function elemento(e) {
    if (e.srcElement) tag = e.srcElement.text;
    else if (e.target) tag = e.target.text;

    // console.log("Elemento:" + e.srcElement.text);
    var target = e.target.text;
    //  if (target === "capital") {
    //  console.log("Poniendo capital.....");

    //  cargarFichero("datoscapitales.json");

    //leerDatos('datoscapitales.json')
    // colocarPines("datoscapitales.json");
    // ponerCapital(42.8587995, -2.6824781);
    // ponerCapital(43.32074, -1.984421);
    // } else {
    let fichero = cargarDatos(tag);
    emoticon = e.target.text; //Modificado 20/04.

    abrirFichero(fichero);
    // }
}

/* Añadidas las funciones elemento, que determina que se ha seleccionado y ejecuta abrirFichero. Esta funcion compone el script con el fichero
correspondiente que ejecuta la funcion jsonCallback.  */ //