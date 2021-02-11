<?php
    //conexión a BD
    //Sesión
    session_start();
    require 'config.php';
    $con = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_DATABASE);
    $con->set_charset("utf8");
    require 'bbdd.php';
    
    $pagActual = $_SERVER["REQUEST_URI"];
    if(substr($pagActual, -9)!="login.php"){
        $_SESSION['ultimapag'] = $pagActual;
    }

    if($con->connect_errno > 0){
        die("No ha sido posible conectar con la BD (".$connect_error.")");
    }
    
    
    
?>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/stylesheet.css" type="text/css">
        <title></title>
    </head>
    <body>
        <div id="header">
            <h1><?php echo NOMFORO ?></h1>
        </div>
        <div id="menu">
            <?php
                echo "<a href='subastas_vencidas.php'>Home</a>";
            ?>
        </div>
        <div id="container">
            <div id="bar">
                <?php require 'barra.php' ?>
            </div>
            <div id="main">

