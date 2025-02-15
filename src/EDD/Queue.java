package EDD;


public class Queue {
    
    private Node head;
    private Node tail;
    private int size;

    public Queue(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }
    
    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    //Función para verificar si la cola está vacía.
    public boolean isEmpty(){
        return head == null;
    }
    
    //Función para encolar un proceso.
    public void enqueue(Node node){
        if(isEmpty()){
            head = node;
            tail = node;
        }else{
            tail.setpNext(node);
            tail = node; 
        }
    }
    
    //Función para desencolar un proceso.
    public Node dequeue(){
        if(isEmpty()){
            return null;
        }else{
            Node aux = head;
            head = aux.getpNext();
            return aux;
        }
    }   
}
