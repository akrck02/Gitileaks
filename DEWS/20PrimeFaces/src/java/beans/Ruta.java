/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.DaoBuses;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dw2
 */
public class Ruta {
    private int id_ruta;
    private String ciudadOrigen, ciudadDestino;
    private java.util.Date horaSalida, horaLlegada;
    private float tarifa;
    private Bus bus;
    private int capacidadDisp;
    private ArrayList<Asiento> asientosReservados;
    private ArrayList<Asiento> asientosLibres;
    private String id_placa;
    
    private boolean editando;

    public Ruta() {
    }

    public Ruta(int id_ruta, String ciudadOrigen, String ciudadDestino, Date horaSalida, Date horaLlegada, float tarifa, String id_placa) {
        this.id_ruta = id_ruta;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.tarifa = tarifa;
        this.bus = DaoBuses.dameBus(id_placa);
        this.id_placa = id_placa;
        asientosReservados = DaoBuses.asientosReservados(id_ruta);
        asientosLibres = asientosLibres();
    }

    public ArrayList<Asiento> asientosLibres(){
        ArrayList<Asiento> asientos = new ArrayList<>();
        System.err.println(bus.getCapacidad());
        for(int num=1; num<=bus.getCapacidad(); num++){
            if(!asientosReservados.contains(new Asiento(num))){
                asientos.add(new Asiento(num));
            }
        }
        
        return asientos;
    }
    
    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public int getCapacidadDisp() {
        return capacidadDisp;
    }

    public void setCapacidadDisp(int capacidadDisp) {
        this.capacidadDisp = capacidadDisp;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public ArrayList<Asiento> getAsientosReservados() {
        return asientosReservados;
    }

    public void setAsientosReservados(ArrayList<Asiento> asientosReservados) {
        this.asientosReservados = asientosReservados;
    }

    public ArrayList<Asiento> getAsientosLibres() {
        return asientosLibres;
    }

    public void setAsientosLibres(ArrayList<Asiento> asientosLibres) {
        this.asientosLibres = asientosLibres;
    }

    public String getId_placa() {
        return id_placa;
    }

    public void setId_placa(String id_placa) {
        this.id_placa = id_placa;
    }

    
    
}
