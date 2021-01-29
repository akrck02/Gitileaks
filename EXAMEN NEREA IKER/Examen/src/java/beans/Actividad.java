package beans;

import java.io.Serializable;

public class Actividad implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String nombre;
    private float coste;
    private Impartidor impartidor;

    public Actividad() {
    }

    public Actividad(int id, String nombre, float coste, Impartidor impartidor) {
        this.id = id;
        this.nombre = nombre;
        this.coste = coste;
        this.impartidor = impartidor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCoste() {
        return coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }

    public Impartidor getImpartidor() {
        return impartidor;
    }

    public void setImpartidor(Impartidor impartidor) {
        this.impartidor = impartidor;
    }
    
    
}
