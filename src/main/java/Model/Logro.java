package Model;

public class Logro {
    private String titulo;
    private Bimestre bimestre;
    private Boolean completado;

    public Logro(String titulo, int bimestre, int year){
        this.titulo = titulo;
        this.bimestre = new Bimestre(bimestre, year);
        this.completado = false;
    }

    public Logro(String titulo, int bimestre, int year, boolean completado){
        this.titulo = titulo;
        this.bimestre = new Bimestre(bimestre, year);
        this.completado = completado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBimestre() {
        return bimestre.toString();
    }

    public void setBimestre(int bimestre, int year){
        this.bimestre.setBimestre(bimestre);
        this.bimestre.setYear(year);
    }

    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }
}
