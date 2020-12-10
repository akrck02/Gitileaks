let superflash: {nombre: string, edad:number, poderes: string[], getNombre:()=>string }  = {
  nombre: "Barry Allen",
  edad: 24,
  poderes: ["Correr muy rápido", "Viajar en el tiempo"],
  getNombre(){
    return this.nombre;
  }
}

superflash.getNombre();