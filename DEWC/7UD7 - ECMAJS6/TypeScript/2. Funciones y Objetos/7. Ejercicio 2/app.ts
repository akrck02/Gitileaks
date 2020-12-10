export {};
// Funciones Básicas
function sumar( a: number, b:number ):number{
  return a + b;
}

console.log(sumar(4,10));

let micontar = function( heroes:string[] ):number{
  return heroes.length;
}

let superHeroes:string[] = ["Flash", "Arrow", "Superman", "Linterna Verde"];

console.log(micontar(superHeroes));

//Parametros por defecto
function millamarBatman( llamar:boolean = true ):void{
  if( llamar ){
    console.log("Batiseñal activada");
  }
}

console.log(millamarBatman());

// Rest?
function miunirheroes( ...personas:string[] ){
  return personas.join(", ");
}

//console.log(miunirheroes(superHeroes[]));

// Tipo funcion
function minoHaceNada( numero:number, texto:string, booleano:boolean, arreglo:any[] ){
}

// Crear el tipo de funcion que acepte la funcion "noHaceNada"
let minoHaceNadaTampoco:( n:number, t: string, b:boolean, a:any[]) => void;

minoHaceNadaTampoco= minoHaceNada;
