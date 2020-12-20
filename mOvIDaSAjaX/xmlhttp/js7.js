const request = new XMLHttpRequest();
const url = "http://localhost/FRONT/Ejercicio7.php";

request.onreadystatechange = provinciasHandler;
request.open("POST", url);

request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
request.send("tipo=provincia");

function provinciasHandler(){
    if(request.readyState == 4 && request.status == 200) {
        json = JSON.parse(request.responseText);
        html = "";
        Object.entries(json).forEach((codeName) => {
            html += `<option value='${codeName[0]}'>${codeName[1]}</option>`;
        })
        provincias.innerHTML += html;
        request.onreadystatechange = municipiosHandler;
    }
}


provincias.addEventListener("change", () => {
    if(provincias.value != 0){
        request.open("POST", url);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send("tipo=municipio&codigo_provincia="+provincias.value);
    }else{
        municipios.innerHTML = "";
        municipios.style.display = "none";
    }
})


function municipiosHandler(){
    if(request.readyState == 4 && request.status == 200) {
        
        json = JSON.parse(request.responseText);
        html = "<option value='0'>Elije una opción</option>";
        Object.entries(json).forEach((codeName) => {
            html += `<option value='${codeName[0]}'>${codeName[1]}</option>`;
        })
        municipios.innerHTML = html;
        municipios.style.display = "initial";
    }
}