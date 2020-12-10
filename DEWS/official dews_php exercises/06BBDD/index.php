<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<?php

         require 'bbdd.php';        
         $con= conexion();
         if (!$con)
             die("<br>Conexion erronea</br>");
         
         
         
         if (isset($_POST['submitinsert'])){
             
             $nombre=$_POST['nombre'];
             $precio=$_POST['precio'];
             $tipo=$_POST['tipo'];
             
             insertarAlimentoAhora($con, $nombre,$precio,$tipo);
         }         
         
         if (isset($_GET['actualizar'])){             
             $numAct=actualizarAlimAntiguos($con);             
         }
         
        if (isset($_POST['submittipo'])){
            $alimsTipo=alimentos($con,$_POST['tipo']);
        }
             
         

?>


<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>         
        
        <h2><a href='<?php echo $_SERVER['PHP_SELF']. "?actualizar"  ?>'>
                ACTUALIZAR ALIMENTOS ANTIGUOS
            </a>
            <?php if (isset($_GET['actualizar']))
                    echo "<p>$numAct alimentos actualizados a fecha de hoy</p>";
            ?>
        </h2>
        
        
        <h2>AÑADIR NUEVO ALIMENTO</h2>
        <form action="<?php echo $_SERVER['PHP_SELF']  ?>" method="post">
            Nombre:<input type="text" name="nombre" />
            Precio: <input type="text" name="precio" />
            Tipo:
            <select name="tipo">
                <option value="PRIMERO">PRIMERO</option>
                <option value="SEGUNDO">SEGUNDO</option>
                <option value="POSTRE">POSTRE</option>
            </select>
            <input type="submit" name="submitinsert" value="AÑADIR" />
        </form>
        
        <h2>ALIMENTOS</h2>
        <?php        
            $alims=alimentos($con);
            echo "<table>";
            foreach ($alims as $alim){
                    echo "<tr>";
                    echo "<td>". $alim['id'] . "</td>";
                    echo "<td>". $alim['nombre'] . "</td>";
                    echo "<td>". $alim['precio'] . "</td>";
                    echo "<td>". $alim['tipo'] . "</td>";
                    $fechaEsp=date('d-M-y',strtotime($alim['fecha']));                    
                    echo "<td>". $fechaEsp. "</td>";
                    echo "</tr>";
            }    
            echo "<table>";
        
        ?>
        
        <h2>VER ALIMENTOS POR TIPO</h2>
        
        <?php
            $tipos=tipos($con);            
            echo "<form action='".$_SERVER['PHP_SELF'] ."'   method='post'>";
            foreach ($tipos as $tipo){
                echo "<input type='radio' name='tipo' value='$tipo' />".$tipo;                
            }     
            echo "<input name='submittipo' type='submit' value='VER ALIMENTOS' />";
            echo "</form>";
            
            if (isset($alimsTipo)){
                echo "<table>";
                foreach ($alimsTipo as $alim){
                    echo "<tr>";
                    echo "<td>". $alim['id'] . "</td>";
                    echo "<td>". $alim['nombre'] . "</td>";
                    echo "<td>". $alim['precio'] . "</td>";
                    echo "<td>". $alim['tipo'] . "</td>";
                    $fechaEsp=date('d-M-y',strtotime($alim['fecha']));                    
                    echo "<td>". $fechaEsp. "</td>";
                    echo "</tr>";
            }    
            echo "<table>";
                
                
                
            }
            
        
        ?>
        
        
    </body>
</html>
