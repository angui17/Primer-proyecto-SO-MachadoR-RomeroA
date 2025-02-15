
package proyecto.so;

import java.util.concurrent.atomic.AtomicInteger;


public class PCB {
    
    private static final AtomicInteger contadorID = new AtomicInteger(1);
    private int id; //Autogenerado.
    private String nombre;
    private String status; //Ready, Running, Blocked.
    private int PC; //Program Counter (apunta a la siguiente instrucción)
    private int MAR; // Memory Address Register.

    public PCB(String nombre) {
        this.id = contadorID.getAndIncrement();
        this.nombre = nombre;
        this.status = "Ready";
        this.PC = 0;
        this.MAR = 0;
    }
    
    public void changeStatus(String newStatus){
        this.status = newStatus;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public void setMAR(int MAR) {
        this.MAR = MAR;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getStatus() {
        return status;
    }

    public int getPC() {
        return PC;
    }

    public int getMAR() {
        return MAR;
    }

}
