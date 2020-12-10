var getAvg = (...values) => {

    // El método reduce() aplica una función a un acumulador y a cada valor de un array (de izquierda a derecha) para reducirlo a un único valor.
    return values.reduce(function(p, c) {
        return p + c;
    }) / values.length;
}

console.log(getAvg(3, 7)); // 5
console.log(getAvg(2, 10)); // 6