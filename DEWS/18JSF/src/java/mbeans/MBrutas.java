package mbeans;

import beans.Bus;
import beans.Ruta;
import dao.DaoBuses;
import java.util.ArrayList;

public class MBrutas {

    private ArrayList<Bus> buses;
    private ArrayList<Ruta> rutas;
    private String busActual;
   
    public MBrutas() {        
        buses=(ArrayList<Bus>) DaoBuses.buses();

        rutas=DaoBuses.rutasBus(busActual);
        
    }

    public ArrayList<Bus> getBuses() {
        return buses;
    }

    public void setBusActual(String busActual) {
        this.busActual = busActual;
    }

    public String getBusActual() {
        return busActual;
    }

    public ArrayList<Ruta> getRutas() {
        return rutas;
    }
    
    public String cambiarTarifa(Ruta ruta){
        DaoBuses.cambiarTarifa(ruta);        
        return null;
    }
    
    public void cargarRutasBus(){
        
        rutas=DaoBuses.rutasBus(busActual);
       
    }
    
}
