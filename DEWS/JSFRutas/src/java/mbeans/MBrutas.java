package mbeans;

import beans.Asiento;
import beans.Cliente;
import beans.Ruta;
import dao.DaoBuses;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class MBrutas implements Serializable{
    private ArrayList<Ruta> todasRutas;
    private Ruta rutaSelec;
    private String dniReserva;
    private String[] asientosSelec;

    public MBrutas() {
        todasRutas = (ArrayList<Ruta>)DaoBuses.todasRutas();
    }
    
    public String comprar(Ruta ruta){
        rutaSelec = ruta;
        
        return "reserva.xhtml";
    }
    
    public void validaDni(FacesContext context, UIComponent inputDni, Object objDni) 
            throws ValidatorException {
        
        String txtDni = (String)objDni;

        if(!DaoBuses.comprobarCliente(txtDni)){
            context.addMessage(inputDni.getClientId(context), new FacesMessage("DNI no válido"));
            throw new ValidatorException(new FacesMessage("DNI erróneo"));
        }
        
    }
    
    public String reservar(){
        Asiento[] asientos = new Asiento[asientosSelec.length];
        Cliente c = DaoBuses.dameCliente(dniReserva);
        
        for(int i=0;i<asientosSelec.length;i++){
            asientos[i] = new Asiento(Integer.parseInt(asientosSelec[i]), c);
        }
        
        DaoBuses.reservar(rutaSelec, asientos);
        rutaSelec.setAsientosLibres(rutaSelec.asientosLibres());
        rutaSelec.setAsientosReservados(DaoBuses.asientosReservados(rutaSelec.getId_ruta()));
        
        return null;
    }
    
    public String finalizarCompra(int id_dni, Ruta ruta){
        
        
        return null;
    }

    public ArrayList<Ruta> getTodasRutas() {
        return todasRutas;
    }

    public void setTodasRutas(ArrayList<Ruta> todasRutas) {
        this.todasRutas = todasRutas;
    }

    public Ruta getRutaSelec() {
        return rutaSelec;
    }

    public void setRutaSelec(Ruta rutaSelec) {
        this.rutaSelec = rutaSelec;
    }

    public String getDniReserva() {
        return dniReserva;
    }

    public void setDniReserva(String dniReserva) {
        this.dniReserva = dniReserva;
    }

    public String[] getAsientosSelec() {
        return asientosSelec;
    }

    public void setAsientosSelec(String[] asientosSelec) {
        this.asientosSelec = asientosSelec;
    }

}
