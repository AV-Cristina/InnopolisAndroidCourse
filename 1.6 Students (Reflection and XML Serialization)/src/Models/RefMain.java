package Models;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Cristina on 12.06.2017.
 */
public class RefMain {
    public static void main(String[] args) throws Exception {
        Group group1 = new Group(1l, "Android_01");

        ArrayList<Contact> contacts = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOfBirth = null;

        try {
            dateOfBirth = format.parse("01.02.1987");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Students student1 = new Students("Conor John Reese", "Conor", "John", "Reese", dateOfBirth, group1.getGroupId());

        for (Field f : student1.getClass().getDeclaredFields()) {
            System.out.println(f.getName() + " " + f.getType());

        }

        for (Method m : student1.getClass().getMethods()) {
            System.out.println(m.getName() + " ");
        }

        Field firstName = student1.getClass().getDeclaredField("firstName");
        firstName.setAccessible(true);
        System.out.println(firstName.get(student1));

        serialXML(student1);

        /*
        Field stuId = student1.getClass().getDeclaredField("id");
        stuId.setAccessible(true);
        //Field modifiersField = Field.class.getDeclaredField("modifiers");
        //stuId.setInt(stuId, stuId.getModifiers() & ~Modifier.FINAL);
        stuId.set(null,1l);
        System.out.println(stuId.get(student1));*/
    }



    private static void serialXML(Students student1)throws Exception{

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // root elements
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement(student1.getClass().getName());
            doc.appendChild(rootElement);

            // Student elements
            Element objectType = doc.createElement(student1.getClass().getTypeName());
            rootElement.appendChild(objectType);

            for (Field ft : student1.getClass().getDeclaredFields()) {
                Attr attr = doc.createAttribute("type");
                attr.setValue(ft.getName());
                objectType.setAttributeNode(attr);
            }

        // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\admin\\IdeaProjects\\Students\\src\\Output\\students.xml"));


            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved!");
        }
    }

