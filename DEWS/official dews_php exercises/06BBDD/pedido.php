<!DOCTYPE html>

<?php
session_start();
require 'bbdd.php';
$cn= conexion();


if (!isset($_SESSION['dni']))
    header("location: registro.php");

if (!isset($_SESSION['pedido'])){
    $_SESSION['pedido']=array();
}

if (isset($_POST['submitpedir1'])){
    $idalimento=$_POST['idalimento'];
    
    if (array_key_exists($idalimento,$_SESSION['pedido']))
        $_SESSION['pedido'][$idalimento]++; 
    else
        $_SESSION['pedido'][$idalimento]=1;
    
}

if (isset($_GET['formalizar'])){
    
    $total=0;
    foreach ($_SESSION['pedido'] as $idalimento => $ctd){
        $total+= $ctd * precioDe($cn,$idalimento);        
    }    
    $idpedido=nuevoPedido($cn,$_SESSION['dni'], $total);    
    
    //Mostrar clave del nuevo pedido generado y vaciar el pedido en sesión
    echo "<p>Generado pedido de id $idpedido</p>";
    $_SESSION['pedido']=[];
    
}




?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
      
        <?php
        
            $alims= alimentos2($cn);
            echo "<table>";
            foreach ($alims as $alim){
                echo "<form action='".$_SERVER['PHP_SELF']."'  method='post'>";
                echo "<tr>";
                echo "<td>".$alim->nombre."</td>";
                echo "<td>".$alim->precio."€</td>";
                echo "<input type='hidden' name='idalimento' value='". $alim->id."' />";
                echo "<td><input type='submit' name='submitpedir1' value='Añadir unidad' /></td>";
            
                if (array_key_exists($alim->id,$_SESSION['pedido'])){
                    echo "<td>";
                    echo $_SESSION['pedido'][$alim->id] . " uds.";
                    echo "</td>";
                }
                echo "</tr>";
                echo "</form>";
            }   
            
            echo "</table>";
            $enlace=$_SERVER['PHP_SELF']."?formalizar";
            echo "<p><a href='$enlace'>FORMALIZAR PEDIDO</a></p>";
            
            

// put your code here
        ?>
        
        
        
    </body>
</html>
