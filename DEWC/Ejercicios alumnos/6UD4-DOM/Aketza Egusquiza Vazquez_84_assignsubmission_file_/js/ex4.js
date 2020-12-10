function copiar(){
    const izquierda = document.querySelector("#iz");
    const derecha = document.querySelector("#dr");
    derecha.value = izquierda.value;
    izquierda.value="";
}