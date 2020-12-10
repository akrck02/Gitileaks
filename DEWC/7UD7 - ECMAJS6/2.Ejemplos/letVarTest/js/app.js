function varTest() {
    var x = 31;
    if (true) {
        var x = 71; // misma variable!
        console.log(x);
    }
    console.log(x);
}

function letTest() {
    let x = 31;
    if (true) {
        let x = 71; // variable diferente
        console.log(x);
    }
    console.log(x);
}

varTest();
letTest();