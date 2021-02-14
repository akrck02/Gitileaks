package dao;

import beans.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.dbcp2.BasicDataSource;

public class DaoClientes {
    
    private static final BasicDataSource ds=new BasicDataSource();    
    static{
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/bdbus");
        ds.setUsername("root");
        ds.setPassword("");
    }
    
    public static ArrayList<Cliente> todosClientes(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        String sql = "select id_dni, nombre, direccion, email from clientes";
        
         try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql);){
            
            while (rs.next()){
                Cliente c = new Cliente(rs.getString("id_dni"), rs.getString("nombre"), 
                        rs.getString("direccion"), rs.getString("email"));
                
                clientes.add(c);
            }
            
        }
        catch (SQLException e){
            System.err.println("Error en método todosClientes " + e.getMessage() + " sql:" + sql);           
        }
        
        return clientes;
    }
    
    public static boolean existeDni(String dni){
        String sql = "select count(*) as count "
                + "from clientes where id_dni='"+dni+"'";
        
         try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement();   
            ResultSet rs=st.executeQuery(sql);){
            
            rs.next();
            if(rs.getInt("count")!=0){
                return true;
            }
        }
        catch (SQLException e){
            System.err.println("Error en método todosClientes " + e.getMessage() + " sql:" + sql);           
        }

        return false;
    }
    
    public static void registrar(Cliente c){
        String sql = "insert into clientes (id_dni, nombre, direccion, email) "
                + "values ('"+c.getId_dni()+"', '"+c.getNombre()+"', "
                + "'"+c.getDireccion()+"', '"+c.getEmail()+"')";
        
         try(Connection cn=ds.getConnection();
            Statement st=cn.createStatement()){
            
            st.executeUpdate(sql);
            
        }
        catch (SQLException e){
            System.err.println("Error en método registrar " + e.getMessage() + " sql:" + sql);           
        }
    }

}
