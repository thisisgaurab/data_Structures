

public class myQueue extends myLinkedList {

    public myQueue(int N){
        super();

    }

    public void enqueue(int N){
        Node node = new Node(N);
        insertRear(node);

    }

    public int dequeue(){
        return deleteFront();
    }

    public boolean isEmpty(){
        return super.isEmpty();
    }

    public int front(){
        return super.Head.getData();
    }

    public int rear(){
        return super.Head.getPrev().getData();

    }


}
