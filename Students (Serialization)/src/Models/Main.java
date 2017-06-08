package Models;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by admin on 08.06.2017.
 */
public class Main {
    ArrayList<Students> studentList= new ArrayList<>();
    
    Group group1 = new Group(1l, "Android_01");

    ArrayList<Students> studentList = new ArrayList<>();

    ArrayList<Contact> contacts = new ArrayList<>();
    

    try {
         FileOutputStream fs = new FileOutputStream("Students.ser");
         ObjectOutputStream os = new ObjectOutputStream(fs);

        System.out.println("Serializing...");

        for (Students student : studentList)
        {
            os.writeObject(student);
        }
        os.close();
       }
       catch (IOException ex){
        ex.printStackTrace();
        }

}
