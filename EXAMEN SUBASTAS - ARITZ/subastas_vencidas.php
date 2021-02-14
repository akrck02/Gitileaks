<?php
    require 'cabecera.php';
    $prodSelec = "";
    
    if(isset($_GET['prod'])){
        $prodSelec = $_GET['prod'];
        $_SESSION['ultimapag'] = str_replace("?prod=$prodSelec", "", $_SESSION['ultimapag']);
    }
?>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Últimas subastas vencidas</h1>
        <table>
            <tr>
                <th>FINALIZÓ EL</th>
                <th>CATEGORÍA</th>
                <th>ITEM</th>
                <th>GANADOR</th>
            </tr>
        <?php
            $arrayProductos = sacarItemsFin($con);
            
            
            foreach ($arrayProductos as $prod) {
                $fechafin = fechaFin($con, $prod);
                $fecha = new DateTime($fechafin);
                $cat = catProd($con, $prod);
                $nombre = nombreProd($con, $prod);
                
                if(pujasProd($con, $prod)>0){
                    $id_ganador = pujaGanadora($con, $prod);
                    $ganador = sacarNombreId($con, $id_ganador);
                }
                else{
                    $ganador = "SIN PUJAS";
                }
                
                if($prod==$prodSelec){
                    echo "<tr style='background-color:yellow'>";
                }
                else{
                    echo "<tr>";
                }
                    echo "<td>".date_format($fecha, 'd-M-y H:i')."</td>";
                    echo "<td>$cat</td>";
                    echo "<td>$nombre</td>";
                    echo "<td>";
                        
                        if($ganador!="SIN PUJAS"){
                            echo "<a href='".$_SESSION['ultimapag']."?prod=$prod'>$ganador</a>";
                            
                            if($prod==$prodSelec){
                                $precioMax = pujaMax($con, $prod);
                                $precioPartida = precioPartida($con, $prod);
                                $porcDif = ($precioMax*100)/$precioPartida;
                                
                                echo "<p>Ganado por ".$precioMax."€</p>";
                                echo "<p>$porcDif % superior al precio de partida ($precioPartida €)</p>";
                                
                            }
                            
                        }
                        else{
                            echo $ganador;
                        }
                    
                    echo "</td>";
                echo "</tr>";
            }
        ?>
        </table>
    </body>
</html>
