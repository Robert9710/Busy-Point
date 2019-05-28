package oosdass.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class BusyPoint implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    //Parameters for Busy Point
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private static BusyPoint instance;
    private String  phoneNumber;
    private int companyId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="busyPoint")
    private Collection<Staff> staffMembers;

    private BusyPoint(){
        staffMembers = new ArrayList();
        this.phoneNumber = "07503828229";
        this.companyId = 100543342;
        this.address = new Address(24, "Hemilton Street", "London", "AK8 3JA");
        
    }
    
    //Method to add a new member of staff based on their department
    public void addStaff(String typeOfStaff, String phoneNumber, int id, 
            boolean available, Name name, Address address, BusyPoint busyPoint){
        Staff staff = null;
        if(typeOfStaff.equals("Admin")){
        staff = new AdminStaff(id, phoneNumber, available, name, address, busyPoint);
        }else if(typeOfStaff.equals("Manager")){
            staff = new Manager(id, phoneNumber, available, name, address, busyPoint);
        }else if(typeOfStaff.equals("AdvertisingStaff"))
        staffMembers.add(staff);
    }

    //Method to get the instance of Busy Point
    public static BusyPoint getInstance(){
        if(instance==null){
            instance = new BusyPoint();
        }
        return instance;
    }
    
    //Getters and setters for the parameters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String oldPhoneNumber = this.phoneNumber;
        this.phoneNumber = phoneNumber;
        changeSupport.firePropertyChange("phoneNumber", oldPhoneNumber, phoneNumber);
    }
    
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        int oldCompanyId = this.companyId;
        this.companyId = companyId;
        changeSupport.firePropertyChange("companyId", oldCompanyId, companyId);
    }
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        Address oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

