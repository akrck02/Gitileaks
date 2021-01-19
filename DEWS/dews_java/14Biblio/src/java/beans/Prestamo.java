/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dw2
 */
public class Prestamo {
    private int idPrestamo;
    private Date fecha;
    private int idLibro;
    private Date fechaDev;

    public Prestamo() {
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public Date getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(Date fechaDev) {
        this.fechaDev = fechaDev;
    }

    
    public String strFecha(){
        SimpleDateFormat formateador=new SimpleDateFormat("dd/MM/yyyy");        
        return formateador.format(fecha);        
        
    }
    
    
    public String strFechaDev(){
        SimpleDateFormat formateador=new SimpleDateFormat("dd/MM/yyyy");        
        return formateador.format(fechaDev);        
        
    }
    
    @Override
    public String toString() {
        return idLibro + " " + fecha + " " + fechaDev; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
