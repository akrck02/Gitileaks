/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import java.util.ArrayList;

/**
 *
 * @author dw2
 */
public class Suma {

    
    private int num1;
    private int num2;
    private int rpta;    
    private ArrayList<String> feedBack;
    
    public Suma() {
        nuevosNumeros();
        feedBack=new ArrayList<String>();
    }
    
    private void nuevosNumeros(){
        num1=1+ (int)(Math.random()* 20);
        num2=1+ (int)(Math.random()* 20);        
    }    
    public String comprobar(){
        String lineaFeedBack=num1 + " + " + num2 + " = " + (num1+num1);
        if (num1+num2==rpta)
            lineaFeedBack+=", OK";
        else
            lineaFeedBack+=", MAL";
        
        feedBack.add(lineaFeedBack);        
        nuevosNumeros();
        return null;        
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getRpta() {
        return rpta;
    }

    public void setRpta(int rpta) {
        this.rpta = rpta;
    }

    public ArrayList<String> getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(ArrayList<String> feedBack) {
        this.feedBack = feedBack;
    }
    
    
}
