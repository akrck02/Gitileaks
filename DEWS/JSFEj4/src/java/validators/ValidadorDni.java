package validators;

import dao.DaoClientes;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidadorDni implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        char[] letra = new char[]{'T','R','W','A','G','M','Y','F','P',
            'D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        String dni = (String) value;
        
        if(dni.length()!=9){
                context.addMessage(component.getClientId(context), 
                    new FacesMessage("El campo debe contener 8 números y una letra"));
                throw new ValidatorException(new FacesMessage("DNI incorrecto"));
            }
        
        if(DaoClientes.existeDni(dni)){
            context.addMessage(component.getClientId(context), 
                new FacesMessage("Ya existe un cliente con ese DNI"));
            throw new ValidatorException(new FacesMessage("DNI incorrecto"));
        }
        
        try{
            int numDni = Integer.parseInt(dni.substring(0, 8));
            char letraDni = dni.toUpperCase().charAt(8);
            
            if(letra[numDni%23]!=letraDni){
                context.addMessage(component.getClientId(context), 
                    new FacesMessage("Letra no válida"));
                throw new ValidatorException(new FacesMessage("DNI incorrecto"));
            }
            
        } catch(NumberFormatException e){
            context.addMessage(component.getClientId(context), 
                    new FacesMessage("El campo debe contener 8 números"));
            throw new ValidatorException(new FacesMessage("DNI incorrecto"));
        } 
    }

}
