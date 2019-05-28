package oosdass.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manager extends Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //Empty constructor
    public Manager(){
        
    }
    
    //Constructor with parameters
    public Manager(int id, String phoneNumber, boolean available, 
            Name name, Address address, BusyPoint busyPoint){
        super(id, phoneNumber, available, name, address, busyPoint);
    }
}

