/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author dw2
 */
public class ConversionCF {
    private float celsius, fahrenheit;
    public ConversionCF (float temperatura, char tipo) {
        if(tipo=='c'){
            celsius=temperatura;
            fahrenheit=temperatura*9/5+32;
        }
        else if(tipo=='f'){
            fahrenheit=temperatura;
            celsius=(temperatura-32)*5/9;
        }
    }

    public float getCelsius() {
        return celsius;
    }

    public float getFahrenheit() {
        return fahrenheit;
    }
    
}
