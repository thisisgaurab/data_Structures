public class myLinkedList {
    protected Node Head;
    protected int Size;

    public myLinkedList()    // default constructor
    {
        Head = null;
        Size = 0;
    }

    public void setHead(Node val) {
        Head = val;
    }

    public Node getHead() {
        return Head;
    }

    public void setSize(int size) {
        Size = size;
    }

    public int getSize() {
        return Size;
    }

    //for insertEmpty
    public void insertEmpty(Node n) {
        n.setNext(n);
        n.setPrev(n);
        Head = n;
        Size++;
    }

    //insertFront
    public void insertFront(Node n) {
        Node Front = getHead();
        if (isEmpty()) {
            insertEmpty(n);

        }else {
            n.setPrev(Front.getPrev());
            n.setNext(Front);
            Front.getPrev().setNext(n);
            Front.setPrev(n);
            setHead(n);
            Size++;
        }

    }
    //insertRear
    public void insertRear (Node n) {
        Node Front = getHead();

        //if the list is empty
        if (isEmpty()) {
            insertEmpty(n);
        } else {
            n.setPrev(Front.getPrev());
            n.setNext(Front);
            Front.getPrev().setNext(n);
            Front.setPrev(n);
            Size++;
        }
    }

    //insertPos
    public void insertPos(Node n, int pos) {
        Node Front = getHead();

        if (isEmpty()) {
            insertEmpty(n);
        } else if (pos == 1) {
            insertFront(n);

        } else if (pos == Size+1) {
            insertRear(n);
        } else {
            Node temp = Front;
            for (int i = 1; i < pos; i++) {
                temp = temp.getNext();
            }
            n.setPrev(temp.getPrev());
            n.setNext(temp);
            temp.getPrev().setNext(n);
            temp.setPrev(n);
            Size++;


            /*
            n.setPrev(temp.getPrev().getNext());
            n.setNext(temp.getPrev());
            temp.setPrev(n);
            n.getPrev().setNext(n);
            Size++;

             */



           /* temp.getPrev().setNext(n);
            n.setNext(temp);
            temp.setPrev(n);
            n.getPrev().setNext(n);
            Size++;
            */
        }
    }



        //deleteFront
    public int deleteFront(){
        Node Front = getHead();


        int dataCopy = Front.getData();
        Front.getNext().setPrev(Front.getPrev());
        Front.getPrev().setNext(Front.getNext());
        setHead(Front.getNext());
        Size--;

        return dataCopy;

    }

    //deleteRear
    public int deleteRear(){
        Node Front = getHead();
        int dataCopy = Front.getPrev().getData();
        Front.getPrev().getPrev().setNext(Front);
        Front.setPrev(Front.getPrev().getPrev());
        Size--;
        return dataCopy;

    }

    //deletePos
    public int deletePos(int pos) {
        Node Front = getHead();
        int dataCopy=25;

        //if the pos ==1
        if (pos==1) {
            return deleteFront();
        } else if (pos == Size) {
            deleteRear();
        } else {
            Node temp = Front;
            for (int i = 1; i < pos; i++) {
                temp = temp.getNext();
            }
                dataCopy=temp.getData();
                temp.getNext().setPrev(temp.getPrev());
                temp.getPrev().setNext(temp.getNext());


                Size--;

        }
        return dataCopy;
    }

    //printList
    public void printList(){
        Node front= getHead();
        if (isEmpty()){
            System.out.println("The list is empty");
        }else {
//            Node Front = getHead();
//            System.out.println(Front.getData());
//            Node temp = Front.getNext();
//            while(temp!=Front){
//                System.out.println(temp.getData());
//                temp = temp.getNext();

            for (int i = 0; i <Size ; i++) {
                System.out.println(i+1 +" : "+ front.getData());
                front=front.getNext();

            }
            }
        }

    //isEmpty
    public boolean isEmpty() {
        if (Size == 0) {
            return true;
        } else {
            return false;
        }
    }

    //getItem
    public int getItem(int pos){
        Node temp = getHead();
        for(int i = 1; i<pos; i++) {
             temp = temp.getNext();
        }
        int data = temp.getData();
        return data;

        }




}// end myLinkedList class