package beans;

public class Pregunta {
    private String pregunta, rptaOK, rptaUsuario;

    public Pregunta() {
    }

    public Pregunta(String pregunta, String rptaOK) {
        this.pregunta = pregunta;
        this.rptaOK = rptaOK;
    }

    public Pregunta(String pregunta, String rptaOK, String rptaUsuario) {
        this.pregunta = pregunta;
        this.rptaOK = rptaOK;
        this.rptaUsuario = rptaUsuario;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRptaOK() {
        return rptaOK;
    }

    public void setRptaOK(String rptaOK) {
        this.rptaOK = rptaOK;
    }

    public String getRptaUsuario() {
        return rptaUsuario;
    }

    public void setRptaUsuario(String rptaUsuario) {
        this.rptaUsuario = rptaUsuario;
    }
    
}
