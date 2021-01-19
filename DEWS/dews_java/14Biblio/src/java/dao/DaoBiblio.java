
package dao;

import beans.Libro;
import beans.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DaoBiblio {
    
    
    static PreparedStatement psSelPrest;
    
    static{          
          
            try{
                Connection cn=dameConexionPool(); 
                String sql="select idprestamo, fecha,fechadev from prestamos where idlibro = ?";
                psSelPrest=cn.prepareStatement(sql);
                cierraConexion(cn);
            }
            catch(SQLException e){                
            }
    }
    
    private static Connection dameConexionPool(){
        
        Connection cn=null;
        try {
            InitialContext ctx=new InitialContext();
            DataSource ds=(DataSource)ctx.lookup("jdbc/biblio");
            cn=ds.getConnection();
        
        } catch (NamingException ex) {
            Logger.getLogger(DaoBiblio.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return cn;
        }
    }
    
    
    private static void cierraConexion(Connection cn){
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoBiblio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static ArrayList<Libro> libros(){
        
        ArrayList<Libro> lstLibros=new  ArrayList<Libro>();
        
        
        try{
            Connection cn=dameConexionPool();
            Statement st=cn.createStatement();
            String sql="select idlibro, titulo, paginas, genero, idautor from libros";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){                
                Libro l=new Libro();
                l.setIdlibro(rs.getInt("idlibro"));
                l.setTitulo(rs.getString("titulo"));
                l.setPaginas(rs.getInt("paginas"));
                l.setGenero(rs.getString("genero"));
                l.setIdautor(rs.getInt("idautor"));                        
                lstLibros.add(l);
            }
            cierraConexion(cn);            
        }
        catch (SQLException e){
            System.err.println("Error en metodo libros " + e.getMessage());
        }
        finally{
            return lstLibros;
        }
        
    }
    
    public static HashMap<Integer,ArrayList<Prestamo>> mapaPrestamos(){
       HashMap<Integer,ArrayList<Prestamo>> mapa=new  HashMap<Integer,ArrayList<Prestamo>>();
       ArrayList<Libro> libros=libros();        
        try{
            
             
             for (Libro libro: libros){  
                 ArrayList<Prestamo> prestamos=new   ArrayList<Prestamo>();
                 psSelPrest.setInt(1, libro.getIdlibro());
                 ResultSet rs=psSelPrest.executeQuery();
                 while (rs.next()){
                     int idprestamo=rs.getInt("idprestamo");
                    //Crear fecha java.util a partir de fecha java.sql
                     java.util.Date fecha=new java.util.Date (rs.getDate("fecha").getTime() );
                     java.util.Date fechaDev=null;
                     if (rs.getDate("fechadev")!=null)
                        fechaDev=new java.util.Date (rs.getDate("fechadev").getTime() );
                     Prestamo prestamo=new Prestamo();
                     prestamo.setIdPrestamo(idprestamo);
                     prestamo.setIdLibro(libro.getIdlibro());
                     prestamo.setFecha(fecha);
                     prestamo.setFechaDev(fechaDev);
                     prestamos.add(prestamo);                     
                 }
                 mapa.put(libro.getIdlibro(), prestamos);
                 rs.close();                          
             }             
             
            
        }
        catch (SQLException e){
              System.err.println("Error en metodo mapaPrestamos " + e.getMessage());            
        }
        finally{
            System.err.println(mapa);
            return mapa;
        }
    }
    
    public static HashMap<Integer,Integer> mapCantidadPrestamos(){
        HashMap<Integer,Integer> mapa=new  HashMap<Integer,Integer>();
        ArrayList<Libro> libros=libros();        
        try{
             Connection cn=dameConexionPool();            
             String sql="select count(*) as cuantos from prestamos where idlibro = ?";
             PreparedStatement ps=cn.prepareStatement(sql);
             
             for (Libro libro: libros){                 
                 ps.setInt(1, libro.getIdlibro());
                 ResultSet rs=ps.executeQuery();
                 if (rs.next())
                     mapa.put(libro.getIdlibro(), rs.getInt("cuantos"));
                 rs.close();                          
             }             
             ps.close();
             cierraConexion(cn);
        }
        catch (SQLException e){
              System.err.println("Error en metodo mapCantidadPrestamos " + e.getMessage());            
        }
        finally{
            
            return mapa;
        }
    }

    public static void prestarVariosLibros(int[] ids) {
        
        
        try{
             Connection cn=dameConexionPool();            
             String sql="insert into prestamos (fecha,idlibro,fechadev) "
                     + " values (?,?,?)";
             PreparedStatement ps=cn.prepareStatement(sql);
             
             for (int i=0; i<ids.length; i++){                
                 ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()) );
                 ps.setInt(2, ids[i]);
                 ps.setDate(3, null);
                 ps.executeUpdate();                 
             }
             
             ps.close();
             cierraConexion(cn);
        }
        catch (SQLException e){
              System.err.println("Error en metodo prestarVariosLibros " + e.getMessage());
            
        }
        
        
        
    }
    
}
