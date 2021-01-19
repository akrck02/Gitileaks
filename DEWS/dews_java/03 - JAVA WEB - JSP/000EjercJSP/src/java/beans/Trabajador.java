package beans;

public class Trabajador extends Persona{
	
	private double dinero;
	private Telefonomovil movil;
	
	public Trabajador(String nombre,String dni,Telefonomovil movil){
		
		super(nombre,dni);
		this.dinero=0;
		this.movil=movil;
	}	
	public void ganarDinero(double cant){
		this.dinero+=cant;
	}
	public void gastarDinero(double cant){
		
            if (cant>=dinero)
                this.dinero-=cant;
	}
	public void trabajar(){		
		this.movil.usar();
		this.dinero+=10;
	}
        public double getDinero() {
            return dinero;
        }
        public Telefonomovil getMovil() {
            return movil;
        }
}
