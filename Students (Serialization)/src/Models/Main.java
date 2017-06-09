package Models;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by admin on 08.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        Group group1 = new Group(1l, "Android_01");

        ArrayList<Students> studentList = new ArrayList<>();

        ArrayList<Contact> contacts = new ArrayList<>();

        Contact contact1 = new Contact("cristina@gmail.com", ContactType.EMAIL);

        contacts.add(contact1);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOfBirth = null;

        try {
            dateOfBirth = format.parse("07.08.1989");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Students student1 = new Students("Афанасьева Кристина Викторовна", "Кристина", "Афанасьева", "Викторовна", dateOfBirth, group1.getGroupId(), contacts);

        //studentList.add(student1);

        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);

            System.out.println("Serializing...");

            oos.writeObject(student1);
            oos.flush();
            baos.flush();
            oos.close();
            baos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            System.out.println("Deserializing...");

            Students student2 = (Students)ois.readObject();

            System.out.println("student2.id = " + student2.getId());
            System.out.println("student2.field = "+ student2.getId());
        }
        catch (IOException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

    }
}
