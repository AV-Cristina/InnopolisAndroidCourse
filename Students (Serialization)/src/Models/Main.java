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
    public static void main(String[] args) {
        Group group1 = new Group(1l, "Android_01");

        ArrayList<Students> studentList = new ArrayList<>();

        ArrayList<Contact> contacts = new ArrayList<>();
        

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOfBirth = null;
        
        try {
            dateOfBirth = format.parse("07.08.1989");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Students student1 = new Students("Афанасьева Кристина Викторовна", "Кристина", "Афанасьева", "Викторовна", dateOfBirth, group1.getGroupId(), contacts);

        studentList.add(student1);
    }

}
