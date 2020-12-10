// Parámetros Rest
// Todo lo que venga por parámetro juntar en un array
function nombrecompleto(nombre:string, ...losDemasParametros:string[]): string{

  return nombre + " " + losDemasParametros.join(" "); 
}  

let Hulk: string = nombrecompleto("Bruce","Howard");
let Ironman:string = nombrecompleto("Antony","Eward");

console.log(Hulk);
console.log(Ironman);