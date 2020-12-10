<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Bienvenida extends CI_Controller {

	public function index()
	{
                echo "<u>Bienvenido</u>";
		
	}
        
        public function verHora(){
            echo date('d-m-Y');
        }
        
        public function sumar($num,$num2){
            echo $num + $num2;
        }
}
