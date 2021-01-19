package beans;
public class Empresa {
	private String nombre;
	private double beneficio;
        private Trabajador[] trabajadores;
        private int cantTrab;        
    
	public Empresa(String nombre,double beneficio, int maxtrab){
		this.nombre=nombre;
		this.beneficio=beneficio;	
                trabajadores=new Trabajador[maxtrab];
                cantTrab=0;
	}
	
	public boolean contratar(Trabajador t){            
            if (cantTrab==trabajadores.length)
                return false;
            else{
                trabajadores[cantTrab]=t;
                cantTrab++;
                return true;
            }                
        }
	
	public void trabajar(){
                for (int i=0; i < cantTrab; i++)
                    trabajadores[i].trabajar();	
		this.beneficio+=100;
	}

        public String getNombre() {
            return nombre;
        }
        public double getBeneficio() {
            return beneficio;
        }
        public Trabajador[] getTrabajadores() {
            return trabajadores;
        }
        public int getCantTrab() {
            return cantTrab;
        }   
}
