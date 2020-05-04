package Model;

/**
 * Modelo de logro, contiene un String de titulo para el logro, String para el estado,
 * Striing para la descripcion, un Objeto de la clase bimestre, y un booleano que indica si esta completo o no
 * @author Royk
 */
public class Logro {
    private String titulo, estado, descripcion;
    private Bimestre bimestre;
    private Boolean completado;

    /**
     * Constructor vacio
     */
    public Logro(){
        
    }
    
    /**
     * Constructor asigna falso al booleano de completado y crea un objeto de la clase bimestre
     * @param titulo Recibe un String con el titulo del logro
     * @param bimestre Entero con el numero del bimestre
     * @param year Entero con el año correspondiente al logro
     */
    public Logro(String titulo, int bimestre, int year){
        this.titulo = titulo;
        this.bimestre = new Bimestre(bimestre, year);
        this.completado = false;
    }
    
    /**
     * Setter completo que asigna un valor a cada atributo de la clase
     * @param titulo Recibe un String con el titulo del logro
     * @param bimestre Entero con el numero del bimestre
     * @param year Entero con el año correspondiente al logro
     * @param estado String con el estado actual del logro
     * @param descripcion String con la descripcion detallada del logro
     */
    public void setAll(String titulo, int bimestre, int year, String estado, String descripcion){
        this.titulo = titulo;
        this.bimestre = new Bimestre(bimestre, year);
        this.estado = estado;
        this.descripcion = descripcion;
        completado = (estado.equals("Logrado"));
    }

    /**
     * Getter del titulo
     * @return String con el titulo asociado al logro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter del titulo
     * @param titulo String con el nuevo titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
     * Getter del bimestre
     * @return Objeto de la clase bimestre asociado al logro
     */
    public Bimestre getBimestre(){
        return bimestre;
    }

    /**
     * Getter del bimestre en forma de string
     * @return String con los meses que conforman el bimestre
     */
    public String getBimestreString() {
        return bimestre.toString();
    }

    /**
     * Setter del bimestre
     * @param bimestre Entero con el bimestre
     * @param year Entero con el año
     */
    public void setBimestre(int bimestre, int year){
        this.bimestre.setBimestre(bimestre);
        this.bimestre.setYear(year);
    }

    /**
     * Setter del bimestre
     * @param bimestre Objeto de la clase bimestre
     */
    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }

    /**
     * Getter del booleano completado
     * @return Devuelve true si el logro esta completado
     */
    public Boolean isCompletado() {
        return completado;
    }

    /**
     * Setter del atributo completado
     * @param completado Booleano a asignar a completado
     */
    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    /**
     * Getter del Estado del logro
     * @return String con el estado del logro
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Setter del estado del logro
     * @param estado String con el estado del logro
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Getter de la descripcion del logro
     * @return String con la descripcion del logro
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de la descripcion del logro
     * @param descripcion String con la nueva descripcion del logro
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
