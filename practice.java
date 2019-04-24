import java.util.*;
import java.io.*;

public class practice{

    public static void main(String[] args){

        Hashtable<String, Integer> h_table= new Hashtable();
        h_table.put("chocolate", 1);
        h_table.put("car",1);
        h_table.put("book",1);

        Enumeration e = h_table.elements();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
    }
}