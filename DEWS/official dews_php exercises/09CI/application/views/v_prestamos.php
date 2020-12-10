<?php


 //$prestamos: Array de objetos (idprestamo,fecha,fechadev,titulo)

    echo "<h2>" . $this->session->userdata('empleado')->nombre . "</h2>";
    echo "<hr/>";
    
    
    echo "<p>". $this->session->flashdata('rtdodevolucion') . "</p>";
    
    echo "<table>";
    foreach ($prestamos as $prestamo){
        echo "<tr>";
        echo "<td>$prestamo->titulo</td>";
        echo "<td>$prestamo->fecha</td>";
       
        if (! $prestamo->fechadev){
            if (in_array($prestamo->idprestamo,$this->session->userdata('idsprestamos') )){
                echo "<td> Devolución anotada </td>";
            }
            else{        
                $enlace=site_url()."/c_devoluciones/anotarDevolucion/".$prestamo->idprestamo;
                echo "<td><a href='$enlace'>Anotar devolución</a></td>";
            }
        }
        else{
            echo "<td>$prestamo->fechadev</td>";
        }
        
        echo "</tr>";
    }
    echo "</table>";

    if (count ($this->session->userdata('idsprestamos')) >0){
        $enlace= site_url(). "/c_devoluciones/grabardevoluciones";
        echo "<p><a href='$enlace'>GRABAR DEVOLUCIONES</a></p>";
    }




?>

