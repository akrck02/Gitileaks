<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class C_listado extends CI_Controller {

        public function __construct() {
            parent::__construct();
            $this->load->model('m_libros');  //$this->m_libros disponible

        }
	
	public function index()
	{
               $this->load->view("v_cabecera");
               $this->cargarVistaLibros();               
               $this->load->view("v_pie");
	}
        
        public function cargarVistaLibros(){
            
          
            $cantLibros=$this->m_libros->cuantosLibros();            
            $datos['cantLibros']=$cantLibros;
            $datos['libros']=$this->m_libros->libros();            
            $this->load->view("v_listalibros",$datos);
            
        }
        
        
        public function verLibro($idLibro){
            
            
             $this->load->view("v_cabecera");
             $this->cargarVistaLibros();
             $this->cargarVistaLibro($idLibro);
             $this->load->view("v_pie");
            
        }
        
        public function cargarVistaLibro($idLibro){
            
            $datos['libro']=$this->m_libros->datosLibro($idLibro);
            $datos['fechas']=$this->m_libros->prestamos($idLibro);
            $this->load->view('v_libro',$datos);
        }
        
        
        
}
