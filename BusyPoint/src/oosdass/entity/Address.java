package oosdass.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number;
    private String street;
    private String city;
    private String postcode;
    private BusyPoint busyPoint;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="address")
    private Collection<Staff> staffMembers;
    
    //Empty constructor for the address
    public Address(){
        
    }
    
    //Constructor with parameters for Busy Point
    public Address(int number, String street, String city, String postcode){
        this.number = number;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
    }
    
    //Constructor with parameters
    public Address(int number, String street, String city, String postcode, BusyPoint busyPoint){
        this.number = number;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.busyPoint = busyPoint;
        staffMembers = new ArrayList();
    }
    
    //Method to add a new staff member to the list
    public void addStaffMember(Staff staff){
        staffMembers.add(staff);
    }
    
    //Gettters and setters for parameters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    public BusyPoint getBusyPoint() {
        return busyPoint;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", number=" + number + 
                ", street=" + street + ", city=" + city + ", postcode=" + postcode+ '}';
    }
    
    
    
}

