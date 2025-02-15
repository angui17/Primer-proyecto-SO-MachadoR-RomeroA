package proyecto.so;

import EDD.Queue;
import java.util.concurrent.Semaphore;
import planifications.FCFS;


public class Main {

    
    public static void main(String[] args) {
    
        
        /*PRUEBA DE PLANIFICACIÓN FCFS.
        Queue queue = new Queue();
        FCFS planificador = new FCFS(queue);

        // Agregar procesos con nombre, instrucciones y si es CPU-Bound
        planificador.addProcess(new Proceso("P1", 5, true, new Semaphore(1)));
        planificador.addProcess(new Proceso("P2", 3, false, new Semaphore(1)));
        planificador.addProcess(new Proceso("P3", 7, true, new Semaphore(1)));

        // Ejecutar FCFS
        planificador.run();*/
        
        //PRUEBA DE SEMAFOROS E HILOS
        Semaphore semaphore = new Semaphore(2);
        
        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(new Proceso("P"+(i+1),4,true,semaphore));
            t.start();
        }
        
        
        /*PRUEBA DE PLANIFICACIÓN ROUND ROBIN
        int[] tiempos = {10, 5, 8}; // Definir los tiempos de los procesos
        RoundRobin rr = new RoundRobin(3, 4, tiempos); // Crear el objeto correctamente
        rr.runRR(); */
    }  
}
