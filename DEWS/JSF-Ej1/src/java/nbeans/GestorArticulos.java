/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbeans;

import beans.Articulo;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author dw2
 */
@Named(value = "gestorArticulos")
@Dependent
public class GestorArticulos {

    private ArrayList<Articulo> articulos;
    private ArrayList<String> pedidos;
    
    public GestorArticulos() {
        
        articulos = new ArrayList<>();
        articulos.add(new Articulo("Lavadora", 505));
        
        pedidos = new ArrayList<>();
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }
}
