// Async Await

async function leerTodos() {

    // Esperar la respuesta

    const respuesta = await fetch('http://jsonplaceholder.typicode.com/todos');

    // Proceder cuando la respuesta está disponible

    const datos = await respuesta.json();

    return datos;

}

leerTodos()
    .then(usuarios => console.log(usuarios));