
package mbeans;

import beans.Alumno;
import beans.Ciclo;
import java.util.ArrayList;


public class MBAlumno {
    
    private Alumno alumno;    
    private String pass;
    
    private String sexo;
    private String ciclo;
    
    private ArrayList<Ciclo> ciclos;   
    

   
    public MBAlumno() {
        alumno=new Alumno();
        sexo="H";      
        
        cargarCiclos();
    }
    
    private void cargarCiclos(){
        ciclos=new ArrayList<Ciclo>();
        ciclos.add(new Ciclo("Desarrollo Web","GS",5500));
        ciclos.add(new Ciclo("Peluqueria","GS",4500));
        ciclos.add(new Ciclo("Marketing","GM",7000));
    }
    

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public ArrayList<Ciclo> getCiclos() {
        return ciclos;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
    
    
    private boolean passOK(){
        
        String str="";
        for (int i=alumno.getNombre().length()-1; i>=0; i--)
            str+=alumno.getNombre().charAt(i);
        return  str.equals(pass);
        
    }
    
    
    public String login(){
        
        if (passOK())
            return "materias";
        else
            return null;
    }
    
    public String strSexo(){
        if (sexo.equals("M"))
            return "Mujer";
        else
            if (sexo.equals("H"))
                return "Hombre";
            else
                return "Desconocido";
    }
    
}
