let elemento;

elemento = document;
elemento = document.all;
elemento = document.all[0];
elemento = document.head;
elemento = document.body;
elemento = document.domain;
elemento = document.URL;
elemento = document.characterSet;
elemento = document.contentType;
elemento = document.forms;
elemento = document.forms[0];
//elemento = document.forms[0].id;
elemento = document.forms[0].method;
elemento = document.forms[0].action;

elemento = document.links;
//elemento = document.links[0].id;
elemento = document.links[0].className;
elemento = document.forms[0].classList;
elemento = document.forms[0].classList[0];

elemento = document.images;

elemento = document.scripts;
elemento = document.scripts[2].getAttribute('src');

// Loop a los scripts
let scripts = document.scripts;
let scriptsArr = Array.from(scripts);

scriptsArr.forEach(function(script) {
    console.log(script);
});

console.log(elemento);