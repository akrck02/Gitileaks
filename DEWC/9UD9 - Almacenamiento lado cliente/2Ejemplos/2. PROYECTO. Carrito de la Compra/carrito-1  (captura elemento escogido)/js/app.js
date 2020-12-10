// Variables

const carrito = document.getElementById('carrito');
const cursos = document.getElementById('lista-cursos');

// Listeners

cargarEventListeners();

function cargarEventListeners() {
    // Utilizamos delegation
    // Dispara cuando se pulsa AgregarCarrito

    cursos.addEventListener('click', comprarCurso);

}



// Funciones

// Función que añade el curso al carrito
function comprarCurso(e) {
    e.preventDefault();

    // Delegation para agregar-carrito
    if (e.target.classList.contains('agregar-carrito')) {
        const curso = e.target.parentElement.parentElement;
        // Enviamos el curso seleccionado
        leerDatosCurso(curso);
    }


}


// Lee los datos del curso

function leerDatosCurso(curso) {
    console.log(curso);
}