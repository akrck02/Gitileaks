function sumar(a:number,b:number):number{
  return a+b;
}

function saludar(nombre:string):string{
  return "Hola, soy "+nombre;
}

function salvarMundo():void{
    console.log('El mundo está salvado');
}

let miFuncion1:(a:number, b:number) => number;

let miFuncion2: (x:string) => string;

miFuncion1 = sumar;

console.log(miFuncion1(5,5));

miFuncion2 = saludar;
console.log(miFuncion2('Txema'));

let miFuncion3: () => void;

miFuncion3=salvarMundo;

miFuncion3();

miFuncion3 = salvarMundo;