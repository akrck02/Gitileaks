// This example displays a marker at the center of Australia.
// When the user clicks the marker, an info window opens.

// This example displays a marker at the center of Australia.
// When the user clicks the marker, an info window opens.

function initMap() {

    console.log("Cargando mapa....");

    var virgenBlanca = {
        lat: 42.846667,
        lng: -2.673056
    };
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 13,
        center: virgenBlanca
    });

    var contentString = '<div id="content">' +
        '<div id="siteNotice">' +
        '</div>' +
        '<h1 id="firstHeading" class="firstHeading">Gasteiz</h1>' +
        '<div id="bodyContent">' +
        '<p><b>Plaza de la Virgen Blanca</b>,' +
        '<p>Vitoria-Gasteiz es la capital de la comunidad autónoma del País Vasco, situada en el norte de España. En el barrio medieval se erige la catedral gótica de Santa María, con esculturas en la fachada y unas columnas elevadas que llegan a formar torres. La plaza de la Virgen Blanca, del siglo XVII, alberga un monumento a la Batalla de Vitoria (1813). La iglesia de San Miguel cuenta con un gran retablo barroco y una estatua de la Virgen Blanca, patrona de la ciudad.<p>' +
        '<p>Más información: Gasteiz, <a href="https://es.wikipedia.org/wiki/Vitoria">' +
        'https://es.wikipedia.org/wiki/Vitoria</a> '
    '</div>' +
    '</div>';

    var infowindow = new google.maps.InfoWindow({
        content: contentString
    });

    console.log("Colocando pin....");
    var marker = new google.maps.Marker({
        position: virgenBlanca,
        map: map,
        title: 'Virgen Blanca'
    });
    marker.addListener('click', function () {
        console.log("Abriendo infowindow....");
        infowindow.open(map, marker);
    });
}