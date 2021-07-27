
package dominio;

import java.util.Scanner;

public class Cuenta {
    private int nroCuenta;
    private double saldoCuenta;
    static Scanner entrada = new Scanner(System.in);

    public Cuenta(int nroCuenta, double saldoCuenta) {
        this.nroCuenta = nroCuenta;
        this.saldoCuenta = saldoCuenta;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }
    
    public void depositar(double cantidad){
        saldoCuenta+=cantidad;
    }
    
    public void retirar(double cantidad){
        saldoCuenta-=cantidad;
    }
}
