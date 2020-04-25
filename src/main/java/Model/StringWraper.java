/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Royk
 */
public class StringWraper {
    private String str;
    
    public StringWraper(String str){
        this.str = str;
    }

    public String ToString() {
        return str;
    }

    public void setText(String str) {
        this.str = str;
    }
    
    
}
