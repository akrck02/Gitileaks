const url = new URL("http://localhost/front/ejercicio7.php");

loadProvincias();

provincias.addEventListener("change", () => {
    if(provincias.value != 0){
        loadMunicipios(provincias.value);
        municipios.style.display = "initial";
    }
    else{
        municipios.innerHTML = "";
        municipios.style.display = "none";
    }
})


function loadProvincias(){
    const data = new FormData();
    data.append("tipo", "provincia");

    fetchJsonFrom(url, data)
    .then(json => {
        html = "";
        Object.entries(json).forEach((provincia)=>{
            html += `<option value='${provincia[0]}'>${provincia[1]}</option>`;
        })
        provincias.innerHTML += html;
    })
    .catch(console.log);
}

function loadMunicipios(idProvincia){
    const data = new FormData();
    data.append("tipo", "municipio");
    data.append("codigo_provincia", idProvincia);

    fetchJsonFrom(url, data)
    .then(json => {
        html = "";
        Object.entries(json).forEach((municipio)=>{
            html += `<option value='${municipio[0]}'>${municipio[1]}</option>`;
        })
        municipios.innerHTML += html;
    })
    .catch(console.log);

}

async function fetchJsonFrom(url, data){
    //data = JSON.stringify("tipo": "provincia")??
    const options = {
        method : "POST",
        body : data
    }

    return await fetch(url, options)
    .then(handleErrors)
    .then(response => response.arrayBuffer())
    .then(buffer => {
        let decoder = new TextDecoder("ISO-8859-1");
        return decoder.decode(buffer)
    })
    .then(res => JSON.parse(res))
}

function handleErrors(response){
    if (!response.ok) throw new Error(response.error)
    return response;
}