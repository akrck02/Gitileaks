
var PI = Math.PI;
var E = Math.E;

console.log(E);
console.log(PI);

var num = 19.456789;

console.log( num );
console.log(Math.round(num*100)/100);

console.log(Math.floor(num));	// Lo trunca


function randomEntre(min,max){

	return Math.floor( Math.random() * ( max-min+1 ) + min );

}

console.log(randomEntre(1,6)); //Random entre 1 y 6

console.log(Math.sqrt(2));

console.log(Math.pow(7,2));
