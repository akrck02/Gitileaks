/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import beans.Articulo;
import java.util.ArrayList;

/**
 *
 * @author dw2
 */
public class GestorArticulos {

    private ArrayList<Articulo> articulos; //articulos disponibles
    private ArrayList<String> pedidos;
    
    public GestorArticulos() {
        
        articulos=new ArrayList<Articulo>();
        articulos.add(new Articulo("Lavadora",505));
        articulos.add(new Articulo("Ambientador",36.5f));
        articulos.add(new Articulo("Desinfectante",28.3f));
        
        
        pedidos=new ArrayList<String>();
        
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public ArrayList<String> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<String> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    public String aniadir(String nombreArticulo){
        
        if (!pedidos.contains(nombreArticulo))
            pedidos.add(nombreArticulo);
        
        return null;
    }
    
     public String quitar(String nombreArticulo){
        pedidos.remove(nombreArticulo);        
        return null;
    }
    
    
    
    
}
