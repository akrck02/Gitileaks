package mbeans;

import java.util.ArrayList;
import java.util.Date;
import model.Ruta;
import dao.BusDAO;
import org.primefaces.model.DualListModel;

public class ManagedRutas {
    
    private ArrayList<Ruta> rutas;
    private DualListModel<String> dniPasajerosRuta;
    private int rutaSeleccionada;
    
    private Date fInicio;
    private Date fFinal;
    
    public ManagedRutas() {
        fInicio = new Date();
    }

    public String cargarRutas(){
        rutas = BusDAO.getRutasBetween(fInicio, fFinal);
        return null;
    }
    
    public String verPasajeros(int idRuta){
        
        ArrayList<String> dniOrigen = BusDAO.getPasajerosRuta(idRuta);
        ArrayList<String> dniDestino = new ArrayList<String>();
        
        dniPasajerosRuta = new DualListModel<String>(dniOrigen, dniDestino);
        rutaSeleccionada = idRuta;
        
        return null;
    }
    
    public String avisar(){
        ArrayList<String> dnis = (ArrayList<String>) dniPasajerosRuta.getTarget();
        
        BusDAO.avisarClientes(rutaSeleccionada, dnis);
        
        return null;
    }
    
    public ArrayList<Ruta> getRutas( ) {
        return rutas;
    }

    public void setRutas(ArrayList<Ruta> rutas) {
        this.rutas = rutas;
    }

    public Date getfInicio() {
        return fInicio;
    }

    public void setfInicio(Date fInicio) {
        this.fInicio = fInicio;
    }

    public Date getfFinal() {
        return fFinal;
    }

    public void setfFinal(Date fFinal) {
        this.fFinal = fFinal;
    }

    public DualListModel<String> getDniPasajerosRuta() {
        return dniPasajerosRuta;
    }

    public void setDniPasajerosRuta(DualListModel<String> dniPasajerosRuta) {
        this.dniPasajerosRuta = dniPasajerosRuta;
    }

    public int getRutaSeleccionada() {
        return rutaSeleccionada;
    }

    public void setRutaSeleccionada(int rutaSeleccionada) {
        this.rutaSeleccionada = rutaSeleccionada;
    }
    
    
    
}
