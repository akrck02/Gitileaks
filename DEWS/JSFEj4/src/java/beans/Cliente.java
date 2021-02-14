package beans;

public class Cliente {

    private String id_dni, nombre, direccion, email;

    public Cliente() {
    }

    public Cliente(String id_dni, String nombre, String direccion, String email) {
        this.id_dni = id_dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
    }

    public String getId_dni() {
        return id_dni;
    }

    public void setId_dni(String id_dni) {
        this.id_dni = id_dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    

}
