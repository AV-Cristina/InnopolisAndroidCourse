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
    @Deprecated
    private String name;
    private String firstName;
    private String surname;
    private String secondName;
    private Date dateOfBirth;
    private final Long id;
    private Long groupId;
    private List<Contact> contacts;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    /**/
    public Students(String name, String firstName, String surname, String secondName, Date dateOfBirth, Long groupId, List<Contact> contacts) {
        this.name = name;
        this.firstName = firstName;
        this.surname = surname;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.id = (long)(Math.random()) + System.currentTimeMillis();
        this.groupId = groupId;
        this.contacts = new ArrayList<>();
    }

    public Students(String name, String firstName, String surname, String secondName, Date dateOfBirth, Long groupId) {
        this.name = name;
        this.firstName = firstName;
        this.surname = surname;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.id = (long)(Math.random()) + System.currentTimeMillis();
        this.groupId = groupId;
        //this.contacts = new ArrayList<>();
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
