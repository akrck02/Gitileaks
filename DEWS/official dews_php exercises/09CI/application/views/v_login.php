<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

echo "<p>" . $this->session->flashdata('error') . "</p>";

echo form_open('c_devoluciones/login');
echo "DNI bibliotecario " .form_input('dni','');
echo "Password " . form_password('pass','');
echo form_submit('submitlogin','ENTRAR');
echo form_close();

