
/*INDICE DEL AXIOMA NUMERO[SIGNO]NUMERO
  NUMERACIÓN:         0            1 */
let i;
let signo;
let resultado; 
let clear;
let error;

//CARGA LOS ELEMENTOS Y VARIABLES INICIALES
function load(){
    resultado = document.querySelector("#resultado");
    clear = document.querySelector("#clear");
    i = 0;
    signo = "";
    error = false;
}

//CAPTURA EL EVENTO Y COMPRUEBA
function clickEvent(ch){

    const number = (Number.isInteger(ch) && ch >= 0 && ch <= 9);
    if(!error){
        switch (i) {
            case 0:
                if(number){paint(ch,false);}
                else{ 
                    if(ch != "="){
                        paint(ch,false);
                        signo = ch;
                        i++;
                    }
                }
                break;
            case 1: 
                if(number){paint(ch,false);} 
                else if( ch == "=") {
                    const operation = resultado.value.split(signo);
                    const res = calc(+operation[0],signo,+operation[1]);
    
                    if(res == "MATH ERROR" || res == "SYNTAX ERROR"){
                        clear.classList.add("movimiento");   
                        resultado.classList.add("error");  
                        error = true;
                    } 
                    paint(res,true);
                }
                break;
            default:
                break;
        }
    }

    debuger(); 
}

//RESETEA EL RESULTADO Y LOS VALORES
function reset(){
    i = 0;
    signo = "";
    clear.classList.remove("movimiento"); 
    resultado.classList.remove("error");  
    error = false;
    paint("",true);
}

//DEFINE EN QUE CAMPO DE LA FUNCION ESTÁ Y LOS VALORES
function set(index){
    i = index;
    signo = "";
}
 
//PINTA EN EL CUADRO DE TEXTO
function paint(thing,overwrite){
    if(overwrite) resultado.value = thing;
    else resultado.value += thing;
}

//CALCULA EL RESULTADO
function calc(n,sign,n2){
    let res = "SYNTAX ERROR";
    switch (sign) {
        case "+":
            res = suma(n,n2);
            break;
        case "-":
            res = resta(n,n2);
            break;   
        case "*":
            res = multiplica(n,n2);
            break;
        case "/": 
            res = divide(n,n2);
            if(!res) res = "MATH ERROR";
            break;    
        default:
            break;
    }
    set(0);
    if(Number.isNaN(res)) res = "SYNTAX ERROR";
    return res;
}

//SUMA
function suma(n,n2){return n + n2;}
//RESTA
function resta(n,n2){return n - n2;}
//MULTIPLICACIÓN
function multiplica(n,n2){return n * n2;}
//DIVISIÓN
function divide(n,n2){
    if(n2 == 0) return false;
    return n / n2;
}

//DEBUGER
function debuger(){
    console.log("-----------------VARIABLE LOG-----------------");
    console.log("Program index: " + i);
    console.log("Sign: " + signo);
}