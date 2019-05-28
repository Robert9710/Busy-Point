package oosdass.system;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import oosdass.derby.AssignStaffThread;
import oosdass.derby.MyEntityApp;
import oosdass.derby.Thd;
import oosdass.entity.Staff;

public class StaffList extends javax.swing.JFrame {

    public StaffList() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list = new java.awt.List();
        selectButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        list1 = new java.awt.List();
        list2 = new java.awt.List();
        list3 = new java.awt.List();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        selectButton.setText("Select");
        selectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selectButtonMouseReleased(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(list2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(list3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelButton)
                    .addComponent(selectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(202, 202, 202))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(list3, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(list2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(selectButton)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Create an instance of the MyEntityApp
        MyEntityApp mea = new MyEntityApp();
        //Set the table head
        String s1 = "              ";
        list.add("     "+"Id");
        list.add("");
        list1.add("First Name");
        list1.add("");
        list2.add("Last Name");
        list2.add("");
        list3.add("Availability");
        list3.add("");
        
        //Get the array of staff members
        List<Staff> staffList = new ArrayList();
        staffList = mea.findStaffList();
        //Put the staff array in the list
        for(int i=0;i<staffList.size();i++){
            Staff s = staffList.get(i);
            list.add(s.getStaffId()+"");
            list1.add(s.getName().getFirstName());
            list2.add(s.getName().getLastName());
            list3.add(s.isAvailable()+"");
            
        }
    }//GEN-LAST:event_formWindowOpened

    private void selectButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectButtonMouseReleased
        //Get the selected staff member
        String s = list.getSelectedItem();
        if(s == ""||s.trim().equals("Id")){
            JOptionPane.showMessageDialog(this, 
                    "Please select a member of staff from the first list or click cancel");
        }
        else{
            JOptionPane.showMessageDialog(this, "Staff assigned");
            //Thread to change the staff status
            Thread t = new Thread(new AssignStaffThread(s));
            t.start();
            //Open a new Options window
            Options o = new Options();
            o.setVisible(true);
            o.setLocationRelativeTo(null);
            //Close this window
            this.dispose();
        }
    }//GEN-LAST:event_selectButtonMouseReleased

    private void cancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseReleased
        Options o = new Options();
        o.setVisible(true);
        o.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private java.awt.List list;
    private java.awt.List list1;
    private java.awt.List list2;
    private java.awt.List list3;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables
}

