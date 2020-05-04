/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Clase auxiliar para pasar String por referencia
 * Contiene un objeto de la clase String
 * @author Royk
 */
public class StringWraper {
    private String str;
    
    /**
     * Constructor basico
     * @param str String a almacenar
     */
    public StringWraper(String str){
        this.str = str;
    }

    /**
     * Getter del string almacenado
     * @return String almacenado
     */
    @Override
    public String toString() {
        return str;
    }

    /**
     * Setter del string almacenado
     * @param str String almacenado
     */
    public void setText(String str) {
        this.str = str;
    }    
}
