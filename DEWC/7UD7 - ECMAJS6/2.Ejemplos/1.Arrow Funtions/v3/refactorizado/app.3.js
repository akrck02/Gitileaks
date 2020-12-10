var getAvg = (...values) =>

    // El método reduce() aplica una función a un acumulador y a cada valor de un array (de izquierda a derecha) para reducirlo a un único valor.
    values.reduce(
        (p, c) => p + c
    ) / values.length;


console.log(getAvg(3, 7)); // 5
console.log(getAvg(2, 10)); // 6

// Si paráramos la matriz directamente como un parámetro normal

var getAvg = arr =>
    arr.reduce(
        (p, c) => p + c
    ) / arr.length;

console.info(getAvg([14, 8])); // 11