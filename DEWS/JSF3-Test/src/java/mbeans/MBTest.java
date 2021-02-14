package mbeans;

import beans.Pregunta;
import java.util.ArrayList;

public class MBTest {
    private Pregunta[] preguntas;
    private int i;
    private String[] respuestas;
    private int aciertos, respondidas;
    private int numPreguntas;
    private ArrayList<Pregunta> preguntasElegidas;
    private boolean empezado;

    public MBTest() {
        preguntas = new Pregunta[4];
        preguntas[0] = new Pregunta("Capital de Rusia", "Moscú");
        preguntas[1] = new Pregunta("Capital de Italia", "Roma");
        preguntas[2] = new Pregunta("Capital de Francia", "París");
        preguntas[3] = new Pregunta("Capital de Holanda", "Amsterdam");
        
        respuestas = new String[]{"","","",""};
        i = 0;
        aciertos = 0;
        respondidas = 0;
        numPreguntas = 0;
        preguntasElegidas = new ArrayList<>();
        empezado = false;
    }
    
    public Pregunta[] pregsAleatorias(int cant){
        Pregunta[] pregs = new Pregunta[cant];
        ArrayList<Pregunta> alPregs = new ArrayList();
        int i;
        
        do{
            i = (int)(Math.floor(Math.random()*preguntas.length));
            if(!alPregs.contains(preguntas[i]))
                alPregs.add(preguntas[i]);
            
        } while(alPregs.size()<cant);
        
        return pregs;
    }
    
    public void mostrar(){
        empezado = true;
    }
    
    public int[] elecciones(){
        int[] e = new int[preguntas.length];
        
        for(int i=0;i<preguntas.length;i++){
            e[i] = i+1;
        }
        
        return e;
    }
    
    public Pregunta preguntaActual(){
        Pregunta preg = preguntas[i];
        
        return preg;
    }
    
    public void siguiente(){
        Pregunta p = preguntaActual();
        if(p.getRptaOK().equalsIgnoreCase(p.getRptaUsuario())){
            respuestas[i] = p.getPregunta()+": "+p.getRptaOK()+" OK";
            aciertos++;
        }
        else{
            respuestas[i] = p.getPregunta()+": "+p.getRptaUsuario()+" "+p.getRptaOK();
        }
        
        respondidas++;
        
        if(i<preguntas.length-1){
            i++;
        }
    }
    
    public boolean terminado(){
        if(respondidas==respuestas.length)
            return true;
        return false;
    }
    
    public String resultados(){
        return "rtdotest";
    }

    public Pregunta[] getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Pregunta[] preguntas) {
        this.preguntas = preguntas;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getRespondidas() {
        return respondidas;
    }

    public void setRespondidas(int respondidas) {
        this.respondidas = respondidas;
    }

    public int getNumPreguntas() {
        return numPreguntas;
    }

    public void setNumPreguntas(int numPreguntas) {
        this.numPreguntas = numPreguntas;
    }

    public ArrayList<Pregunta> getPreguntasElegidas() {
        return preguntasElegidas;
    }

    public void setPreguntasElegidas(ArrayList<Pregunta> preguntasElegidas) {
        this.preguntasElegidas = preguntasElegidas;
    }

    public boolean isEmpezado() {
        return empezado;
    }

    public void setEmpezado(boolean empezado) {
        this.empezado = empezado;
    }
    
    
}