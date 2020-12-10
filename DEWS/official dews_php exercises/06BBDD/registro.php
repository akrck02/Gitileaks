<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->


<?php

 session_start();
 $error="";
  require 'bbdd.php';
  $cn=conexion();

  if (isset($_POST['submitregistrar']) ){      
      $dni=$_POST['dni'];
      $nombre=$_POST['nombre'];
      $okRegistro=registrar($cn,$dni,$nombre);  //Devuelve true, false
      if ($okRegistro){
          $_SESSION['dni']=$dni;
          header("location: pedido.php"); exit();
      }
      else{
          $error="DNI duplicado";
      }
  }

?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
       
        <?php echo "<p>$error</p>" ?>
        <form action="<?php echo $_SERVER['PHP_SELF'] ?>"  method='post' >
            DNI <input type="text" name="dni" />
            Nombre <input type="text" name="nombre" />
            <input type="submit" name="submitregistrar" value="registrar" />           
            
        </form>
    </body>
</html>
