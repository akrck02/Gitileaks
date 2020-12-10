//VARIABLES INICIALES
let fecha,fechaAnterior;
let rutas;
let imagenes;
let cambios;

//CARGA VARIABLES INICIALES
function load(){
    fechaAnterior = [-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1];
    rutas =
    [
        "images/0.jpg",
        "images/1.jpg",
        "images/2.jpg",
        "images/3.jpg",
        "images/4.jpg",
        "images/5.jpg",
        "images/6.jpg",
        "images/7.jpg",
        "images/8.jpg",
        "images/9.jpg"
    ];

    imagenes = 
    [
        document.querySelector("#c1"),
        document.querySelector("#c2"),
        document.querySelector("#c3"),
        document.querySelector("#c4"),
        document.querySelector("#c5"),
        document.querySelector("#c6"),
        document.querySelector("#c7"),
        document.querySelector("#c8"),
        document.querySelector("#c9"),
        document.querySelector("#c10"),
        document.querySelector("#c11"),
        document.querySelector("#c12"),
        document.querySelector("#c13"),
        document.querySelector("#c14")
    ]
   
    cambios = "";
    let dt = setInterval(actualizarFecha, 1000);
}

//ACTUALIZA LA FECHA
function actualizarFecha(){

   fecha = fechaToArray(new Date());  
   cambios  = comparaFechas(fechaAnterior, fecha); 

   if(cambios.length > 0){
        for(let j = 0; j < cambios.length; j++) 
            cambiarImg(cambios[j],fecha[cambios[j]]);
        fechaAnterior = fecha;
    }   

   return true;
}

//DEVUELVE FECHA EN FORMA DE ARRAY
function fechaToArray(f){

    let array = [];
    let date = preparar(f.getDate(),2);
    array[0] = date[0];
    array[1] = date[1];

    let month = preparar(f.getMonth()+1,2);
    array[2] = month[0];
    array[3] = month[1];

    let anio = preparar(f.getFullYear(),4);
    array[4] = anio[0];
    array[5] = anio[1];
    array[6] = anio[2];
    array[7] = anio[3];

    let horas = preparar(f.getHours(),2);
    array[8] = horas[0];
    array[9] = horas[1];

    let minutos = preparar(f.getMinutes(),2);
    array[10] = minutos[0];
    array[11] = minutos[1];

    let segundos = preparar(f.getSeconds(),2);
    array[12] = segundos[0];
    array[13] = segundos[1];
    
    return array;
}

//PREPARA EL ARRAY DE FECHAS
function preparar(numero,digitos){

    numero += "";
    let num = numero.split("");
    aux = [];

    if(num.length < digitos){
        for(let i = 0; i < (digitos - num.length);i++) aux.push("0");
        for(let i = 0; i < num.length ;i++) aux.push(num[i]);
    }else aux = num;

    return aux;

}

//DEVUELVE ARRAY CON INDICES DE LAS FECHAS CAMBIADAS
function comparaFechas(f,f2){

    let cambios = [];
    for(let i = 0; i < f.length;i++)
        if(f[i] != f2[i]) cambios.push(i);

    return cambios;
}

//CAMBIAR IMAGEN
function cambiarImg(celda, num){
    let img = imagenes[celda];
    console.log("#c"+(celda+1));
    i = document.querySelector("#c"+(celda+1));
    i.style.border = "5px solid blue";
    i.src = rutas[num];
    i.style.border = "none";
}
