package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ConversorNombre implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String nombreConvertido = "";
        String nombre = value;
        
        if(!nombre.equals("")){
            String[] partesNombre = nombre.split(" ");
        
            for(String parte: partesNombre){
                char[] pal = parte.toLowerCase().toCharArray();
                System.err.println(pal);
                pal[0] = Character.toUpperCase(pal[0]);
                nombreConvertido += new String(pal)+" ";
            }
        }

        return nombreConvertido.trim();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String nombreConvertido = "";
        String nombre = (String) value;
        
        if(!nombre.equals("")){
            String[] partesNombre = nombre.split(" ");
        
            for(String parte: partesNombre){
                char[] pal = parte.toLowerCase().toCharArray();
                pal[0] = Character.toUpperCase(pal[0]);
                nombreConvertido += new String(pal)+" ";
            }
        }

        return nombreConvertido.trim();
    }

}
