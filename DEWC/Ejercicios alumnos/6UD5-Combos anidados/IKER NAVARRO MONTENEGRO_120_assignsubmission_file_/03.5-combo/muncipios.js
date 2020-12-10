const provincias = {
    "Araba" : ["Vitoria-Gasteiz", "Amurrio", "El Ciego", "La Guardia"],
    "Bizkaia" : ["Bilbao", "Barakaldo", "Durango", "Elorrio", "Muzkiz"],
    "Gipuzkoa" : ["Donostia-San Sebastián", "Arrasate-Mondragón", "Eibar"],
    "Nafarroa" : ["Iruña", "Burlada", "Estella-Lizarra", "Tafalla"],
    "Lapurdi" : ["Baiona", "Bastida", "Hendaya", "Miarritze"],
    "Zuberoa" : ["Maule", "Barkoxe", "Sohüta"],
    "Nafarroa Beherea" : ["Baigorri", "Garazi", "Oztibarre"]
}

window.onload = () => {
    const prov = document.querySelector("#prov");
    const muni = document.querySelector("#muni");
    const resul = document.querySelector("#msg");

    addOption(prov, "Selecciona una provincia");
    for(let p in provincias){
        addOption(prov, p);
    }

    addOption(muni, "Selecciona un municipio");

    prov.addEventListener("change", (evt) => {
        resul.innerHTML = ""
        muni.innerHTML = "";

        const seleccionado = evt.target.value;
        
        addOption(muni, "Selecciona un municipio");
        if(provincias[seleccionado])
        for(let m of provincias[seleccionado]){addOption(muni, m)}
    })

    muni.addEventListener("change", (evt) => {
        const selectedM = evt.target.value;
        const selectedP = prov.options[prov.selectedIndex].value;
        
        resul.innerHTML = (provincias[selectedP].includes(selectedM)) ? `Has seleccionado ${selectedM} en ${selectedP}` : "";
    })
}

function addOption(selectElement, value){
    const option = document.createElement("option");
    option.innerHTML = value;
    selectElement.appendChild(option);
}