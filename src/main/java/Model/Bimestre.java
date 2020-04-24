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
            case 1: case 2:
                return "Ene-Feb";
            case 3: case 4:
                return "Mar-Abr";
            case 5: case 6:
                return "May-Jun";
            case 7: case 8:
                return "Jul-Ago";
            case 9: case 10:
                return "Sep-Oct";
            case 11: case 12:
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
