package validators;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidadorFecha implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value == null){
            context.addMessage(component.getClientId(context), new FacesMessage("La fecha de final es obligatoria"));
            throw new ValidatorException(new FacesMessage("Fecha final obligatoria"));
        }
        
        Date fechaFin = (Date) value;
        Date fechaInicio = (Date) component.getAttributes().get("fini");
        
        Date now = new Date(System.currentTimeMillis() - 3600 * 1000);;
        
        if(fechaInicio.before(now) || fechaFin.before(now)){
            context.addMessage(component.getClientId(context), new FacesMessage("Las fechas deben ser futuras"));
            throw new ValidatorException(new FacesMessage("Alguna fecha incorrecta"));
        }
        
        if(fechaInicio.after(fechaFin)){
            context.addMessage(component.getClientId(context), new FacesMessage("La fecha de final de busqueda no puede ser anterior a la inicial"));
            throw new ValidatorException(new FacesMessage("Fecha final incorrecta"));
        }
    }
        
}
