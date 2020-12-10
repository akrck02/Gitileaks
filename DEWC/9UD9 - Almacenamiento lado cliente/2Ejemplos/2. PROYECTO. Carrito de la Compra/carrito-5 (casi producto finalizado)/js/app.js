// Variables

const carrito = document.getElementById('carrito');
const cursos = document.getElementById('lista-cursos');
const listaCursos = document.querySelector('#lista-carrito tbody');
// Listeners

const vaciarCarritoBtn = document.getElementById('vaciar-carrito');

cargarEventListeners();

function cargarEventListeners() {
    // Utilizamos delegation
    // Dispara cuando se pulsa AgregarCarrito

    cursos.addEventListener('click', comprarCurso);

    // Cuando se elimina un curso del carrito

    carrito.addEventListener('click', eliminarCurso);

    // Al vaciar el carrito

    vaciarCarritoBtn.addEventListener('click', vaciarCarrito);


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

    // Creo un objeto para almacenar los  datos del curso

    const infoCurso = {
        imagen: curso.querySelector('img').src,
        titulo: curso.querySelector('h4').textContent,
        precio: curso.querySelector('.precio span').textContent,
        id: curso.querySelector('a').getAttribute('data-id')
    }

    console.log(infoCurso);
    insertarCarrito(infoCurso);
}

// Función InsertarCarrito
// Mustra el curso seleccionado en el Carrito

function insertarCarrito(curso) {
    const row = document.createElement('tr');
    row.innerHTML = `
        <td>
            <img src="${curso.imagen}" width=100>
        </td>
        <td>${curso.titulo}</td>    
        <td>${curso.precio}</td>
        <td>
            <a href="#" class="borrar-curso" data-id="${curso.id}">X</a>
        </td>         
    `;
    listaCursos.appendChild(row);
    guardarCursoLocalStorage(curso);
}

// Elimina el curso del carrito en el DOM
function eliminarCurso(e) {
    e.preventDefault();

    let curso;

    if (e.target.classList.contains('borrar-curso')) {
        // console.log(e.target.parentElement.parentElement);

        e.target.parentElement.parentElement.remove();
    }

}

// Elimina los cursos del carrito en el DOM

function vaciarCarrito() {
    // forma lenta

    //listaCursos.innerHTML = '';

    // forma rápida (recomendada)

    while (listaCursos.firstChild) {
        listaCursos.removeChild(listaCursos.firstChild);
    }
    return false;
}

// Almacena cursos en el LocalStorage

function guardarCursoLocalStorage(curso) {
    let cursos;

    // Llena el arreglo desde LocalStorage
    cursos = obtenerCursosLocalStorage();

    // El curso seleccinado se agrega al arreglo
    cursos.push(curso);
    localStorage.setItem('cursos', JSON.stringify(cursos));
}

// Comprueba que hay elementos en LocalStorage
function obtenerCursosLocalStorage() {
    let cursosLS;

    if (localStorage.getItem('cursos') === null) {
        cursosLS = [];
    } else {
        cursosLS = JSON.parse(localStorage.getItem('cursos'));
    }

    return cursosLS;
}