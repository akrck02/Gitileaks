package mbeans;

import beans.Ruta;
import dao.DaoBuses;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;


public class MBRutas {

    private ArrayList<Ruta> rutas;
    private int n1;
    private int n2;
    private int minBD,maxBD;
    
    public MBRutas() {
        
        rutas = DaoBuses.todasRutas();
        minBD=DaoBuses.precioMin();
        maxBD=DaoBuses.precioMax();
        n1=minBD;
        n2=maxBD;
    }

    public String cargarRutas(){
        System.out.println(n1 + " y " + n2);
        rutas = DaoBuses.rutasPrecio(n1, n2);
        
        return null;
    }
    
    public ArrayList<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(ArrayList<Ruta> rutas) {
        this.rutas = rutas;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getMaxBD() {
        return maxBD;
    }

    public int getMinBD() {
        return minBD;
    }
    
    
    
}
