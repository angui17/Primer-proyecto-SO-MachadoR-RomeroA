
package proyecto.so;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Proceso implements Runnable {
    
    private String name;
    private int instruccions;
    private boolean isCPUBound;
    private PCB pcb;
    private Semaphore semaphore;

    public Proceso(String name, int instruccions, boolean isCPUBound, Semaphore semaphore) {
        this.name = name;
        this.instruccions = instruccions;
        this.isCPUBound = isCPUBound;
        this.pcb = new PCB(name);
        this.semaphore = semaphore;
    }
    
    @Override //Es el código que va a ejecutar el hilo.
    public void run() {
        try {
            System.out.println("Hilo " + pcb.getId() + " (" + name + ") esperando en la cola...");
            semaphore.acquire(); // Intentar entrar en la sección crítica
            
            // Actualizar PCB antes de ejecutar
            pcb.changeStatus("Running");
            System.out.println("Hilo " + pcb.getId() + " en ejecución: " + pcb.getId());
            
            for (int i = 0; i < instruccions; i++) {
                System.out.println("Proceso " + name + " ejecutando instrucción " + (i + 1) + "/" + instruccions);
                Thread.sleep(500); // Simula la ejecución de una instrucción
                pcb.setPC(i + 1);  // Simula la actualización del Program Counter
            }

            // Termina la ejecución
            pcb.changeStatus("Terminated");
            System.out.println("Proceso " + name + " finalizado: " + pcb.getId());

            semaphore.release(); // Salir de la sección crítica
        } catch (InterruptedException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInstruccions() {
        return instruccions;
    }

    public void setInstruccions(int instruccions) {
        this.instruccions = instruccions;
    }

    public boolean isIsCPUBound() {
        return isCPUBound;
    }

    public void setIsCPUBound(boolean isCPUBound) {
        this.isCPUBound = isCPUBound;
    }

    public PCB getPcb() {
        return pcb;
    }

    public void setPcb(PCB pcb) {
        this.pcb = pcb;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    
    
}
