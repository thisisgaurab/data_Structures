import java.io.*;
import java.util.*;
public class  Driver1  {
    public static myArrayList   list;
    public static Scanner  inp;
    public static File f;
    public static String  fname;
    public static void main( String args[ ] )
    {
        System.out.print("Please enter a path or name of input file : ");
        inp = new Scanner(System.in);
        fname = inp.nextLine();
        f = new File(fname);
        try {
            inp = new Scanner(f);
        } catch (Exception E ) { System.out.println("Cannot find file");}
        String line;
        String [ ] tokens;
        int num = Integer.parseInt( inp.nextLine());
        list = new myArrayList(num);
        while ( inp.hasNextLine() )
        {
            int pos = 0;
            int val = 0;
            line = inp.nextLine( );
            tokens = line.split("\\s+");

            switch ( tokens[0] )  {
                case "IF" :
                    val = Integer.parseInt( tokens[1] );
                    list.insertFront(val);
                    break;
                case "IR" :
                    // code for calling insertRear() should go here
                    val = Integer.parseInt(tokens[1]);
                    list.insertRear(val);
                    break;
                case  "IP" :
                    pos = Integer.parseInt( tokens[1] );
                    val = Integer.parseInt( tokens[2] );
                    if ( pos > 0 && pos <= list.getSize()+1)
                        list.insertPos(val,pos);
                    else
                        System.out.println("ERROR : NO SUCH POSITION IN LIST");
                    break;
                case  "DF"  :
                    if ( ! list.isEmpty() )
                        System.out.println("### " + list.deleteFront( ) + " ###");
                    else
                        System.out.println("CANNOT DELETE FROM EMPTY LIST");
                    break;
                case  "DR"  :
                    if(!list.isEmpty()){
                        int deleted = list.deleteRear();
                        System.out.println("@@@ "+ deleted +" @@@");
                    }
                    else {
                        System.out.println("CANNOT DELETE FROM EMPTY LIST");
                    }
                    break;
                case  "DP"   :
                    pos = Integer.parseInt(tokens[1]);
                    if(pos<=list.getSize() && pos>0){
                        int deleted = list.deletePos(pos);
                        System.out.println("*** " + deleted+ " ***");

                    }
                    else {
                        System.out.println("CANNOT DELETE FROM EMPTY LIST");
                    }
                    break;
                case "PL" :
                    list.printList();
                    break;
                case "GS" :
                    int size = list.getSize();
                    System.out.println("Size: "+ size);

                    break;
                case  "GI"  :
                    pos = Integer.parseInt(tokens[1]);
                    if ( pos < list.getSize( ) && pos > 0)
                    System.out.println("Position " + pos + " : " + list.getItem(pos));
else
                    System.out.println("ERROR : NO SUCH POSITION IN LIST");
                    break;
                default :
                System.out.println("Command not recognized : " + tokens[0]);
            }   // end switch
        }  // end while
    }   // end main()
}    // end class
