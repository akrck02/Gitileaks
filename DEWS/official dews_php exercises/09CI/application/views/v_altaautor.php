<?php


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Recibe mens_insercion que tiene: "","OK insert","mal insert";

echo "<h3>NUEVO AUTOR</h3>";
echo form_open('c_autores/alta');
echo "Nombre " . form_input('nombre','');
echo "Fecha de nacimiento " . form_input('fechanac','');
$opciones=array('Francia'=>'Francia',
                'EEUU' =>'EEUU',
                'Rusia'=>'Rusia',
                'Otra'=>'Otra');
echo "Nacionalidad " . form_dropdown('nacionalidad',$opciones,'Rusia');
echo form_submit('submitalta','Nuevo autor');
echo form_close();
if (!empty($mens_insercion)){
    echo "<p style='color:red'>$mens_insercion</p>";
}
