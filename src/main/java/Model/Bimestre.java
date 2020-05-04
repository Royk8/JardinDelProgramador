package Model;

/**
 * Clase Usada para manejar el sistema de bimestres
 * Se compone de un String con los meses del bimestre
 * Un año almacenado en una variable entera
 * Un numero del bimestre en el año
 * @author Royk
 */
public class Bimestre {
    private String bimestre;
    private int year;
    private int numBimestre;

    /**
     * Constructor que recive el bimestre, año y crea el string con los meses del bimestre
     * @param numBimestre numero del bimestre en el año
     * @param year Entero con el año
     */
    public Bimestre( int numBimestre, int year){
        this.year = year;
        this.numBimestre = numBimestre;
        bimestre = toBimestre(numBimestre);
    }

    /**
     * Recibe un entero que representa el bimestre del anno
     * Genera un String con los nombres de los meses.
     * @param numBimestre Entero con el bimestre del anno
     * @return String con el nombre del bimestre.
     */
    private String toBimestre(int numBimestre){
        switch (numBimestre){
            case 1:
                return "Ene-Feb";
            case 2:
                return "Mar-Abr";
            case 3:
                return "May-Jun";
            case 4:
                return "Jul-Ago";
            case 5:
                return "Sep-Oct";
            case 6:
                return "Nov-Dic";
            default:
                return "Bimestre Invalido";
        }
    }

    /**
     * Retorna un string con el bimestre y el año
     * @return String con bimestre y año concatenados
     */
    public String toString(){
        return bimestre + " " + year;
    }

    /**
     * Getter
     * @return Entero con el año 
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter
     * @param year Entero con el año 
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Getter
     * @return Entero con el bimestre 
     */
    public int getNumBimestre() {
        return numBimestre;
    }

    /**
     * Setter
     * @param numBimestre Entero con el bimestre 
     */
    public void setNumBimestre(int numBimestre) {
        this.numBimestre = numBimestre;
    }

    /**
     * Getter
     * @return String con el bimestre 
     */
    public String getBimestre(){
        return bimestre;
    }

    /**
     * Setter que recibe el numero del bimestre y lo remplaza en el String con los meses
     * @param numBimestre Numero del bimestre
     */
    public void setBimestre(int numBimestre){
        bimestre = toBimestre(numBimestre);
    }
}
