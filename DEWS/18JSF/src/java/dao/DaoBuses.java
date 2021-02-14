/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import org.apache.commons.dbcp2.BasicDataSource;
import java.util.List;
import beans.Bus;
import beans.Ruta;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author dw2
 */
public class DaoBuses {
    
    private static final BasicDataSource ds=new BasicDataSource();    
    static{
        //Este ds va con un pool de conexiones
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/bdbus");
        ds.setUsername("root");
        ds.setPassword("");  
    }
    
    public static List<Bus> buses(){         
        List<Bus> buses=new ArrayList<Bus>();
        String sql="select * from buses";
        try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql);
            )
        {
            while (rs.next()){
                Bus b=new Bus(rs.getString("id_placa"),rs.getInt("capacidad"));
                buses.add(b);
            }
        }
        catch (SQLException e){
            System.err.println("falla en buses " + e.getMessage() + " sql:" + sql);           
        }
        finally{
            return buses;
        }       
    }    
    
    
    public static ArrayList<Ruta> rutasBus(String placa){
        
       ArrayList<Ruta> rutas=new ArrayList<Ruta>();
       String sql="select id_ruta, ciudadorigen, ciudaddestino, horallegada, horasalida, tarifa"
                + ", id_placa from rutas where id_placa='" + placa + "'";
        try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql);
            )
        {
            while (rs.next()){
                Ruta r=new Ruta();
                r.setId_ruta(rs.getInt("id_ruta"));
                r.setCiudadOrigen((rs.getString("ciudadorigen")));
                r.setCiudadDestino(rs.getString("ciudaddestino"));
                
                Timestamp ts=new Timestamp(rs.getTimestamp("horasalida").getTime());
                r.setHoraSalida(new java.util.Date(ts.getTime()));
                
                Timestamp ts2=new Timestamp(rs.getTimestamp("horallegada").getTime());
                r.setHoraLlegada(new java.util.Date(ts2.getTime()));
                
                r.setTarifa(rs.getFloat("tarifa"));
                r.setId_placa(placa);                
                rutas.add(r);
                
            }
        }
        catch (SQLException e){
            System.err.println("falla en rutasBus " + e.getMessage() + " sql:" + sql);           
        }
        finally{
            return rutas;
        }       
        
    }
    
    
    public static void cambiarTarifa(Ruta r){
        String sql="update rutas set tarifa=" + r.getTarifa() + " where id_ruta=" + r.getId_ruta();
        try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();  
            )
        {
            st.executeUpdate(sql);
        }
        catch (SQLException e){
            System.err.println("falla en cambiarTarifa " + e.getMessage() + " sql:" + sql);           
        }
    }
        
        
        
    
    
   
}
