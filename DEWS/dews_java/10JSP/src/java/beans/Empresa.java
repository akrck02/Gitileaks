/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Objects;

/**
 *
 * @author dw2
 */
public class Empresa {
    
    private String nombre;
    private float beneficio;
    private Trabajador[] trabajadores;
    private int trabActuales;

    public Empresa(String nombre, float beneficio, int maxTrab) {
        this.nombre=nombre;
        this.beneficio=beneficio;       
        trabajadores=new Trabajador[maxTrab];
        trabActuales=0;
        
    }
    
    public void trabajar(){
        //Trabajan todos los trabajadores
        for (int i=0; i<trabActuales; i++){
            trabajadores[i].trabajar();
        }
        beneficio+=100;
    }
    
    
    public boolean contratar (Trabajador t){
        if (trabActuales<trabajadores.length){
            trabajadores[trabActuales]=t;
            trabActuales++;
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(float beneficio) {
        this.beneficio = beneficio;
    }

    public Trabajador[] getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajador[] trabajadores) {
        this.trabajadores = trabajadores;
    }

    public int getTrabActuales() {
        return trabActuales;
    }

    @Override
    public String toString() {
        return  nombre + ", beneficio " + beneficio + ", " + trabActuales + " trabajadores";
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Empresa other = (Empresa) obj;
        if (Float.floatToIntBits(this.beneficio) != Float.floatToIntBits(other.beneficio)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
    
}
