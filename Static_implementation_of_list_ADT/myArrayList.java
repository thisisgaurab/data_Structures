public class myArrayList {
    private int[] elements;
    private int size;

    public myArrayList(int length){
        elements = new int[length];
        size = 0;
    }

    public myArrayList(){
        this(100);
    }

     void insertFront(int x){
        if(size == elements.length){
            System.out.println("LIST IS FULL");
            System.exit(-1);
        }else{
            for(int i=size-1; i>=0; i--){
                elements[i+1]=elements[i];
            }
            elements[0]=x;
            size++;
        }
     }

     void insertRear(int x){
        if(size==elements.length){
            System.out.println("LIST IS FULL");
            System.exit(-1);
        }else{
            elements[size]=x;
            size++;
        }
     }

     void insertPos(int x, int pos){

       if(size== elements.length){
            System.out.println("LIST IS FULL");
            System.exit(-1);
        } else{
            for(int i=size; i>=pos; i--){
                elements[i]=elements[i-1];
            }
            elements[pos-1]=x;
            size++;
        }
     }

     int deleteFront(){
        int element0 = elements[0];
        for(int i= 1; i<size; i++){
            elements[i-1] = elements[i];
        }
         size--;
         return element0;

     }

     int deleteRear(){
        size--;
        return elements[size];


     }

     int deletePos(int pos){
         if (pos >= 1 && pos <= size) {
             int deletedElement = elements[pos-1];
             for (int i = pos; i < size; i++) {
                 elements[i-1] = elements[i];
             }
             size--;
             return deletedElement;
         } else {
             System.out.println("Position does not exist.");
             return -1;
         }

     }

     void printList(){
        if (size==0){
            System.out.println("List is empty.");
        }else{
            for(int i=0; i<size; i++){
                System.out.println(i+1+" : "+elements[i]);
            }
        }
     }

     boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
     }

     boolean isFull(){
        if(size==elements.length){
            return true;
        }else{
            return false;
        }
     }

     int getItem(int pos){   /*I am not sure about this one.*/
        if(pos>=0 && pos<=size-1){
            return elements[pos-1];
        }else{
            System.out.println("Error, The position does not exist.");
        }
        return -1;
     }

     int getSize(){
         return size;
     }




}
