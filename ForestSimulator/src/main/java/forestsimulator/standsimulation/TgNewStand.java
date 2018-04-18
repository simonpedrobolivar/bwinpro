/* http://www.nw-fva.de
   Version 07-11-2008

   (c) 2002 Juergen Nagel, Northwest German Forest Research Station, 
       Grätzelstr.2, 37079 Göttingen, Germany
       E-Mail: Juergen.Nagel@nw-fva.de
 
This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation.

This program is distributed in the hope that it will be useful,
but WITHOUT  WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
 */
/**
 *
 * @author  sschimpf
 */
package forestsimulator.standsimulation;

import java.awt.Frame;
import treegross.base.*;
import java.util.*;
import javax.swing.JDialog;


public class TgNewStand extends JDialog {
    
    Stand st;
    TgJFrame frame;

    public TgNewStand(Frame parent, boolean modal, Stand st1, TgJFrame owner, 
                      Locale preferredLanguage) {
        super(parent, modal);
        st = st1;
        frame = owner;
        initComponents();
//        jButton1.setText(messages.getString("create_stand"));
//        setTitle(messages.getString("new_Stand"));
//        jLabel1.setText(messages.getString("IntroZeile"));
//        jLabel2.setText(messages.getString("Size"));
//        jButton1.setText(messages.getString("create_area"));
//        jComboBox1.removeAllItems();
//        jComboBox1.addItem(messages.getString("square"));
//        jComboBox1.addItem(messages.getString("circular"));
//
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        newStandInfoLabel = new javax.swing.JLabel();
        areaSizeLabel = new javax.swing.JLabel();
        tf0 = new javax.swing.JTextField();
        createAreaButton = new javax.swing.JButton();
        areaShapeComboBox = new javax.swing.JComboBox();
        standNameTextField = new javax.swing.JTextField();
        standNameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("forestsimulator/gui"); // NOI18N
        setTitle(bundle.getString("TgNewStand.title")); // NOI18N
        setModal(true);

        jPanel1.setBackground(new java.awt.Color(246, 188, 188));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 250));

        newStandInfoLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        newStandInfoLabel.setText(bundle.getString("TgNewStand.newStandInfoLabel.text")); // NOI18N

        areaSizeLabel.setText(bundle.getString("TgNewStand.areaSizeLabel.text")); // NOI18N

        tf0.setText(bundle.getString("TgNewStand.tf0.text")); // NOI18N

        createAreaButton.setBackground(new java.awt.Color(204, 0, 0));
        createAreaButton.setText(bundle.getString("TgNewStand.createAreaButton.text")); // NOI18N
        createAreaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAreaButtonActionPerformed(evt);
            }
        });

        areaShapeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "square", "circular" }));

        standNameTextField.setText(bundle.getString("TgNewStand.standNameTextField.text")); // NOI18N

        standNameLabel.setText(bundle.getString("TgNewStand.standNameLabel.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(newStandInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(standNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(standNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(areaSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(tf0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(areaShapeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(createAreaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(newStandInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(standNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(standNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(areaSizeLabel))
                    .addComponent(tf0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaShapeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(createAreaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createAreaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAreaButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Create area"+tf0.getText());
                 st.newStand();
                 st.ncpnt=0;
                 st.nspecies=0;
                 st.ntrees=0;
                 st.addsize(Double.parseDouble(tf0.getText()));
                 st.standname=standNameTextField.getText();
                 st.year=2008;
                 
                 if (areaShapeComboBox.getSelectedIndex()==0)
                 {
                   double len = Math.sqrt(10000*st.size);  
                   st.addcornerpoint("ECK1",0.0,0.0,0.0);
                   st.addcornerpoint("ECK2",0.0,len,0.0);
                   st.addcornerpoint("ECK3",len,len,0.0);
                   st.addcornerpoint("ECK4",len,0.0,0.0);
                   st.center.no="polygon";
                   st.center.x =len/2.0;
                   st.center.y =len/2.0;
                   st.center.z =0.0;

                 } 
                 
                 else
                 {  
                     double xp=0.0; double yp=0.0; double radius=0.0;
                     radius=Math.sqrt(10000.0*st.size/Math.PI);
                     for (int i=0;i<18;i++)
                     { 
                         xp=radius+Math.sin(Math.PI*i*20.0/180.0)*radius;
                         yp=radius+Math.cos(Math.PI*i*20.0/180.0)*radius;
                         //System.out.println(xp+" "+yp);
                         st.addcornerpoint("ECKP"+i,xp,yp,0.0);
                         st.center.no="circle";
                         st.center.x =radius;
                         st.center.y =radius;
                         st.center.z =0.0;
                     }
                 } 
                 
                 frame.updatetp(false);
                 dispose();
    }//GEN-LAST:event_createAreaButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox areaShapeComboBox;
    private javax.swing.JLabel areaSizeLabel;
    private javax.swing.JButton createAreaButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel newStandInfoLabel;
    private javax.swing.JLabel standNameLabel;
    private javax.swing.JTextField standNameTextField;
    private javax.swing.JTextField tf0;
    // End of variables declaration//GEN-END:variables
    
}
