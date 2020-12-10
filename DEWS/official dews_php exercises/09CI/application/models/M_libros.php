<?php

class M_libros extends CI_Model{
    
    
    public function cuantosLibros(){
      
        $rs=$this->db->query("select count(*) as cuantos from libros");
        $fila=$rs->row_array();
        return $fila['cuantos'];
    }
    
    
    public function libros(){
        $sql="select idlibro, titulo from libros";
        $rs=$this->db->query($sql);
        return $rs->result();  //Devuelve array de objetos libro
        
    }
    
    public function datosLibro($idlibro){
        $sql="select idlibro, titulo, paginas, genero, nombre as autor from autores, libros "
                . " where autores.idautor=libros.idautor and idlibro=$idlibro";
        $rs=$this->db->query($sql);
        return $rs->row(); 
    }
    
    public function prestamos ($idlibro){
        $sql="select prestamos.fecha from prestamos where idlibro=$idlibro";
        $rs=$this->db->query($sql);
        return $rs->result(); 
    }
    
    
    public function aniadirAutor($nombre,$fechanac,$nacionalidad){
        $sql="select nombre from autores where nombre='$nombre'";
        $rs=$this->db->query($sql);
        if ($rs->num_rows()==1)
            return false;
        
        $sql="insert into autores (nombre, fechanac, nacionalidad) "
                . " values ('$nombre','$fechanac','$nacionalidad')";
        echo $sql;exit();
        
        //query en consultas de actualizacion devuelve true/false
        $insertok=$this->db->query($sql);
        return $insertok;
        
    }
    
    function login($dni,$pass){
        
        $sql="select dni, nombre from empleados where dni='$dni' and"
                . " password='$pass'";
        $rs=$this->db->query($sql);
        if ($rs->num_rows()==0)
            return null;
        else
            return $rs->row();  //Devuelve fila como objeto
       
    }
    
    
    public function prestamos2(){
        
        $sql="select idprestamo, fecha, fechadev, titulo"
                . "  from prestamos, libros"
                . " where prestamos.idlibro=libros.idlibro order by fecha ";
        $rs=$this->db->query($sql);
        return $rs->result(); 
        //Array de objetos (idprestamo,fecha,fechadev,titulo)
        
        
    }
    
    
    public function devolverPrestamos($ids){
        //Recibe Pks de préstamos a devolver
        $devueltos=0;
        foreach ($ids as $id){
            $sql="update prestamos set fechadev=now() where idprestamo=$id";
            if ($this->db->query($sql))
                $devueltos++;
        }
        return $devueltos;
        
    }
    
}


?>