// Evitar el error de compilacion de las variables glovales
export {};

// Definimos el tipo personalizado
// Es como una clase

type Heroe = {
  nombre: string, 
  edad:number, 
};

let loquesea: string | number | Heroe = "Txema";

loquesea = {
  nombre: "Flash",
  edad: 56
};

