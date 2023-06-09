/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop12;

/**
 * clase HiloR que hereda de la interfaz Runnable (estado run de un hilo)
 * @author poo08alu04
 */
public class HiloR implements Runnable {
    /**
     * Constructor vacío
     */
    public HiloR() {
    }
    
    /**
     * Sobreescritura de run donde dos hilos entran en una condición de carrera 
     * para imprimir primero una iteración 
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Iteracion "+i+Thread.currentThread().getName());
            
        }
        
    System.out.println("Termina el "+Thread.currentThread().getName());
    } 
}
