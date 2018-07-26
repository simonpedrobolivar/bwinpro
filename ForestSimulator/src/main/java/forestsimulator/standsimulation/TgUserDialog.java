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
import javax.swing.*;

public class TgUserDialog extends JDialog {
    private final ResourceBundle messages = ResourceBundle.getBundle("forestsimulator/gui");
    UserLanguage Language;
    private final TgUser user = new TgUser(new File("."));
   
    public TgUserDialog(Frame parent, boolean modal) {
        super(parent, modal);
        if (user.fileExistsInWorkingDir("ForestSimulator.ini")) {
            System.out.println("Settings laden");
            user.loadSettings();
        }
        Language = UserLanguage.forLocale(user.getLanguageShort());
        initComponents();
        File f = new File(".");
        if (user.getProgramDir().isDirectory()) {
            loadModels();
        }
        userDirectoryTextField.setText(user.getProgramDir().getName());
        outputDirectoryTextField.setText(user.getWorkingDir().getName());
        dataDirectoryTextField.setText(user.getDataDir().getName());
        xmlFileComboBox.setSelectedItem(user.plugIn);
        languageSelector.setSelectedItem(Language);
        standGraphicComboBox.setSelectedIndex(user.grafik3D);
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
        userDirectoryLabel = new javax.swing.JLabel();
        userDirectoryTextField = new javax.swing.JTextField();
        // "vor"
        searchUserDirectoryButton = new javax.swing.JButton();
        // hinter
        applyButton = new javax.swing.JButton();
        outputDirectoryTextField = new javax.swing.JTextField();
        searchOutputDirectoryButton = new javax.swing.JButton();
        outputDirectoryLabel = new javax.swing.JLabel();
        dataDirectoryLabel = new javax.swing.JLabel();
        dataDirectoryTextField = new javax.swing.JTextField();
        searchDataDirectoryButton = new javax.swing.JButton();
        standGraphicComboBox = new javax.swing.JComboBox();
        xmlFileLabel = new javax.swing.JLabel();
        xmlFileComboBox = new javax.swing.JComboBox();

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

        userDirectoryLabel.setText(bundle.getString("TgUserDialog.userDirectoryLabel.text")); // NOI18N
        getContentPane().add(userDirectoryLabel);
        userDirectoryLabel.setBounds(20, 60, 390, 14);

        userDirectoryTextField.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        userDirectoryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userDirectoryTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(userDirectoryTextField);
        userDirectoryTextField.setBounds(20, 80, 450, 19);

        searchUserDirectoryButton.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        searchUserDirectoryButton.setText(bundle.getString("TgUserDialog.searchUserDirectoryButton.text")); // NOI18N
        searchUserDirectoryButton.setAlignmentY(0.0F);
        searchUserDirectoryButton.setMinimumSize(new java.awt.Dimension(100, 25));
        searchUserDirectoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserDirectoryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchUserDirectoryButton);
        searchUserDirectoryButton.setBounds(500, 80, 80, 20);

        applyButton.setText(bundle.getString("TgUserDialog.applyButton.text")); // NOI18N
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(applyButton);
        applyButton.setBounds(320, 290, 280, 23);

        outputDirectoryTextField.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        getContentPane().add(outputDirectoryTextField);
        outputDirectoryTextField.setBounds(20, 190, 450, 19);

