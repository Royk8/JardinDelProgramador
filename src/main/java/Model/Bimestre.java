package Model;

public class Bimestre {
    private String bimestre;
    private int year;
    private int numBimestre;

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

    public String toString(){
        return bimestre + " " + year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumBimestre() {
        return numBimestre;
    }

    public void setNumBimestre(int numBimestre) {
        this.numBimestre = numBimestre;
    }

    public String getBimestre(){
        return bimestre;
    }

    public void setBimestre(int numBimestre){
        bimestre = toBimestre(numBimestre);
    }
}
