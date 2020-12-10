// Tipos
var batman:string = "Bruce";
var superman: string = "Clark";

var existe: boolean = false;

// Tuplas
var parejaHeroes: [string,string] = [batman,superman];
var villano: [string, number,boolean] = ["Lex Lutor",5,true];

// Arreglos
var aliados:string[] = ["Mujer Maravilla","Acuaman","San", "Flash"];

enum Fuerza{
  acuaman=0,
  batman=1,
  flash=5,
  superman=100
};

//Enumeraciones
let fuerzaFlash = Fuerza.flash;
let fuerzaSuperman = Fuerza.superman;
let fuerzaBatman = Fuerza.batman;
let fuerzaAcuaman = Fuerza.acuaman;

// Retorno de funciones
function activar_batiseñal():string{
  return "activada";
}

function pedir_ayuda():void{
  console.log("Auxilio!!!");
}

// Aserciones de Tipo
var poder: string = "100";
var largoDelPoder: number = poder.length;
console.log( "Largo:"+largoDelPoder );

var poder2: number = 100;
var largoDelPoder2: number = poder2.toString().length;
console.log( largoDelPoder2 );