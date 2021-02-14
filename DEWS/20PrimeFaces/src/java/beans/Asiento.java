package beans;

import java.util.ArrayList;

public class Asiento {
    private int num;
    private Cliente cliente;

    public Asiento() {
    }

    public Asiento(int num) {
        this.num = num;
    }

    public Asiento(int num, Cliente cliente) {
        this.num = num;
        this.cliente = cliente;
    }
    
    public ArrayList<Asiento> asientosReservados(Ruta ruta){
        ArrayList<Asiento> asientos = new ArrayList<>();
        
        
        return asientos;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.num;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asiento other = (Asiento) obj;
        if (this.num != other.num) {
            return false;
        }
        return true;
    }
    
    
}
