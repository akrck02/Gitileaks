/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


public class Cuenta {
    private String titular;
    private float saldo;

    public Cuenta(String titular, float saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public void ingresar(float cantidad){
        saldo+=cantidad;
        System.err.println("ingresando " + cantidad);
                
    }
    
    public boolean gastar(float cantidad){
        if (cantidad > saldo)
            return false;
        else{
            saldo-=cantidad;
            return true;
        }
    }
    
}
