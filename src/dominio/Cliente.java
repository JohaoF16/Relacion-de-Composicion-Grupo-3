
package dominio;

public class Cliente {
    private String cedula;
    private String nombre;
    private Cuenta cuentas[];

    public Cliente(String cedula, String nombre, Cuenta[] cuentas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.cuentas = cuentas;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }
    
    public double consultarSaldo(int nroCuenta){
        return cuentas[nroCuenta].getSaldoCuenta();
    }
    
    public void ingresarDinero(int nroCuenta, double dinero){
        cuentas[nroCuenta].depositar(dinero);
    }
    
    public void retirarDinero(int nroCuenta, double dinero){
        cuentas[nroCuenta].retirar(dinero);
    }
    
    public void DetalleCuenta(Cuenta[] c){
        System.out.print("Nombre: "+nombre.toUpperCase()+"\nCedula: "+cedula);
        double saldoTotal=0;
        for(int i=0;i<c.length;i++){
            System.out.print("\nNro de Cuenta: "+c[i].getNroCuenta()+"\nSaldo: $"+c[i].getSaldoCuenta());
            saldoTotal+=c[i].getSaldoCuenta();
        }
        System.out.print("\nSaldo Total de las Cuentas: $"+saldoTotal);
        System.out.println("\n");
    }
}
