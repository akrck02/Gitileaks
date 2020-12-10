// Variables
const ListaTweets = document.getElementById('lista-tweets');


// Event Listener

evenListener();

function evenListener() {
    // Cuando se envia el formulario

    document.getElementById('formulario').addEventListener('submit', agregarTweet);

    // Borrar tweets (utilizamos delegation)

    ListaTweets.addEventListener('click', borrarTweet);

    // Contenido cargado

    document.addEventListener('DOMContentLoaded', localStorageListo);



}

// Funciones

function agregarTweet(e) {
    e.preventDefault();
    // leer el valode del TextArea

    const tweet = document.getElementById('tweet').value;

    // Crear botón de eliminar

    const botonBorrar = document.createElement('a');
    botonBorrar.classList = 'borrar-tweet';
    botonBorrar.innerText = 'X';

    // Crear elemento y añadir el contenido a la lista

    const li = document.createElement('li');
    li.innerText = tweet;

    // Añade el botón borrar al tweet
    li.appendChild(botonBorrar);

    //Añade el tweet a la lista
    ListaTweets.appendChild(li);

    // Añadir a Local Storage

    agregarTweetLocalStorage(tweet);

}

// Elimina el tweet del DOM
function borrarTweet(e) {
    e.preventDefault();

    if (e.target.className === 'borrar-tweet') {
        e.target.parentElement.remove();

        borrarTweetLocalStorage(e.target.parentElement.innerText);

    }
}

// Agrega el tweet al local Storage

function agregarTweetLocalStorage(tweet) {

    let tweets;
    tweets = obtenerTweetsLocalStorage();

    // Añadir el nuevo tweet

    tweets.push(tweet);

    // Convertir de string a arreglo para localStorage

    localStorage.setItem('tweets', JSON.stringify(tweets));


}

// Comprobar que haya elementos en LocalStorage, retorna un arreglo
function obtenerTweetsLocalStorage() {
    let tweets;

    if (localStorage.getItem('tweets') === null) {
        tweets = [];
    } else {
        tweets = JSON.parse(localStorage.getItem('tweets'));
    }
    return tweets;

}


// Mostrar datos de la LocalStorage en la lista
// Aunque borre 
function localStorageListo() {

    let tweets;

    tweets = obtenerTweetsLocalStorage();

    //console.log(tweets);

    tweets.forEach(function(tweet) {
        // Crear boton de eliminar

        const botonBorrar = document.createElement('a');
        botonBorrar.classList = 'borrar-tweet';
        botonBorrar.innerText = 'X';

        // Crear elemento y añadir el contenido a la lista

        const li = document.createElement('li');
        li.innerText = tweet;

        // Añade el botón borrar al tweet
        li.appendChild(botonBorrar);

        //Añade el tweet a la lista
        ListaTweets.appendChild(li);

    });

}

// Eliminar tweet del LocalStorage
function borrarTweetLocalStorage(tweet) {

    let tweets, tweetBorrar;

    // Eliminamos la X de la cadena
    tweetBorrar = tweet.substring(0, tweet.length - 1);

    // Obtenemos el array de los tweets del local Storage
    tweets = obtenerTweetsLocalStorage();

    tweets.forEach(function(tweet, index) {
        if (tweetBorrar === tweet) {
            // Como no sabemos si está al principio o al final (función splice), que elimina a partir de uan posición

            tweets.splice(index, 1);
        }
    });

    // De este arry buscamos el tweet que estamos eliminando y lo borramos del arreglo. Función splice

    //El array tweets los volcamos en localStorage

    localStorage.setItem('tweets', JSON.stringify(tweets));



}