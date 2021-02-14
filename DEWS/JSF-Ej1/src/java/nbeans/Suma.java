package nbeans;

public class Suma {
    
    private int numAleatorio1, numAleatorio2, resultUsuario;
    private String resultados;

    public Suma() {
        numAleatorio1 = creaNumAleatorio();
        numAleatorio2 = creaNumAleatorio();
        resultUsuario = 0;
        resultados = "";
    }
    
    private int creaNumAleatorio(){
        int resp = (int)(Math.random()*100+1);
        
        return resp;
    }
    
    public void sumar(){
        
        if(numAleatorio1+numAleatorio2==resultUsuario){
            resultados += numAleatorio1+" + "+numAleatorio2+" = "+resultUsuario+""
                    + " BIEN ";
        }
        else{
            resultados += numAleatorio1+" + "+numAleatorio2+" = "+resultUsuario+""
                    + " MAL ";
        }
        
        System.out.println(resultados);
    }

    public int getNumAleatorio1() {
        return numAleatorio1;
    }

    public void setNumAleatorio1(int numAleatorio1) {
        this.numAleatorio1 = numAleatorio1;
    }

    public int getNumAleatorio2() {
        return numAleatorio2;
    }

    public void setNumAleatorio2(int numAleatorio2) {
        this.numAleatorio2 = numAleatorio2;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public int getResultUsuario() {
        return resultUsuario;
    }

    public void setResultUsuario(int resultUsuario) {
        this.resultUsuario = resultUsuario;
    }
}
