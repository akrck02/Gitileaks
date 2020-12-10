<?php

    define ('HOST','localhost');
    define ('USER', 'root');
    define ('PASS', '');
    define ('DB', 'bdrestaurante');


  function conexion(){      
      $con=mysqli_connect(HOST,USER,PASS,DB);
      if ( mysqli_connect_errno($con) >0 ){
          return false;          
      }
      else{
          return $con;
      }
      mysqli_set_charset($con, 
              "utf8");
  }
  
  function actualizarAlimAntiguos($con){
              mysqli_set_charset($con, 
              "utf8");
      $sql="update alimentos set fecha=now() where fecha <'2020/10/01'";
      mysqli_query($con, $sql);      
      return mysqli_affected_rows($con);
      
  }
  
  
   function insertarAlimentoAhora($con,$nombre,$precio,$tipo){
         mysqli_set_charset($con, 
              "utf8");
       $sql="insert into alimentos (nombre, precio, tipo, fecha)"
               . " values ('$nombre',$precio, '$tipo', now()) ";
       //echo $sql;
               
       mysqli_query($con, $sql);
   }

   function alimentos($con, $tipo=""){
         mysqli_set_charset($con, 
              "utf8");
       //Si no se pasa 2º paraemtro, $tipo toma el valor ""
       $alims=array();
       if ($tipo=="")
            $sql="select id, nombre, precio, tipo, fecha from alimentos"; 
       else
           $sql="select id, nombre, precio, tipo, fecha from alimentos"
               . " where tipo='$tipo'";
       $rs =mysqli_query($con, $sql);       
       while ($fila=mysqli_fetch_assoc($rs)){           
           $alims[]=$fila;           
       }       
       return $alims;
   }
   
   
   
   
   function tipos($con){
      $tipos=[]; 
      $sql="select distinct tipo from alimentos";
      $rs =mysqli_query($con, $sql); 
      while ($fila=mysqli_fetch_array($rs)){
          $tipos[]=$fila[0];
      }
      return $tipos;
      
   }
   
   
   
   function registrar($cn,$dni,$nombre){
       //Ver si dni existente
       $sql="select idcliente from clientes where idcliente='$dni'";
       $rsCliente=mysqli_query($cn, $sql);       
       /*
       if (mysqli_num_rows($rsCliente)==1)
           return false;
       */
       if ($fila=mysqli_fetch_assoc($rsCliente)){          
           return false;           
       }
       else{
           $sql2="insert into clientes(idcliente,nombre) values ('$dni','$nombre')";
           mysqli_query($cn, $sql2);
          // mysqli_affected_rows($cn)  contendrá 1
           
           return true;
       }
       
       
   }
   
   
   function alimentos2($con){       
    
       $alims=array();
       $sql="select id, nombre, precio, tipo, fecha from alimentos";       
       $rs =mysqli_query($con, $sql);       
       while ($alimento=mysqli_fetch_object($rs)){           
           $alims[]=$alimento;           
       }       
       return $alims;
   }
   
   function precioDe($cn,$idalimento){
       
       $sql="select precio from alimentos where id=$idalimento";
       $rs =mysqli_query($cn, $sql); 
       if ($alimento=mysqli_fetch_object($rs)){
           return $alimento->precio;
       }
       
   }
   
   
    function nuevoPedido($cn,$idcliente, $total){
        
        $sql="insert into pedidos(idcliente, preciototal)"
                . " values ('$idcliente',$total)";
        mysqli_query($cn, $sql); 
        if (mysqli_affected_rows($cn)==1)
            return mysqli_insert_id ($cn);
        else
            return -1;
    }
   
    
    
     function alimentos3($cn){       
    
       $alims=array();
       $sql="select id, nombre, precio, tipo, fecha, imagen from alimentos";       
       $rs =mysqli_query($cn, $sql);       
       while ($alimento=mysqli_fetch_object($rs)){           
           $alims[]=$alimento;           
       }       
       return $alims;
   }
   
   
   function guardarImagen($cn,$idalimento,$blobimg){
       $sql="update alimentos set imagen='$blobimg' where id=$idalimento";
       mysqli_query($cn, $sql);    
   }
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

