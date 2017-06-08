package Models;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by admin on 08.06.2017.
 */
public class Students implements Serializable {
    private String name;
    private String lastName;
    private String surname;
    private Date dateOfBirth;
    private Long id;
    private Long groupId;
    private List<Contact> contacts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Students (Date dateOfBirth, Long groupId, String name, String surname, String lastName){
        this.dateOfBirth = dateOfBirth;
        this.groupId = groupId;
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.id = System.currentTimeMillis() + (Math.random()*42);;
        this.contacts = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        return (int) (21 + id * 42);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Students)) return false;
        if (this.id == ((Students)obj).id) return true;
        return super.equals(obj);
    }
}
