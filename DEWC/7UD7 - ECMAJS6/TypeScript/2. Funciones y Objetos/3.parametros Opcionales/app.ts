// Parámetros opcionales ?
function minombreCompleto(nombre:string, apellido?:string): string{

  if(apellido){
    return nombre+' '+apellido;
  }else{
    return nombre;
  }

  
}

let minombre = minombreCompleto("Barry");

console.log(minombre);