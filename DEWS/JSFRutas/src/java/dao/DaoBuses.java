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
import beans.Bus;
import beans.Cliente;
import beans.Ruta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.dbcp2.BasicDataSource;

public class DaoBuses {
    
    
    private static final BasicDataSource ds=new BasicDataSource();    
    static{
        //Este ds va con un pool de conexiones
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/bdbus");
        ds.setUsername("root");
        ds.setPassword("");  
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
                Cliente cliente = new Cliente(rs.getString("id_dni"), rs.getString("nombre"), 
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
                + "from buses, rutas where buses.id_placa = rutas.id_placa"
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
            System.err.println("Error en método dameBusRuta " + e.getMessage() + " sql:" + sql);           
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
            }
            
        }
        catch (SQLException e){
            System.err.println("Error en método dameBus " + e.getMessage());           
        }
        
        return bus;
    }
    
    public static void reservar(Ruta ruta, Asiento[] asientos){
        String sql="insert into reservas (id_ticket, pagado, numasiento, id_dni, id_ruta) "
                + "values(null, 0, ?, ?, "+ruta.getId_ruta()+")";

        
        try(Connection cn=ds.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql)){
            
            for(Asiento a: asientos){
                ps.setInt(1, a.getNum());
                ps.setString(2, a.getCliente().getId_dni());
                ps.executeUpdate();
            }
            
        }
        catch (SQLException e){
            System.err.println("Error en método reservar " + e.getMessage() + " sql:" + sql);           
        }
    }
    
    public static Cliente dameCliente(String id){
        Cliente c = null;
        
        String sql="select nombre, direccion, email "
                + "from clientes where id_dni='"+id+"'";
        
        try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql)){
            
            if (rs.next()){
                c = new Cliente(id, rs.getString("nombre"), 
                        rs.getString("direccion"), rs.getString("email"));
            }
            
        }
        catch (SQLException e){
            System.err.println("Error en método dameCliente " + e.getMessage() + " sql:" + sql);           
        }
        
        return c;
    }
    
    public static boolean comprobarCliente(String id){
        String sql="select count(*) as count "
                + "from clientes where id_dni='"+id+"'";
        
        try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql)){
            
            rs.next();
            
            if(rs.getInt("count")>0)
                return true;
            
        }
        catch (SQLException e){
            System.err.println("Error en método comprobarCliente " + e.getMessage());           
        }
        
        return false;
    }

}
