<?php
function sacarItemsFin($con){
    $arrayProds = [];
    $sql = "select id from items where fechafin<=now() order by fechafin desc";
    
    $resultado = $con->query($sql);
    if($con->errno) die($con->error);
    
    while($fila = $resultado->fetch_assoc()){
        $arrayProds[] = $fila["id"];
    }
    
    return $arrayProds;
}

function sacarItemsNoFin($con){
    $arrayProds = [];
    $sql = "select id from items where fechafin>now()";
    
    $resultado = $con->query($sql);
    if($con->errno) die($con->error);
    
    while($fila = $resultado->fetch_assoc()){
        $arrayProds[] = $fila["id"];
    }
    
    return $arrayProds;
}

function nombreProd($con, $prod){
    $sql = "select nombre from items where id='$prod'";
    $resultado = $con->query($sql)->fetch_assoc()["nombre"];
    if($con->errno) die($con->error);
    
    return $resultado;
}

function fechaFin($con, $prod){
    $sql = "select fechafin from items where id='$prod'";
    $resultado = $con->query($sql)->fetch_assoc()["fechafin"];
    if($con->errno) die($con->error);
    
    return $resultado;
}

function catProd($con, $prod){
    $sql = "select categoria from categorias"
            . " where id= "
            . "(select id_cat from items "
            . "where id=$prod)";

    $resultado = $con->query($sql)->fetch_assoc()["categoria"];
    if($con->errno) die($con->error);
    
    return $resultado;
}

function pujasProd($con, $prod){
    $sql = "select count(*) from pujas where id_item='$prod'";
    $resultado = $con->query($sql)->fetch_assoc()["count(*)"];
    if($con->errno) die($con->error);
    
    return $resultado;
}

function pujaGanadora($con, $prod){
    $sql = "select id_user from pujas where id_item=$prod"
            . " and cantidad = (select max(cantidad)"
            . " from pujas where id_item=$prod)";

    $resultado = $con->query($sql)->fetch_assoc()["id_user"];
    if($con->errno) die($con->error);
    
    return $resultado;
}

function sacarNombreId($con, $idUser){
    $sql = "select nombre from usuarios where id='$idUser'";
    $resultado = $con->query($sql)->fetch_assoc()["nombre"];
    if($con->errno) die($con->error);
    
    return $resultado;
}

function pujaMax($con, $prod){
    $sql = "select max(cantidad) from pujas"
            . " where id_item=$prod";
    
    $resultado = $con->query($sql)->fetch_assoc()["max(cantidad)"];
    if($con->errno) die($con->error);
    
    return $resultado;
}

function precioPartida($con, $prod){
    $sql = "select preciopartida from items where id='$prod'";
    $resultado = $con->query($sql)->fetch_assoc()["preciopartida"];
    if($con->errno) die($con->error);
    
    return $resultado;
}

function usuariosF($con){
    $arrayUsuariosF = [];
    
    $sql = "select id from usuarios "
            . "where activa=1 "
            . "and existe=0";
    
    $resultado = $con->query($sql);
    if($con->errno) die($con->error);
    
    while($fila = $resultado->fetch_assoc()){
        $arrayUsuariosF[] = $fila["id"];
    }
    
    return $arrayUsuariosF;
}

function pujar($con, $user, $prod, $cant){
    $sql = "insert into pujas (id_item, id_user, cantidad, fecha)"
            . " values ('$prod', '$user', '$cant', now())";
    
    $con->query($sql);
    if($con->errno){
        die($con->error);
    }
    else{
        return true;
    }
}