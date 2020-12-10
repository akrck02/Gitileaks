<?php

//'libro'-Objeto con propiedades idlibro, titulo, paginas, genero, autor
//'fechas'-Array de objetos con propiedad fecha

echo "<h3>$libro->titulo</h3>";
echo "<p>$libro->paginas páginas, género: $libro->genero, autor: $libro->autor</p>";

echo "<h3>Fechas prestado</h3>";
foreach ($fechas as $fecha){
    echo "<p>$fecha->fecha</p>";
}

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

