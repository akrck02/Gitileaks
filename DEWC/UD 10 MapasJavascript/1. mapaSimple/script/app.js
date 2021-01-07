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

    
}