/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author lamenda
 */
public class Imagen {
    private String ruta;
    private String nombre;
    private long tamanio;

    public Imagen(String ruta, String nombre, long tamanio) {
        this.ruta = ruta;
        this.nombre = nombre;
        this.tamanio = tamanio;
    }
    
  

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public long getTamanio() {
        return tamanio;
    }

    public void setTamanio(long tamanio) {
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Imagen{" + "ruta=" + ruta + ", nombre=" + nombre + ", tamanio=" + tamanio + '}';
    }
    
    public String strTamanio(){
        
      
       long mb=tamanio/ (1024*1024);
       long  bytesRestantes=tamanio%(1024*1024);        
       
       long kb=bytesRestantes/1024;
       bytesRestantes=bytesRestantes%(1024);
       
       return mb + " Mb " + kb + " Kb " + bytesRestantes + " bytes";
    }
    
    public static void main(String args[]){
        Imagen im=new Imagen("","",8499106);
        System.err.println(im.strTamanio());
    }
    
}
