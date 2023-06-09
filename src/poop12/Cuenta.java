/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop12;

/**
 * Clase cuenta que hereda de Thread donde dos hilos de Deposito y dos hilos 
 * de Retiro entran en una condición de carrera para modificar el saldo
 * @author alons
 */
public class Cuenta extends Thread{
    private static long saldo = 0;

    public Cuenta(String name) {
        super(name);
    }
    /**
     * Método donde provoca que los hilos entren en una condición de carrera 
     * donde si se llaman Deposito 1 o Deposito 2 realizan un depósito de 50
     * pero si se llaman Acceso 1 o Acceso 2 realizan un retiro de 50
     */
    public void run() {
        if (getName().equals("Deposito 1") || 
                getName().equals("Deposito 2")) {
            this.depositarDinero(50);
        } else {
            this.extraerDinero(50);
        }
        System.out.println("Termina el " + getName()); 
    }
    /**
     * @param cantidad (50) que se suma al saldo 
     */
    public synchronized void depositarDinero(int cantidad) {
        saldo += cantidad;
            System.out.println("Se depositaron "+ cantidad + "pesos");
            notifyAll();
    }
    /**
     * @param cantidad que son 50 pesos para extraer, es decir, al saldo que teniamos 
     * se le restan 50 pero si no hay saldo o el saldo es negativo se espera a que un hilo 
     * realice un depósito para poder extraer dinero
     */
    public synchronized void extraerDinero(int cantidad){
        try{
            if(saldo <= 0){
                System.out.println(getName()+" espera deposito"+"\nSaldo= "+saldo);
                sleep(5000);
            }
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        saldo -= cantidad;
        System.out.println(getName()+" extrajo "+cantidad+
                " pesos.\nSaldo restante = "+ saldo);
        notifyAll();
    }
}