        searchOutputDirectoryButton.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        searchOutputDirectoryButton.setText(bundle.getString("TgUserDialog.searchOutputDirectoryButton.text")); // NOI18N
        searchOutputDirectoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchOutputDirectoryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchOutputDirectoryButton);
        searchOutputDirectoryButton.setBounds(500, 190, 80, 21);

        outputDirectoryLabel.setText(bundle.getString("TgUserDialog.outputDirectoryLabel.text")); // NOI18N
        getContentPane().add(outputDirectoryLabel);
        outputDirectoryLabel.setBounds(20, 170, 390, 14);

        dataDirectoryLabel.setText(bundle.getString("TgUserDialog.dataDirectoryLabel.text")); // NOI18N
        getContentPane().add(dataDirectoryLabel);
        dataDirectoryLabel.setBounds(20, 110, 240, 14);

        dataDirectoryTextField.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        getContentPane().add(dataDirectoryTextField);
        dataDirectoryTextField.setBounds(20, 130, 450, 20);

        searchDataDirectoryButton.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        searchDataDirectoryButton.setText(bundle.getString("TgUserDialog.searchDataDirectoryButton.text")); // NOI18N
        searchDataDirectoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDataDirectoryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchDataDirectoryButton);
        searchDataDirectoryButton.setBounds(500, 130, 80, 21);

        standGraphicComboBox.setModel(new DefaultComboBoxModel(StandGraphicMode.values()));
        standGraphicComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standGraphicComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(standGraphicComboBox);
        standGraphicComboBox.setBounds(360, 20, 150, 20);

        xmlFileLabel.setText(bundle.getString("TgUserDialog.xmlFileLabel.text")); // NOI18N
        getContentPane().add(xmlFileLabel);
        xmlFileLabel.setBounds(20, 230, 140, 14);

        getContentPane().add(xmlFileComboBox);
        xmlFileComboBox.setBounds(20, 250, 450, 20);

        setSize(new java.awt.Dimension(651, 377));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void standGraphicComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standGraphicComboBoxActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_standGraphicComboBoxActionPerformed

    private void languageSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageSelectorActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_languageSelectorActionPerformed

    private void searchDataDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDataDirectoryButtonActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.setCurrentDirectory(user.getWorkingDir());
        jf.setDialogTitle(messages.getString("TgUserDialog.chooseDataDirDialog.title"));
        jf.showOpenDialog(this);
        File DataDir = jf.getSelectedFile();        
        dataDirectoryTextField.setText(DataDir.getAbsolutePath());
    }//GEN-LAST:event_searchDataDirectoryButtonActionPerformed

    private void searchOutputDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchOutputDirectoryButtonActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.setCurrentDirectory(user.getWorkingDir());
        jf.showOpenDialog(this);
        File WorkingDir = jf.getSelectedFile();
        outputDirectoryTextField.setText(WorkingDir.getAbsolutePath());
    }//GEN-LAST:event_searchOutputDirectoryButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        try {
            saveSettings();
            JTextArea about = new JTextArea(messages.getString("TgUserDialog.applySettingsDialog.message"));
            JOptionPane.showMessageDialog(this, about, messages.getString("TgUserDialog.applySettingsDialog.title"), JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            dispose();
        } catch (IOException e) {
            System.out.println("Error! writing File standsimulation.ini");
        }
    }//GEN-LAST:event_applyButtonActionPerformed

    private void saveSettings() throws IOException {
        UserLanguage.LanguageEntry selectedLanguage = (UserLanguage.LanguageEntry) languageSelector.getSelectedItem();
        int g3D = 0;
        if (standGraphicComboBox.getSelectedIndex()>0) g3D=1;
        user.saveSettings(userDirectoryTextField.getText(),
                dataDirectoryTextField.getText(),
                outputDirectoryTextField.getText(),
                selectedLanguage.language.locale(),
                (String) xmlFileComboBox.getSelectedItem(),
                g3D);
    }

    private void userDirectoryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDirectoryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userDirectoryTextFieldActionPerformed

    private void searchUserDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUserDirectoryButtonActionPerformed
        javax.swing.JFileChooser jf = new javax.swing.JFileChooser();
        jf.setCurrentDirectory(user.getWorkingDir());
        jf.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jf.setDialogTitle(messages.getString("TgUserDialog.chooseUserDirDialog.title"));
        int k = jf.showOpenDialog(this);
        File ProgramDir = jf.getSelectedFile();
        userDirectoryTextField.setText(ProgramDir.getAbsolutePath());
        loadModels();
    }//GEN-LAST:event_searchUserDirectoryButtonActionPerformed

    private void loadModels() {
        xmlFileComboBox.removeAllItems();
        File modelDirectory = new File(user.getProgramDir(), "models");
        if (!modelDirectory.isDirectory()) {
            return;
        }
// Liste mit Dateien erstellen 
        String entries[] = modelDirectory.list();
        for (String entry : entries) {
            if (entry.indexOf(".xml") > 0) {
                xmlFileComboBox.addItem(entry);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JLabel dataDirectoryLabel;
    private javax.swing.JTextField dataDirectoryTextField;
    private javax.swing.JLabel languageLabel;
    private javax.swing.JComboBox languageSelector;
    private javax.swing.JLabel outputDirectoryLabel;
    private javax.swing.JTextField outputDirectoryTextField;
    private javax.swing.JButton searchDataDirectoryButton;
    private javax.swing.JButton searchOutputDirectoryButton;
    private javax.swing.JButton searchUserDirectoryButton;
    private javax.swing.JComboBox standGraphicComboBox;
    private javax.swing.JLabel userDirectoryLabel;
    private javax.swing.JTextField userDirectoryTextField;
    private javax.swing.JComboBox xmlFileComboBox;
    private javax.swing.JLabel xmlFileLabel;
    // End of variables declaration//GEN-END:variables

}
