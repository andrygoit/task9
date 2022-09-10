package task9;

public class MyLinkedList {
    private int size = 0;
    private Node head;
    public  MyLinkedList(){
        head = null;
    }
    public class Node {
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    public void add(int data){
        Node newNode = new Node(data);
        Node currentNode = head;
        if (head == null){
            head = newNode;
        } else {
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }
    public void remove(int index){
        Node currentNode = head;
        Node previousNode = null;
        while (currentNode.next != null){
            if (currentNode.data == index){
                if (currentNode == head){
                    head = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        size--;
    }
    public void clear(){
        for (int i = 0; i < size -1;i++){
            remove(i);
        }
    }
    public int size(){
        return size;
    }
}
