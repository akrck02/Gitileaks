package mbeans;

import beans.Ciclo;
import beans.Persona;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class MBRegistro implements Serializable{

    private Persona persona;
    private String pass;
    private Ciclo ciclo;
    
    public MBRegistro() {
        persona = new Persona();
    }
    
   

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
    
    

    public void validaNombre(FacesContext context, UIComponent inputNombre, Object objNombre) 
            throws ValidatorException {
        //Que el nombre tenga dos partes, Nombre y apellido
        //Que no contenga $
        
        String txtNombre = (String)objNombre;
        String[] partes = txtNombre.split(" ");
        
        if(partes.length<2 || txtNombre.contains("$")){
            context.addMessage(inputNombre.getClientId(context), 
                    new FacesMessage("Nombre debe tener dos palabras y no contener $"));
            
            throw new ValidatorException(new FacesMessage("Nombre erróneo"));
        }
        
    }
    
    public Ciclo[] todosCiclos(){
        return new Ciclo[]{new Ciclo(10, "Admin Web", 1000),
                            new Ciclo(20, "Admin Web2", 2000),
                            new Ciclo(30, "Admin Web3", 3000)};
    }

}
