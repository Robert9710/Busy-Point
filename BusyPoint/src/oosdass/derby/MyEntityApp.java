package oosdass.derby;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import oosdass.entity.Address;
import oosdass.entity.AdminStaff;
import oosdass.entity.AdvertisingStaff;
import oosdass.entity.BusyPoint;
import oosdass.entity.Manager;
import oosdass.entity.Name;
import oosdass.entity.Staff;

public class MyEntityApp {

    public static void main(String args[]) {
        Name name = new Name("Bell", "William");
        Address address = new Address(58, "Walington Street", "London", "UC7 8JA");
        BusyPoint bp = BusyPoint.getInstance();
        Staff s = new AdminStaff(235467, "07507218374", true, name, address, bp);
        MyEntityApp mea = new MyEntityApp();
        mea.persist(s);
        
    }
    
    //Method to insert an object into database
    public void persist(Object object) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("BusyPointPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            //Insert the object
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    
    
    //Method to check if the username and password are in the database
    public int checkLogInDetails(int staffId, String password) {
        Staff staff;
        int ok=0;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("BusyPointPU");
        EntityManager em = emf.createEntityManager();
        try {
            //Check if the details match what is in the database and 
            //what department is the member of staff from
            staff  = em.find(AdminStaff.class, staffId);
            if(staff.getPassword().equals(password)){
              ok = 1;
           }
            staff  = em.find(AdvertisingStaff.class, staffId);
            if(staff.getPassword().equals(password)){
              ok = 2;
           }
            staff  = em.find(Manager.class, staffId);
            if(staff.getPassword().equals(password)){
              ok = 3;
           }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }          
        return ok;
    }
    
    //Method to find a memeber of staff in the database
    public void findStaff(int staffId) {
        Staff staff;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("BusyPointPU");
        EntityManager em = emf.createEntityManager();
        try {
            //Find the member of staff by id
            staff = em.find(Staff.class, staffId);
            //Update the status of the member of staff
            em.getTransaction().begin();
            staff.setAvailable(false);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            em.close();
        }          
        
    }
    
    //Get a list with the staff members
    public List<Staff> findStaffList() {
        List<Staff> staffMembers =  null;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("BusyPointPU");
        EntityManager em = emf.createEntityManager();
        try {
            //Get all members of staff from the database
            String qry = "from Staff s ";    
            //Put the staff members in a list
            staffMembers =  em.createQuery(qry).getResultList();
            //Return the list with the staff members
            return staffMembers;
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            em.close();
        }          
        return staffMembers;
    }    
}


