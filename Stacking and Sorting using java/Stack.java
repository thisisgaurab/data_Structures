public class Stack extends myLinkedList{



    //creating an empty constructor
    public Stack(){
        super();
    }

    //to check if the stack is empty or not
     public boolean isEmpty(){
       return super.isEmpty();
     }

     //to push an integer
    public void push(int x){
        Node temp = new Node(x);

        insertRear(temp);
       /*  if (isEmpty()){
            setHead(temp);
        }else{
            temp.setNext(Head);
            Head = temp;
            Size++;
        }

        */



    }

    //to pop the elements
    public int pop(){
       /* int result = Head.getData();
        Head = Head.getNext();
        Size--;
        return result;
        */
        return deleteRear();


    }

    //to return top elements
    public int top(){
       int Top = Head.getPrev().getData();
       return Top;

    }

}
