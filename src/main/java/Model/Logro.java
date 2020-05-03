package Model;

public class Logro {
    private String titulo, estado, descripcion;
    private Bimestre bimestre;
    private Boolean completado;

    public Logro(){
        
    }
    
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
    
    public void setAll(String titulo, int bimestre, int year, String estado, String descripcion){
        this.titulo = titulo;
        this.bimestre = new Bimestre(bimestre, year);
        this.estado = estado;
        this.descripcion = descripcion;
        completado = (estado.equals("Logrado"));
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Bimestre getBimestre(){
        return bimestre;
    }

    public String getBimestreString() {
        return bimestre.toString();
    }

    public void setBimestre(int bimestre, int year){
        this.bimestre.setBimestre(bimestre);
        this.bimestre.setYear(year);
    }

    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }

    public Boolean isCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
