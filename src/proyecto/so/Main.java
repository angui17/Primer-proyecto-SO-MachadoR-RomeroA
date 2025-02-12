package proyecto.so;

import proyecto.so.planifications.RoundRobin;
import java.util.concurrent.Semaphore;


public class Main {

    
    public static void main(String[] args) {
    
        
        //PRUEBA DE SEMAFOROS E HILOS
        Semaphore semaphore = new Semaphore(2);
        
        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(new Process(i,semaphore));
            t.start();
        }
        
        
        //PRUEBA DE PLANIFICACIÓN ROUND ROBIN
        int[] tiempos = {10, 5, 8}; // Definir los tiempos de los procesos
        RoundRobin rr = new RoundRobin(3, 4, tiempos); // Crear el objeto correctamente
        rr.runRR(); 
    }  
}
