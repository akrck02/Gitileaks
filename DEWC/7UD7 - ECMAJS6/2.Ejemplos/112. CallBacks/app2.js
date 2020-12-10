// CallBack en ForEach

const ciudades = ['Londres', 'Nueva York', 'Madrid', 'Paris', 'Viena'];

// Inline CallBack
ciudades.forEach(function(ciudad) {
    console.log(ciudad);
})

/*
// Con función definida
function callback(ciudad) {
    console.log(ciudad);
}
ciudades.forEach(callback);
*/