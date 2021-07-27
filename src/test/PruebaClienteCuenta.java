package test;

import dominio.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PruebaClienteCuenta {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        int op, ncuentas, nc, indice;
        double dinero;
        Cliente c1=null;
        Cuenta cuentas[]=null;
        for (int i;;) {
            System.out.print("**Menú de Banco**"
                    + "\n1. Crear Cliente"
                    + "\n2. Asignar Cuenta/s"
                    + "\n3. Depositar"
                    + "\n4. Retirar"
                    + "\n5. Consultar Saldo"
                    + "\n6. Salir"
                    + "\nDigite una Opción: ");
            op = entrada.nextInt();
            System.out.println("\n");
            if (op == 6) {
                System.out.println("Usted a seleccionado Salir");
                Thread.sleep(500);
                System.out.println("Gracias por preferirnos");
                break;
            } else {
                if(op==1){
                    entrada.nextLine();
                        String nombre,cedula;
                        System.out.println("Usted a seleccionado Crear Cliente");
                        Thread.sleep(500);
                        System.out.print("Espere");
                        Thread.sleep(500);
                        System.out.print(" un");
                        Thread.sleep(500);
                        System.out.print(" momento");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.println(".");
                        System.out.print("Cédula del Cliente: ");
                        cedula = entrada.nextLine();
                        System.out.print("Nombre del Cliente: ");
                        nombre = entrada.nextLine();
                        System.out.print("Nro de cuentas que desea abrir el Cliente " +nombre.toUpperCase()+ ": ");
                        ncuentas = entrada.nextInt();
                        cuentas = new Cuenta[ncuentas];
                        ingresarCuentas(cuentas);
                        c1 = new Cliente(cedula, nombre, cuentas);
                        System.out.println("\n");
                } else {
                    if(op==2){
                        entrada.nextLine();
                        System.out.println("Usted a seleccionado Asignar Cuenta/s");
                        Thread.sleep(500);
                        System.out.print("Espere");
                        Thread.sleep(500);
                        System.out.print(" un");
                        Thread.sleep(500);
                        System.out.print(" momento");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.println(".");
                        System.out.println("**Asignación de Cuentas**");
                        c1.DetalleCuenta(cuentas);
                    }else{
                        if(op==3){
                            entrada.nextLine();
                        System.out.println("Usted a seleccionado Depositar");
                        Thread.sleep(500);
                        System.out.print("Espere");
                        Thread.sleep(500);
                        System.out.print(" un");
                        Thread.sleep(500);
                        System.out.print(" momento");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.println(".");
                        System.out.print("Ingrese Nro de Cuenta al que desea depositar: ");
                        nc = entrada.nextInt();
                        indice = indice(cuentas, nc);
                        if (indice < 0) {
                            System.out.println("Nro de cuenta no encontrado");
                        } else {
                            System.out.print("Ingrese la cantidad a depositar: $");
                            dinero = entrada.nextDouble();
                            c1.ingresarDinero(indice, dinero);
                            System.out.println("Su saldo actual es: $" + c1.consultarSaldo(indice));
                            System.out.println("\n");
                        }
                        }else{
                            if(op==4){
                                entrada.nextLine();
                        System.out.println("Usted a seleccionado Retirar");
                        Thread.sleep(500);
                        System.out.print("Espere");
                        Thread.sleep(500);
                        System.out.print(" un");
                        Thread.sleep(500);
                        System.out.print(" momento");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.println(".");
                        System.out.print("Ingrese el Nro de Cuenta para realizar el retiro: ");
                        nc = entrada.nextInt();
                        indice = indice(cuentas, nc);
                        if (indice < 0) {
                            System.out.println("Nro de cuenta no encontrado");
                        } else {
                            System.out.print("Ingrese la cantidad a retirar: ");
                            dinero = entrada.nextDouble();
                            c1.retirarDinero(indice, dinero);
                            System.out.println("Dinero retirado");
                            System.out.println("Su Saldo Actual es:  "+ c1.consultarSaldo(indice));
                            System.out.println("\n");
                        }
                            }else{
                                if(op==5){
                                    entrada.nextLine();
                        System.out.println("Usted a seleccionado Consultar Saldo");
                        Thread.sleep(500);
                        System.out.print("Espere");
                        Thread.sleep(500);
                        System.out.print(" un");
                        Thread.sleep(500);
                        System.out.print(" momento");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.println(".");
                        System.out.print("Ingrese el Nro de Cuenta a Consultar: ");
                        nc = entrada.nextInt();
                        indice = indice(cuentas, nc);
                        if (indice < 0) {
                            System.out.println("Nro de cuenta no encontrado ");
                        } else {
                            c1.consultarSaldo(indice);
                            System.out.println("El Saldo de la cuenta ingresada es: $" + c1.consultarSaldo(indice));
                            System.out.println("\n");
                        }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static int indice(Cuenta c[], int nc) {
        int indice = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i].getNroCuenta() == nc) {
                indice = i;
                break;
            } else {
                indice = -1;
            }
        }
        return indice;
    }

    public static void ingresarCuentas(Cuenta[] c) {
        Scanner entrada = new Scanner(System.in);
        int nrcuenta;
        double saldo;
        for (int i = 0; i < c.length; i++) {
            System.out.println("Datos de la Cuenta N° " + (i + 1));
            System.out.print("Nro de Cuenta: ");
            nrcuenta = entrada.nextInt();
            System.out.print("Saldo de cuenta: $");
            saldo = entrada.nextDouble();
            c[i] = new Cuenta(nrcuenta, saldo);
        }
    }
    
}
