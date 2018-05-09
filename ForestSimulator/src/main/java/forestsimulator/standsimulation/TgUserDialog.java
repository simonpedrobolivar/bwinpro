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
import forestsimulator.language.UserLanguage;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TgUserDialog extends JDialog {
    private final ResourceBundle messages = ResourceBundle.getBundle("forestsimulator/gui");
    File WorkingDir;
    File ProgramDir;
    File DataDir;
    UserLanguage Language;
    File localPath;
    String XMLSettings = "";
    String plugIn = "";
    File verzeichnis;
    File localF = null;
    private TgUser user = new TgUser(new File("."));
   
    public TgUserDialog(Frame parent, boolean modal) {
        super(parent, modal);
        if (user.fileExists("ForestSimulator.ini")) {
            System.out.println("Settings laden");
            user.loadSettings();
              
            ProgramDir=user.getProgramDir();
            WorkingDir=user.getWorkingDir();
            DataDir=user.getDataDir();
            XMLSettings=user.getXMLSettings();
            plugIn = user.getPlugIn();
        }
        Language = UserLanguage.forLocale(user.getLanguageShort());
        initComponents();
        File f = new File(".");
        try {
            localPath= f.getCanonicalFile();
        } catch (IOException e) {
            Logger.getLogger(TgUserDialog.class.getName()).log(Level.SEVERE, "Problem getting working directory: {0}", e.getMessage());
        }
        if (user.getProgramDir().isDirectory()) {
            loadModels();
        }
        jTextField1.setText(ProgramDir.getName());
        jTextField2.setText(WorkingDir.getName());
        jTextField3.setText(DataDir.getName());
        jComboBox2.setSelectedItem(plugIn);
// PlugIn Model
        languageSelector.setSelectedItem(Language);
        jComboBox3.setSelectedIndex(user.grafik3D);
    }

    private ComboBoxModel languageOptions() {
        return new DefaultComboBoxModel(UserLanguage.entriesFor(Language.locale()));
    }
    
    private UserLanguage.LanguageEntry activeLanguage() {
        return new UserLanguage.LanguageEntry(Language, Language.locale());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        languageLabel = new javax.swing.JLabel();
        languageSelector = new javax.swing.JComboBox();
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
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("forestsimulator/gui"); // NOI18N
        setTitle(bundle.getString("TgUserDialog.title")); // NOI18N
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(null);

        languageLabel.setText(bundle.getString("TgUserDialog.languageLabel.text")); // NOI18N
        getContentPane().add(languageLabel);
        languageLabel.setBounds(20, 20, 70, 14);

        languageSelector.setModel(languageOptions());
        languageSelector.setSelectedItem(activeLanguage());
        languageSelector.setName("languageSelector"); // NOI18N
        languageSelector.setPreferredSize(new java.awt.Dimension(100, 22));
        languageSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageSelectorActionPerformed(evt);
            }
        });
        getContentPane().add(languageSelector);
        languageSelector.setBounds(80, 20, 100, 22);

        jLabel2.setText(bundle.getString("TgUserDialog.jLabel2.text")); // NOI18N
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
        jButton1.setText(bundle.getString("TgUserDialog.jButton1.text")); // NOI18N
        jButton1.setAlignmentY(0.0F);
        jButton1.setMinimumSize(new java.awt.Dimension(100, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(500, 80, 80, 20);

        jButton2.setText(bundle.getString("TgUserDialog.jButton2.text")); // NOI18N
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
        jButton4.setText(bundle.getString("TgUserDialog.jButton4.text")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(500, 190, 80, 21);

        jLabel3.setText(bundle.getString("TgUserDialog.jLabel3.text")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 170, 390, 14);

        jLabel5.setText(bundle.getString("TgUserDialog.jLabel5.text")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 110, 240, 14);

        jTextField3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        getContentPane().add(jTextField3);
        jTextField3.setBounds(20, 130, 450, 20);

        jButton5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        jButton5.setText(bundle.getString("TgUserDialog.jButton5.text")); // NOI18N
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

        jLabel6.setText(bundle.getString("TgUserDialog.jLabel6.text")); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 230, 140, 14);

        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(20, 250, 450, 20);

        setSize(new java.awt.Dimension(651, 377));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void languageSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageSelectorActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_languageSelectorActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.setCurrentDirectory(localPath);
        jf.setDialogTitle(messages.getString("TgUserDialog.chooseDataDirDialog.title"));
        jf.showOpenDialog(this);
        DataDir = jf.getSelectedFile();        
        jTextField3.setText(DataDir.getAbsolutePath());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.setCurrentDirectory(localPath);
        jf.showOpenDialog(this);
        WorkingDir = jf.getSelectedFile();
        jTextField2.setText(WorkingDir.getAbsolutePath());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            saveSettings();
            JTextArea about = new JTextArea(messages.getString("TgUserDialog.applySettingsDialog.message"));
            JOptionPane.showMessageDialog(this, about, "TgUserDialog.applySettingsDialog.title", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            dispose();
        } catch (IOException e) {
            System.out.println("Error! writing File standsimulation.ini");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveSettings() throws IOException {
        UserLanguage.LanguageEntry selectedLanguage = (UserLanguage.LanguageEntry) languageSelector.getSelectedItem();
        int g3D = 0;
        if (jComboBox3.getSelectedIndex()>0) g3D=1;
        user.saveSettings(jTextField1.getText(),
                jTextField3.getText(),
                jTextField2.getText(),
                selectedLanguage.language.locale(),
                (String) jComboBox2.getSelectedItem(),
                g3D);
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        javax.swing.JFileChooser jf = new javax.swing.JFileChooser();
        jf.setCurrentDirectory(localPath);
        jf.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
//        jf.setDialogTitle(messages.getString("choose_User_Dir"));
        int k = jf.showOpenDialog(this);
        ProgramDir = jf.getSelectedFile();
        jTextField1.setText(ProgramDir.getAbsolutePath());
        loadModels();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadModels() {
        jComboBox2.removeAllItems();
        File modelDirectory = new File(ProgramDir, "models");
// Liste mit Dateien erstellen 
        String entries[] = modelDirectory.list();
        for (String entry : entries) {
            if (entry.indexOf(".xml") > 0) {
                jComboBox2.addItem(entry);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel languageLabel;
    private javax.swing.JComboBox languageSelector;
    // End of variables declaration//GEN-END:variables

}
