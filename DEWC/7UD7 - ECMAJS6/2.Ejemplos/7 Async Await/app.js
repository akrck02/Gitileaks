// Async Await

async function obtenerClientes() {

    // Toda función asíncrona va a requerir crear un promise
    // Crear un promise

    const clientes = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(`Clientes descargados...`);
        }, 2000);
    });

    // Error o no

    const error = false;

    if (!error) {
        const respuesta = await clientes;
        // El await va a retener esta parte hasta la ejecución del promise
        return respuesta;
    } else {
        await Promise.reject(`Error detectado....`);
    }

}

obtenerClientes()
    .then(res => console.log(res))
    .catch(error => console.log(error));