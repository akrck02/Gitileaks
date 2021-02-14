package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Ruta;
import org.apache.commons.dbcp2.BasicDataSource;

public class BusDAO {
    private static final BasicDataSource ds = new BasicDataSource();    
    static{
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/bdbus");
        ds.setUsername("root");
        ds.setPassword("");
    } 
     
    public static ArrayList<Ruta> getRutasBetween(Date d1, Date d2){
        //SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        String sql = "SELECT ID_RUTA, CIUDADORIGEN, CIUDADDESTINO, HORASALIDA, HORALLEGADA, TARIFA, ID_PLACA "
                + "FROM RUTAS "
                + "WHERE HORASALIDA BETWEEN ? AND ?";
        ArrayList<Ruta> vuelta = new ArrayList<Ruta>();
        
        try(Connection cn = ds.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql)){
            
            pst.setTimestamp(1, new Timestamp(d1.getTime()));
            pst.setTimestamp(2, new Timestamp(d2.getTime()));
            
            try(ResultSet rs = pst.executeQuery()){
                while(rs.next()){
                    Ruta r = new Ruta();
                    r.setIdRuta(rs.getInt("ID_RUTA"));
                    r.setCiudadOrigen(rs.getString("CIUDADORIGEN"));
                    r.setCiudadDestino(rs.getString("CIUDADDESTINO"));
                    r.setHoraSalida(new Date(rs.getTimestamp("HORASALIDA").getTime()));
                    r.setHoraLlegada(new Date(rs.getTimestamp("HORALLEGADA").getTime()));
                    r.setTarifa(rs.getInt("TARIFA"));
                    r.setIdPlaca(rs.getString("ID_PLACA"));
                    vuelta.add(r);
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return vuelta;
    }
    
    public static ArrayList<String> getPasajerosRuta(int idRuta){
        ArrayList<String> vuelta = new ArrayList<String>();
        String sql = "SELECT DISTINCT ID_DNI FROM RESERVAS WHERE ID_RUTA = ?";
        
        try(Connection cn = ds.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql)){
            pst.setInt(1, idRuta);
            try(ResultSet rs = pst.executeQuery()){
                while(rs.next()){
                    vuelta.add(rs.getString("ID_DNI"));
                }
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return vuelta;
    }
    
    public static boolean avisarClientes(int idRuta, ArrayList<String> dnis){
        String sql = "INSERT INTO AVISOS (ID_RUTA, DNI, FECHA_AVISO) VALUES (?, ?, NOW())";
        
        try(Connection cn = ds.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql)){
            pst.setInt(1, idRuta);
            for(String dni: dnis){
                pst.setString(2, dni);
                pst.executeUpdate();
            }
            return true;
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }
}
