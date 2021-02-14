package mbeans;

import beans.Cliente;
import dao.DaoClientes;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class MBClientes {
    private ArrayList<Cliente> todosClientes;
    private Cliente cliente;
    
    public String registrar(){
        DaoClientes.registrar(cliente);
        return "registrado";
    }

    public MBClientes() {
        todosClientes = DaoClientes.todosClientes();
        cliente = new Cliente();
    }

    public ArrayList<Cliente> getTodosClientes() {
        return todosClientes;
    }

    public void setTodosClientes(ArrayList<Cliente> todosClientes) {
        this.todosClientes = todosClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
