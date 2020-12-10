<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->


<?php
    require 'bbdd.php';
    $cn=conexion();
    
    
    if (isset($_POST['submitimagen'])){
       
        $idalimento=$_POST['idalimento'];
        if (is_uploaded_file($_FILES['imagen']['tmp_name'])){
             //Pasar a texto el archivo imagen, escapando comillas, etc
             $blobimg=addslashes(file_get_contents($_FILES['imagen']['tmp_name']));
             guardarImagen($cn,$idalimento,$blobimg);            
        }
        else{
            echo "<p>No se ha podido subir imagen de $idalimento</p>";
        }
    }

?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
                $alims= alimentos3($cn);
        
        
                echo "<table>";
                foreach ($alims as $alim){
                    echo "<tr>";
                    echo "<td>$alim->nombre</td>";
                    if ($alim->imagen!=""){
                        echo "<td>"
                        . "<img height='30' src='data:image/jpeg;base64,".base64_encode( $alim->imagen ) . "'/>"
                        . "</td>";  
                    }
                    else{        
                        echo "<td>";
                        echo "<form action='".$_SERVER['PHP_SELF']."' method='post'  enctype='multipart/form-data'>";
                       echo "<input type='hidden' name='MAX_FILE_SIZE' value='1000000' />";
                        echo "<input type='file' name='imagen' />";
                        echo "<input type='hidden' name='idalimento' value='$alim->id' />";
                        echo "<input type='submit' name='submitimagen' value='Subir imagen' />";
                        echo "</form>";
                        echo "</td>";
                    }
                    echo "</tr>";          
                }
                echo "</table>";
        ?>
    </body>
</html>
