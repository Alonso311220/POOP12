/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop12;

/**
 * Clase Hilo que hereda de la clase Thread 
 * @author poo08alu04
 */
public class Hilo extends Thread {
    /**
     * @param name que asigna un nombre al hilo con ayuda de su clase padre 
     */
    public Hilo(String name) {
        super(name);
    }
    /**
     * Sobreescritura del método run donde entran dos hilos 
     * en una condición de carrera para imprimir iteración de 
     * un ciclo for del 0 al 9
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("Iteracion "+i+" de "+getName());
        }
        System.out.println("Termina el hilo "+getName());
    }
 
}
