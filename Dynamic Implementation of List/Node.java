import java.io.*;
import java.util.*;
public class Node {
    protected int Data;
    protected Node  Prev, Next;
    public Node (int val ) {   // construtor
        Prev = null;
        Next = null;
        Data = val;
    }
    // getter and setters below
    public  int  getData( ) {
        return Data;
    }
    public void setData( int val )
    {
        Data = val;
    }
    public  void setNext(  Node nxt )
    {
        Next = nxt;
    }
    public  Node  getNext( )
    {
        return Next;
    }
    public void setPrev( Node pre )
    {
        Prev = pre;
    }
    public Node getPrev( )
    {
        return Prev;
    }


}