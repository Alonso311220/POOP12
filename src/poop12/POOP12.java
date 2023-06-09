/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poop12;

/**
 * Clase principal que nos ayuda a observar como los hilos que creamos 
 * entran en una condición de carrera, no importa si se crean primero, se ejecutan al mismo
 * tiempo y compiten para poder imprimir a pantalla algún mensaje.
 * @author poo08alu04
 */
public class POOP12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Inicia hilo Principal");
        /*new Hilo("Primer hilo").start();
        new Hilo("Segundo hilo").start();
        new Hilo("Tercer hilo").start();*/
        
        //investigar seccion critica y muttex (exclusion mutua) y waitwall
        //idiom: llamar a ciertas cosas
        new Thread(new HiloR(), "Primer HiloR").start();
        new Thread(new HiloR(), "Segundo HiloR").start();
        /**
         * Aunque se creen nuevos hilos, estos mismos entran en una condición de carrera
         */
        System.out.println("######Actividad extra#######");
        new Cuenta("Acceso 1").start();
        new Cuenta("Acceso 2").start();
        new Cuenta("Deposito 1").start();
        new Cuenta("Deposito 2").start();
        System.out.println("Termina el hilo principal");
    }
    
}
