package validators;

import com.google.common.collect.ImmutableList;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidadorEmail implements Validator{
    
    private ImmutableList PROHIBIDOS = ImmutableList.of("aa.com","ss.com", "dd.com");

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String email = (String) value;
        String[] partesEmail = email.split("@");
        
        if(partesEmail.length!=2 || partesEmail[1].indexOf(".")==-1){
            context.addMessage(component.getClientId(context), 
                new FacesMessage("El email debe tener el formato xxx@yyy.zzz"));
            throw new ValidatorException(new FacesMessage("Email incorrecto"));
        }
        
        if(PROHIBIDOS.contains(partesEmail[1])){
            context.addMessage(component.getClientId(context), 
                new FacesMessage("Dominio de email prohibido"));
            throw new ValidatorException(new FacesMessage("Email incorrecto"));
        }
        
    }

}
