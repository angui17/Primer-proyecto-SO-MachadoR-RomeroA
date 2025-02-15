package planifications;
import EDD.Node;
import EDD.Queue;
import java.util.concurrent.Semaphore;
import proyecto.so.Proceso;


public class FCFS {
    
    private Queue queue;
    private Semaphore semaphore;

    public FCFS(Queue queue) {
        this.queue = queue;
        this.semaphore = new Semaphore(1); //Solo un proceso puede ejecutar el CPU a la vez.
    }
    
    public void addProcess(Proceso proceso){
        proceso.setSemaphore(semaphore);
        Node newnode = new Node(proceso);
        queue.enqueue(newnode);
        
    }
    
    public void run(){
        while(!queue.isEmpty()){
            Proceso p = queue.dequeue().getProceso();
            Thread thread = new Thread(p);
            thread.start();
            try {
                thread.join(); // Espera a que el proceso termine antes de continuar
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Todos los procesos han finalizado.");
    }
}
