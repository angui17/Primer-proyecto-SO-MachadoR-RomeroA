package EDD;

import proyecto.so.Proceso;


public class Node {
    
   private Proceso proceso;
   private Node pNext;

   
   public Node(Proceso proceso) {
        this.proceso = proceso;
        this.pNext = null;
    }
   
    public Node(Proceso proceso, Node pNext) {
        this.proceso = proceso;
        this.pNext = pNext;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public Node getpNext() {
        return pNext;
    }

    public void setpNext(Node pNext) {
        this.pNext = pNext;
    }
   
}
