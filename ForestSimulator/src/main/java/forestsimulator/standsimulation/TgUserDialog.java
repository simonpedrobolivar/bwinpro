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
import java.io.File;
import java.util.*;
import javax.swing.*;

public class TgUserDialog extends javax.swing.JDialog {
    File WorkingDir;
    File ProgramDir;
    File DataDir;
    String Language = "";
    File localPath;
    String XMLSettings="";
    String plugIn="";
    java.io.File verzeichnis;
    java.io.File localF = null;
    TgUser user = new TgUser();
    ResourceBundle messages;
    Locale currentLocale;
    java.io.File f = null;
   
    /** Creates new form JDialog */
    public TgUserDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        f = new java.io.File("");
        try{ localPath= f.getCanonicalFile();
              } catch (Exception e){};
        System.out.println("User Setting Directory:" + user.fileExists("ForestSimulator.ini"));
        if (user.fileExists("ForestSimulator.ini")) {
            System.out.println("Settings laden ");
            user.loadSettings(f);
              
            ProgramDir=user.getProgramDir();
            WorkingDir=user.getWorkingDir();
            DataDir=user.getDataDir();
            XMLSettings=user.getXMLSettings();
            plugIn = user.getPlugIn();
            loadModels();
        }

        jTextField1.setText(ProgramDir.getName());
        jTextField2.setText(WorkingDir.getName());
        jTextField3.setText(DataDir.getName());
        jComboBox2.setSelectedItem(plugIn);
// PlugIn Model
        currentLocale = new Locale(user.getLanguageShort(), "");
        messages = ResourceBundle.getBundle("forestsimulator.standsimulation.TgJFrame",currentLocale);
        jComboBox1.setSelectedItem(user.language);
        jComboBox3.setSelectedIndex(user.grafik3D);
        setTitle(messages.getString("TreeGrOSS_ForestSimulator"));
        jLabel1.setText(messages.getString("Language"));
        jLabel2.setText(messages.getString("find_directory_user"));
        jLabel3.setText(messages.getString("set_directory_output"));
        jLabel5.setText(messages.getString("set_directory_input"));
        jButton1.setText(messages.getString("search"));
        jButton4.setText(messages.getString("search"));
        jButton5.setText(messages.getString("search"));
        jButton2.setText(messages.getString("OK"));

    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        // "vor"
        jButton1 = new javax.swing.JButton();
        // hinter
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TreeGrOSS - ForestSimulator - General Program Settings");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Language");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 70, 14);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Deutsch", "Englisch", "Espanol", "Polish" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(100, 22));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(80, 20, 100, 22);

        jLabel2.setText("find directory \\user ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 60, 390, 14);

        jTextField1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(20, 80, 450, 19);

        jButton1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        jButton1.setText("Search");
        jButton1.setAlignmentY(0.0F);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setMinimumSize(new java.awt.Dimension(100, 25));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(500, 80, 80, 25);

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(320, 290, 280, 23);

        jTextField2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        getContentPane().add(jTextField2);
        jTextField2.setBounds(20, 190, 450, 19);

        jButton4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(500, 190, 80, 21);

        jLabel3.setText("Set directory for data output");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 170, 390, 14);

        jLabel5.setText("set directory for input data");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 110, 240, 14);

        jTextField3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        getContentPane().add(jTextField3);
        jTextField3.setBounds(20, 130, 450, 20);

        jButton5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(500, 130, 80, 21);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Stand graphic 3D", "Stand graphic 2D" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(360, 20, 150, 20);

        jLabel6.setText("XML - File in directory \\user ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 230, 140, 14);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(20, 250, 450, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-651)/2, (screenSize.height-377)/2, 651, 377);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        javax.swing.JFileChooser jf = new javax.swing.JFileChooser();
        jf.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jf.setCurrentDirectory(localPath);
        jf.setDialogTitle(messages.getString("choose_Data_Dir"));
        int k=jf.showOpenDialog(this);
        DataDir = jf.getSelectedFile();        
        jTextField3.setText(DataDir.getAbsolutePath());
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        javax.swing.JFileChooser jf = new javax.swing.JFileChooser();
        jf.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jf.setCurrentDirectory(localPath);
        jf.setDialogTitle(messages.getString("choose_Output_Dir"));
        int k=jf.showOpenDialog(this);
        WorkingDir = jf.getSelectedFile();        
        jTextField2.setText(WorkingDir.getAbsolutePath());

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
            java.io.PrintWriter ausgabe = new java.io.PrintWriter(new java.io.FileWriter(localPath+System.getProperty("file.separator")+"ForestSimulator.ini"));
            ausgabe.println(jTextField1.getText());
            ausgabe.println(jTextField3.getText());
            ausgabe.println(jTextField2.getText());
            Language = (String)jComboBox1.getSelectedItem();
            ausgabe.println(Language);
            ausgabe.println(jComboBox2.getSelectedItem());
            int g3D = 0;
            if (jComboBox3.getSelectedIndex()>0) g3D=1;
            ausgabe.println(g3D);
            ausgabe.close();
            JTextArea about = new JTextArea("Please restart program with new settings");
            JOptionPane.showMessageDialog(this, about, "About", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);

            dispose();
        }
        catch(java.io.IOException e){System.out.println("Error! writing File standsimulation.ini");}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        javax.swing.JFileChooser jf = new javax.swing.JFileChooser();
        jf.setCurrentDirectory(localPath);
        jf.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jf.setDialogTitle(messages.getString("choose_User_Dir"));
        int k=jf.showOpenDialog(this);
        ProgramDir = jf.getSelectedFile();        
        jTextField1.setText(ProgramDir.getAbsolutePath());
        loadModels();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void loadModels(){
        jComboBox2.removeAllItems();
        java.io.File verzeichnis = new java.io.File(ProgramDir+System.getProperty("file.separator")+"models");
// Liste mit Dateien erstellen 
        String entries[]=verzeichnis.list();
        for ( int i = 0; i < entries.length; i++ ) {
             if (entries[i].indexOf(".xml") >0) jComboBox2.addItem(entries[i]);
        }

        
    }
    
    /**
     * @param args the command line arguments
   */
    /*
    public static void main(String args[]) {
        new javax.swing.JDialog(new javax.swing.JFrame(), true).show();
    }
    */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
