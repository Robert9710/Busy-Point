package oosdass.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AdminStaff extends Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //Empty constructor
    public AdminStaff(){
        
    }
    
    //Constructor with parameters
    public AdminStaff(int id, String phoneNumber, boolean available, 
            Name name, Address address, BusyPoint busyPoint){
        super(id, phoneNumber, available, name, address, busyPoint);
    }
    
    
}

