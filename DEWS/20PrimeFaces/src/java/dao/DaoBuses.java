/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import beans.Asiento;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import beans.Bus;
import beans.Cliente;
import beans.Ruta;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.dbcp2.BasicDataSource;

public class DaoBuses {
    
    
    private static final BasicDataSource ds=new BasicDataSource();    
    static{
        //Este ds va con un pool de conexiones
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/bdbus");
        ds.setUsername("aritz");
        ds.setPassword("123456");  
    }
    
    public static ArrayList<Ruta> todasRutas(){         
        ArrayList<Ruta> rutas = new ArrayList<>();
        
        String sql="select id_ruta, ciudadorigen, ciudaddestino, "
                + "horasalida, horallegada, tarifa, id_placa "
                + "from rutas";
        
        try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql);){
            
            while (rs.next()){
                Ruta ruta = new Ruta(rs.getInt("id_ruta"), rs.getString("ciudadorigen"), 
                        rs.getString("ciudaddestino"), new Date(rs.getDate("horasalida").getTime()), 
                        new Date(rs.getDate("horallegada").getTime()), rs.getFloat("tarifa"), 
                        rs.getString("id_placa"));
                rutas.add(ruta);
            }
            
        }
        catch (SQLException e){
            System.err.println("Error en método todasRutas " + e.getMessage() + " sql:" + sql);           
        }
        finally{
            return rutas;
        }       
    }
    
    public static ArrayList<Ruta> rutasPrecio(int min, int max){         
        ArrayList<Ruta> rutas = new ArrayList<>();
        
        String sql="select id_ruta, ciudadorigen, ciudaddestino, "
                + "horasalida, horallegada, tarifa, id_placa "
                + "from rutas "
                + "where tarifa >= "+min+" and "
                + "tarifa <= "+max;
        
        try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql);){
            
            while (rs.next()){
                Ruta ruta = new Ruta(rs.getInt("id_ruta"), rs.getString("ciudadorigen"), 
                        rs.getString("ciudaddestino"), new Date(rs.getDate("horasalida").getTime()), 
                        new Date(rs.getDate("horallegada").getTime()), rs.getFloat("tarifa"), 
                        rs.getString("id_placa"));
                rutas.add(ruta);
            }
            
        }
        catch (SQLException e){
            System.err.println("Error en método rutasPrecio " + e.getMessage() + " sql:" + sql);           
        }
        finally{
            return rutas;
        }       
    }
    
    public static int precioMin(){
        int min =0;
        
        String sql="select min(tarifa) from rutas";
        
        try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql);){
            
            if (rs.next()){
                min = (int)Math.floor(rs.getFloat("min(tarifa)"));
            }
            
        }
        catch (SQLException e){
            System.err.println("Error en método rutasPrecio " + e.getMessage() + " sql:" + sql);           
        }
        
        return min;
    }
    
    public static int precioMax(){
        int max =0;
        
        String sql="select max(tarifa) from rutas";
        
        try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql);){
            
            if (rs.next()){
                max = (int)Math.ceil(rs.getFloat("max(tarifa)"));
            }
            
        }
        catch (SQLException e){
            System.err.println("Error en método rutasPrecio " + e.getMessage() + " sql:" + sql);           
        }
        
        return max;
    }

    public static ArrayList<Asiento> asientosReservados(int idRuta){         
        ArrayList<Asiento> asientos = new ArrayList<>();
        
        String sql="select clientes.id_dni, nombre, direccion, email, numAsiento "
                + "from clientes, reservas "
                + "where reservas.id_dni = clientes.id_dni "
                + "and id_ruta = "+idRuta;

        try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql)){
            
            while (rs.next()){
                Cliente cliente = new Cliente(rs.getInt("id_dni"), rs.getString("nombre"), 
                        rs.getString("direccion"), rs.getString("email"));
                
                Asiento asiento = new Asiento(rs.getInt("numAsiento"), cliente);
                asientos.add(asiento);
            }
            
        }
        catch (SQLException e){
            System.err.println("Error en método asientosReservados " + e.getMessage() + " sql:" + sql);           
        }
        finally{
            return asientos;
        }       
    }
    
    public static Bus dameBusRuta(int id_ruta){         
        Bus bus = new Bus();
        
        String sql="select capacidad, imagen "
                + "from buses, rutas where buses.id_placa = 'rutas.id_placa'"
                + "and id_ruta = "+id_ruta;

        try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql)){
            
            if (rs.next()){
                bus.setCapacidad(rs.getInt("capacidad"));
                bus.setId_placa(rs.getString("id_placa"));
            }
            
        }
        catch (SQLException e){
            System.err.println("Error en método dameBus " + e.getMessage() + " sql:" + sql);           
        }
        finally{
            return bus;
        }       
    }
    
    public static Bus dameBus(String id_placa){         
        Bus bus = new Bus();
        
        String sql="select capacidad, imagen "
                + "from buses where id_placa='"+id_placa+"'";
        
        try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql)){
            
            if (rs.next()){
                bus.setCapacidad(rs.getInt("capacidad"));
                bus.setId_placa(id_placa);
                bus.setImagen(rs.getString("imagen"));
            }
            
        }
        catch (SQLException e){
            System.err.println("Error en método dameBus " + e.getMessage() + " sql:" + sql);           
        }
        finally{
            return bus;
        }       
    }

}
