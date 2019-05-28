package oosdass.entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Staff implements Serializable {

    //Parameters for staff
    @Id
    private int staffId;
    private String password;
    private String phoneNumber;
    private boolean available;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Name name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;
    @ManyToOne(cascade = CascadeType.PERSIST) 
    private BusyPoint busyPoint;
    
    //Empty constructor
    public Staff(){
    }
    
    //Constructor with parameters
    public Staff(int id, String phoneNumber, boolean available, 
            Name name, Address address, BusyPoint busyPoint){
        this.staffId = id;
        this.phoneNumber = phoneNumber;
        this.available = available;
        this.name = name;
        this.address = address;
        this.busyPoint = busyPoint;
        this.password = name.getFirstName().substring(0,2)+name.getLastName().substring(0,2)+id/10000;
    }
    
    //Getters and setters for staff properties
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int id) {
        this.staffId = id;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public BusyPoint getBusyPoint() {
        return busyPoint;
    }
}

