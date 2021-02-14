package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


public class ValidadorCodigo implements Validator{
    private final static String[] CODS={"123", "234", "345", "456", "678"};

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        boolean codigoOK = false;
        String strValue = (String) value;
        
        for(String cod: CODS){
            if(strValue.equals(cod)){
                codigoOK = true;
                break;
            }
                
        }
        
        if(!codigoOK){
            context.addMessage(component.getClientId(context), 
                    new FacesMessage("Debes disponer del código"));
            new ValidatorException(new FacesMessage("Código erróneo"));
        }
        
        
    }
    
}
