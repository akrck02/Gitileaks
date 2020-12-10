<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
       
        require("class.phpmailer.php"); 

 //Crear objeto Mailer (enviador de correo)               
        $mail = new PHPMailer();
        $mail->IsSMTP();
        $mail->SMTPAuth = true; 
        
 //DATOS SERVIDOR DE CORREO zoho               
                
                $mail->Host = "smtp.zoho.eu";
                $mail->Port = 587;               //465
                $mail->SMTPSecure = 'tls';       //ssl    
                $mail->Username = "nerea.ciudadjardin@zohomail.eu";   
                $mail->Password = "123456zoho";


//DATOS DEL MENSAJE                
                $mail->From = "nerea.ciudadjardin@zohomail.eu";
                $mail->FromName = "Web de Subastas";              
                $mail->AddAddress("asdfasd@asdf.com","Nombre destinatario");
                $mail->Subject = "Mensaje de la app de subastas";   
                $body = "Mensaje de prueba desde app Subastas<u>Agur</u>";         
                $mail->Body = $body; 
 //ENVIO DEL MENSAJE : devuelve true/false si se ha podido/no se ha podido enviar    
                if(!$mail->Send())
                          echo "<p>No se pudo enviar el Mensaje</p>";
                else
                          echo "<p>Mensaje enviado</p>";
        ?>
    </body>
</html>
