package beans;

public class Telefonomovil {
	
	private String numero;
	private int bateria;
	
	public Telefonomovil(String numero,int bateria){
		this.numero=numero;
		this.bateria=bateria;
	}	
	public void usar(){		
		this.bateria--;
	}
	
	public int getBateria(){
		return this.bateria;
	}
        public String getNumero() {
            return numero;
        }
}
