package dao;

import beans.Actividad;
import beans.Alumno;
import beans.Impartidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;
import org.apache.commons.dbcp2.BasicDataSource;

public class Dao {
    private static final String IMARTIDOR_PASSWORD = "damocles";
    
    private static BasicDataSource dataSource = new BasicDataSource();
    
    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/bdactividades");
        dataSource.setUsername("root");
        dataSource.setPassword("");
    }
	
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
    
    public static Alumno loginAlumno(String dni, String password){
        String sql = "SELECT NOMBRE, APELLIDOS, TELEFONO, EMAIL FROM ALUMNOS WHERE DNI = ?";
        try(
            Connection cn = getConnection();
            PreparedStatement pst = cn.prepareStatement(sql)){
            
            pst.setString(1, dni);
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){
                    Alumno alumno = new Alumno(dni, rs.getString("NOMBRE"), rs.getString("APELLIDOS"), rs.getString("TELEFONO"), rs.getString("EMAIL"));
                    if(validateAlumno(alumno, password)){
                        return alumno;
                    }
                }
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return null;
    }
    
    private static boolean validateAlumno(Alumno alumno, String password){
        String correctPassword = "";
        String[] apellidosSeparados = alumno.getApellidos().split(" ");
        
        boolean isValid;
        
        try{
            correctPassword += apellidosSeparados[0].substring(0, 3).toLowerCase();
            correctPassword += apellidosSeparados[1].substring(0, 3).toLowerCase();   
            
            isValid = correctPassword.equals(password);
        }catch(IndexOutOfBoundsException e){
            // Formato incorrecto de campo apellidos o
            // Apellido de menos de 3 letras!
            isValid = false;
        }
        
        return isValid;
    }
    
    public static Impartidor loginImpartidor(int id, String password){
        String sql = "SELECT NOMBRE, APELLIDO FROM IMPARTIDORES WHERE ID = ?";
        
        try(
             Connection cn = getConnection();
             PreparedStatement pst = cn.prepareStatement(sql)){

             pst.setInt(1, id);
             try(ResultSet rs = pst.executeQuery()){
                 if(rs.next()){
                     Impartidor impartidor = new Impartidor(id, rs.getString("NOMBRE"), rs.getString("APELLIDO"));
                     if(password.equals(IMARTIDOR_PASSWORD)){
                         return impartidor;
                     }
                 }
             }
         }catch(SQLException e){
             System.err.println(e.getMessage());
         }
       
        return null;
    }
    
    public static ArrayList<Actividad> actividadesImpartidor(Impartidor impartidor){
        String sql = "SELECT ID, NOMBRE, COSTE_MENSUAL FROM ACTIVIDADES WHERE IMPARTIDOR_ID = ?";
        ArrayList<Actividad> vuelta = new ArrayList<Actividad>();
        
        try(
             Connection cn = getConnection();
             PreparedStatement pst = cn.prepareStatement(sql)){

             pst.setInt(1, impartidor.getId());
             try(ResultSet rs = pst.executeQuery()){
                 while(rs.next()){
                     Actividad act = new Actividad(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getFloat("COSTE_MENSUAL"), impartidor);
                     vuelta.add(act);
                 }
             }
         }catch(SQLException e){
             System.err.println(e.getMessage());
         }
        
        return vuelta;
    }
    
    public static ArrayList<Actividad> actividadesParticipa(Alumno alumno){
        String sql = "SELECT ID, NOMBRE, COSTE_MENSUAL, IMPARTIDOR_ID "
                + "FROM ACTIVIDADES "
                + "WHERE ID IN "
                + "(SELECT ACTIVIDAD_ID "
                + "FROM PARTICIPA "
                + "WHERE ALUMNO_DNI = ?)";
        ArrayList<Actividad> vuelta = new ArrayList<Actividad>();
        
        try(
             Connection cn = getConnection();
             PreparedStatement pst = cn.prepareStatement(sql)){

             pst.setString(1, alumno.getDni());
             try(ResultSet rs = pst.executeQuery()){
                 while(rs.next()){
                     Actividad act = new Actividad(
                             rs.getInt("ID"),
                             rs.getString("NOMBRE"),
                             rs.getFloat("COSTE_MENSUAL"),
                              getImpartidorById(rs.getInt("IMPARTIDOR_ID")));
                     vuelta.add(act);
                 }
             }
         }catch(SQLException e){
             System.err.println(e.getMessage());
         }
        System.out.print(vuelta.get(1).getImpartidor());
        return vuelta;
    }
    
    public static ArrayList<Actividad> actividadesLibresNoParticipa(Alumno alumno){
        String sql = "SELECT ID, NOMBRE, COSTE_MENSUAL, IMPARTIDOR_ID "
                + "FROM ACTIVIDADES "
                + "WHERE ID NOT IN "
                + "(SELECT ACTIVIDAD_ID "
                + "FROM PARTICIPA "
                + "WHERE ALUMNO_DNI = ?) "
                + "AND CAPACIDAD != 0";
        ArrayList<Actividad> vuelta = new ArrayList<Actividad>();
        
        try(
             Connection cn = getConnection();
             PreparedStatement pst = cn.prepareStatement(sql)){

             pst.setString(1, alumno.getDni());
             try(ResultSet rs = pst.executeQuery()){
                 while(rs.next()){
                     
                     Actividad act = new Actividad(
                             rs.getInt("ID"),
                             rs.getString("NOMBRE"),
                             rs.getFloat("COSTE_MENSUAL"),
                             getImpartidorById(rs.getInt("IMPARTIDOR_ID")));
                     vuelta.add(act);
                 }
             }
         }catch(SQLException e){
             System.err.println(e.getMessage());
         }
        
        return vuelta;
    }
    
    private static Impartidor getImpartidorById(int id){
         String sql = "SELECT NOMBRE, APELLIDO FROM IMPARTIDORES WHERE ID = ?";
         try(
             Connection cn = getConnection();
             PreparedStatement pst = cn.prepareStatement(sql)){

             pst.setInt(1, id);
             try(ResultSet rs = pst.executeQuery()){
                 if(rs.next()){
                     Impartidor impartidor = new Impartidor(id, rs.getString("NOMBRE"), rs.getString("APELLIDO"));
                     return impartidor;
                 }
             }
         }catch(SQLException e){
             System.err.println(e.getMessage());
         }
         return null;
    }
    
    public static void inscribir(Alumno a, ArrayList<Integer> actividades){
        String sql = "INSERT INTO PARTICIPA (ACTIVIDAD_ID, ALUMNO_DNI, ULTIMA_ASISTENCIA) VALUES (?, ?, null)";
        try(
            Connection cn = getConnection();
            PreparedStatement pst = cn.prepareStatement(sql)){
            
            for(int id: actividades){
                pst.setInt(1, id);
                pst.setString(2, a.getDni());
                
                pst.executeUpdate();
            }
         }catch(SQLException e){
             System.err.println(e.getMessage());
         }
    }
    
    public static HashMap<Alumno, Date> mapaAsistenciaActividad(int idActividad){
        String sql = "SELECT DNI, NOMBRE, APELLIDOS, TELEFONO, EMAIL, ULTIMA_ASISTENCIA "
                + "FROM ALUMNOS, PARTICIPA "
                + "WHERE DNI = ALUMNO_DNI "
                + "AND ACTIVIDAD_ID = ?";
        
        HashMap<Alumno, Date>  vuelta = new HashMap<Alumno, Date> ();
        try(
            Connection cn = getConnection();
            PreparedStatement pst = cn.prepareStatement(sql)){
            
            pst.setInt(1, idActividad);
            
            try(ResultSet rs = pst.executeQuery()){
                while(rs.next()){
                    Alumno alumno = new Alumno(
                            rs.getString("DNI"),
                            rs.getString("NOMBRE"), 
                            rs.getString("APELLIDOS"), 
                            rs.getString("TELEFONO"), 
                            rs.getString("EMAIL"));
                    if(rs.getTimestamp("ULTIMA_ASISTENCIA") == null){
                         vuelta.put(alumno, null);
                    }else{
                        vuelta.put(alumno, new Date(rs.getTimestamp("ULTIMA_ASISTENCIA").getTime()));
                    }
                }
             }
            
         }catch(SQLException e){
             System.err.println(e.getMessage());
         }
        return vuelta;
    }
}
