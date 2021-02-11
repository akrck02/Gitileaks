<?php
    require 'cabecera.php';
    $error = "";
    $puja = "";
    $filasInsertadas = "";
    
    if(isset($_POST['submit'])){
        $prod = $_POST['prod'];
        $puja = $_POST['puja'];
        
        if(isset($_SESSION['pujasF'][$prod])){
            $pujaMax = $_SESSION['pujasF'][$prod];
        }
        else{
            $pujaMax = pujaMax($con, $prod);
        }
        
        if($puja==""){
            $error = "Debes introducir una puja";
        }
        else if(!is_numeric($puja)){
            $error = "La puja introducida debe ser numérica";
        }
        else if($puja<= $pujaMax){
            $error = "La puja introducida es inferior al precio actual";
        }
        else{
            $_SESSION['pujasF'][$prod] = $puja;
        }
    }
    else if(isset($_POST['submitPujas'])){
        $arrayUsuariosF = usuariosF($con);
        $cont= 0;
        $seleccionados = $_POST['checks'];

        foreach ($seleccionados as $prod) {

            if(pujar($con, $arrayUsuariosF[array_rand($arrayUsuariosF)], $prod, $_SESSION['pujasF'][$prod])){
                $cont++;
            }
        }
        $filasInsertadas = $cont;
        session_destroy();
        session_start();
    }
?>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>SUBASTAS VIGENTES</h1>
        <p style="color:red"><strong><?php echo $error ?></strong></p>
        <table>
            <tr>
                <th>ITEM</th>
                <th>ÚLTIMA PUJA</th>
                <th>QUEDAN</th>
                <th>PUJA FICTICIA</th>
            </tr>
        <?php
            $arrayProds = sacarItemsNoFin($con);
            
            foreach ($arrayProds as $prod) {
                $nombre = nombreProd($con, $prod);
                $fechafin = strtotime(fechaFin($con, $prod));
                $fechaHoy = time();
                $difDias = (int)($fechafin-$fechaHoy)/(60*60*24);
                $dias = $difDias%30;
                $meses = (int)($difDias/30);
                
                echo "<form method='POST' action='".$_SERVER['PHP_SELF']."'>";
                echo "<tr>";
                    echo "<td>$nombre</td>";
                    
                    if(pujasProd($con, $prod)>0){
                        $pujaMax = pujaMax($con, $prod);
                        echo "<td>$pujaMax €</td>";
                    }
                    else{
                        echo "<td>Sin pujas</td>";
                    }
                    
                    echo "<td>$meses meses $dias días</td>";
                   
                    if(pujasProd($con, $prod)>0){
                        echo "<td>";
                            echo "<input type='hidden' name='prod' value='$prod'>";
                            
                            if(isset($_SESSION['pujasF'][$prod])){
                                echo "<input type='text' name='puja' value='".$_SESSION['pujasF'][$prod]."'>";
                            }
                            else{
                                echo "<input type='text' name='puja'>";
                            }

                            echo "<input type='submit' name='submit' value='Nueva puja ficticia'>";
                        echo "</td>";
                    }
                    else "echo <td></td>";
                    
                echo "</tr>";
                echo "</form>";
            }
            
            echo "</table>";
            echo "<h2>POSIBLES PUJAS FICTICIAS</h2>";
            
            if($filasInsertadas!=""){
                if($filasInsertadas==1){
                    echo "<p>Se ha insertado $filasInsertadas puja falsa</p>";
                }
                else{
                    echo "<p>Se han insertado $filasInsertadas pujas falsas</p>";
                }
            }
            else if(!isset($_SESSION['pujasF'])){
                echo "<p>AÚN NO HAS AÑADIDO NINGUNA PUJA</p>";
            }
            else{
                echo "<form method='POST' action='".$_SERVER['PHP_SELF']."'>";
                    echo "<ul>";
                    foreach ($_SESSION['pujasF'] as $prod => $puja) {
                        $nombre = nombreProd($con, $prod);
                        echo "<li>";
                            echo $nombre.", ".$puja."€ ";
                            echo "<input type='checkbox' value='$prod' name='checks[]' checked>";
                        echo "</li>";
                    }
                    echo "</ul>";
                    echo "<input type='submit' name='submitPujas' value='GRABAR PUJAS MARCADAS'>";
                echo "</form>";
            }
        ?>
        
        
    </body>
</html>
