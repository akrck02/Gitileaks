
package mbeans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


public class MBMaterias {
    
    private LinkedHashMap<String,String[]> materias;

    
    public MBMaterias() {
        
        materias=new LinkedHashMap<String,String[]>();
        materias.put("Desarrollo Web", new String[]{"LEMA","PROG","BBDD"});
        materias.put("Peluqueria", new String[]{"Alisado","Tinte","Moños","Coletas"});
        materias.put("Marketing", new String[]{"Contabilidad","Ventas","Almacenaje"});
    }

    public LinkedHashMap<String, String[]> getMaterias() {
        return materias;
    }
    
    
    public ArrayList<Entry> materiasAsArray(){
        
        return  new ArrayList(materias.entrySet());
    }
    
    
}
