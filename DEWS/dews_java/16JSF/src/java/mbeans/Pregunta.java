
package mbeans;


public class Pregunta {
    private final static int TOPE_INTENTOS=3;
    
    private String enunciado;
    private int rptaCorrecta;
    private int rptaUsuario;    
    private String feedBack;
    
    private int intentos;
    
    
   
            
            
    public Pregunta() {
        this.enunciado="Raiz de 25?";
        this.rptaCorrecta=(int)Math.sqrt(25);
        this.feedBack="";
        this.intentos=0;
    }

    public String comprobar(){
        //Al llegar aqui, ya se ha hecho set de rptaUsuario
        /*
        if (rptaUsuario==rptaCorrecta)
            return "congratulations";
        else
            return null;  //Permanece en la vista
        */
        
         if (rptaUsuario==rptaCorrecta){
             feedBack="Eres un genio";
             return "resultado";
         }
         else{
             intentos++;
             if (intentos==TOPE_INTENTOS){
                 feedBack="Has agotado intentos";
                 return "resultado";
             }
         }
        
        return null;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    
    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }
    
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getRptaCorrecta() {
        return rptaCorrecta;
    }

    public void setRptaCorrecta(int rptaCorrecta) {
        this.rptaCorrecta = rptaCorrecta;
    }

    public int getRptaUsuario() {
        return rptaUsuario;
    }

    public void setRptaUsuario(int rptaUsuario) {
        this.rptaUsuario = rptaUsuario;
    }

    public static int getTOPE_INTENTOS() {
        return TOPE_INTENTOS;
    }
    
    
    
}
