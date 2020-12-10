var stateObject = {
    "Euskadi": {
        "Araba": ["Vitoria-Gasteiz", "Amurrio", "Laguardia"],
        "Bizkaia": ["Bilbao-Bilbo", "Barakaldo", "Durango"],
        "Gipuzkoa": ["Donosti-San Sebastián", "Arrasate-Mondragón", "Irún"]
    },
    "Iparralde": {
        "Lapurdi": ["Bayona", "Hendaia", "Biarritz"],
        "Behe Nafarroa": ["Saint-Étienne-de-Baïgorry", "Jutsi", "Ostankoa"],
        "Zuberoa": ["Etzarri", "Larruine", "Santa Grazi"]
    },
    "Nafarroa": {
        "Nafarroa": ["Iruña-Pamplona", "Estella-Lizarra", "Tudela"]
    }
}
window.onload = function() {
    var stateSel = document.getElementById("stateSel"),
        countySel = document.getElementById("countySel"),
        citySel = document.getElementById("citySel");
    for (var state in stateObject) {
        stateSel.options[stateSel.options.length] = new Option(state, state);
    }
    stateSel.onchange = function() {
        document.getElementById("mensaje").innerHTML="";
        countySel.length = 1; // remove all options bar first
        citySel.length = 1; // remove all options bar first
        if (this.selectedIndex < 1) {
            countySel.options[0].text = "Por favor, seleccione Provincia"
            citySel.options[0].text = "Por favor, seleccione Ciudad"
            return; // done   
        }
        countySel.options[0].text = "Por favor, seleccione Provincia"
        for (var county in stateObject[this.value]) {
            countySel.options[countySel.options.length] = new Option(county, county);
        }
        if (countySel.options.length == 2) {
            countySel.selectedIndex = 1;
            countySel.onchange();
        }

    }
    stateSel.onchange(); // reset in case page is reloaded

    countySel.onchange = function() {
        document.getElementById("mensaje").innerHTML="";
        citySel.length = 1; // remove all options bar first
        if (this.selectedIndex < 1) {
            citySel.options[0].text = "Por favor, seleccione provincia";
            return; // done   
        }
        citySel.options[0].text = "Por favor, seleccione ciudad";

        var cities = stateObject[stateSel.value][this.value];
        for (var i = 0; i < cities.length; i++) {
            citySel.options[citySel.options.length] = new Option(cities[i], cities[i]);
        }
        if (citySel.options.length == 2) {
            citySel.selectedIndex = 1;
            citySel.onchange();
        }
    }

    citySel.onchange = function() {
        document.getElementById("mensaje").innerHTML = "<p>Ha seleccionado <b>" + stateSel.value + "</b>, provincia de <b>" + countySel.value + "</b>, en la ciudad de <b>" + citySel.value + "</b>";

    }
}