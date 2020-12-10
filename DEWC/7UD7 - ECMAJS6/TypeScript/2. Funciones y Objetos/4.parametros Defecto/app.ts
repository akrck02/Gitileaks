// Parámetros por defecto

function minombrecompleto(nombre:string, apellido:string, capitalizado: boolean=true): string{

  if (capitalizado){
    return capitalizar(nombre)+' '+capitalizar(apellido); 
  }else{
    return nombre+' '+apellido;
  }
}  

function capitalizar(palabra:string):string{
  return palabra.charAt(0).toUpperCase() + palabra.substr(1).toLowerCase();
}

let izena = minombrecompleto("barry","white");

console.log(izena);