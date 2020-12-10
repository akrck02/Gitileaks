<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        
        <p>La raiz de 25 es &nbsp;
        <?php
            echo sqrt(25);
        
        ?>
        </p>    
        
        <p>Tabla de multiplicar del 8</p>
        <?php
        
        
        
            for ($factor=1; $factor<=10; $factor ++){
                echo 8 * $factor;
                echo "<br/>";
            }
        
        
        ?>
        
        
        <ul>
            <li>DEWS</li>
            <li>EIE</li>
            <li>DEAW</li>
        </ul>
    </body>
</html>
