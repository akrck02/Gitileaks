<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class C_autores extends CI_Controller {

        public function __construct() {
            parent::__construct();
            $this->load->model('m_libros');  //$this->m_libros disponible

            
           
        }
	
	public function index($mens="")
        {
            
            //$mens es un mensaje que se va a pasar a la vista v_altaautor
            
            $datos['titulo']="BIBLIOTECA AGORA";
            $this->load->view('v_titulobiblio',$datos);
            
            $this->load->view('v_autores');
            
            $datos['mens_insercion']=$mens;
            $this->load->view('v_altaautor',$datos);
            
            $this->load->view('v_pie');
            
	}
        
        function alta(){
            //Viene desde el botón de submit de v_altaautor
            if (!isset($_POST['submitalta'])){
                $this->index();
            }
            else{
                $nombre=$_POST['nombre'];
                $fechanac=$_POST['fechanac'];
                $nacionalidad=$_POST['nacionalidad'];
                $insertok=$this->m_libros->aniadirAutor($nombre,$fechanac,$nacionalidad);
                if ($insertok)
                      $this->index("Autor insertado");
                else 
                       $this->index("Autor repetido");
                
                
                
                
            }
            
            
            
        }
        
        
        
        
        
}
