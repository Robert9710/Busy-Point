package oosdass.derby;

public class AssignStaffThread implements Runnable{
    String Id;
    
    public AssignStaffThread(String Id){
        this.Id = Id;
    }
    //Thread to update the status of a member of staff
    @Override
    public void run() {
        MyEntityApp mea = new MyEntityApp();
        int id = Integer.parseInt(Id);
        mea.findStaff(id);
    }
    
}

