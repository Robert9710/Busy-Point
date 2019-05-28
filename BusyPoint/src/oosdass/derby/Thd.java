package oosdass.derby;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oosdass.entity.Staff;
import oosdass.system.Options;

public class Thd implements Runnable {
    java.util.List<Staff> al;
    
    public Thd(){
        
    }
    
    public Thd(List<Staff> al){
        this.al = al;
    }
    //Thread to update the number of available and unavailable memebers of staff
    @Override
    public void run() {
        MyEntityApp mea = new MyEntityApp();
        al = mea.findStaffList();
        int a=0,b=0;
        for(int i=0;i<al.size();i++){
            if(al.get(i).isAvailable()==true){
                a++;
            }else{
                b++;
            }
        }
        Options.setAS(a);
        Options.setUS(b);
    }
}


