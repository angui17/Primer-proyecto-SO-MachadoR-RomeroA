
package proyecto.so;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Process implements Runnable {
    
    private int id;
    private Semaphore semaphore;

    public Process(int id, Semaphore semaphore){
        this.id = id;
        this.semaphore = semaphore;
    }
    
    @Override //Es el código que va a ejecutar el hilo.

    public void run(){
        try {
            System.out.println("Hilo " + id + " está esperando en la cola");
            semaphore.acquire(); //Avisar a los demás hilos que van a entrar en la sección crítica.
            System.out.println("Hilo " + id + " está en ejecución");
            Thread.sleep(2000);
            System.out.println("Hilo " + id + " sale de ejecución");
            semaphore.release(); //Avisar a los demás hilos que sales de la sección crítica.
        } catch (InterruptedException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
