/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forestsimulator.SQLite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import treegross.base.FunctionInterpreter;
import treegross.base.GenDistribution;
import treegross.base.GenerateXY;
import treegross.base.SIofDistrib;
import treegross.base.Stand;
import treegross.base.StandFactory;
import treegross.base.Tree;

/**
 *
 * @author nagel
 */
public class JPanelNutzungsplaner extends javax.swing.JPanel {
     Stand st = null;
     File dir = null;
     javax.swing.table.DefaultTableModel dataTable1= new javax.swing.table.DefaultTableModel(
            new Object [][] {  },
            new String [] {
               "Name", "Art", "Schicht","Mischung", "Alter", "Höhe", "G/ha"
            }
        );
     Object[] rowData1={" "," "," "," "," "," "," "};
     String bestaende[] = new String[1000];
     String bestand = "";
     int nBestaende =0;

     
     
     
    /**
     * Creates new form JPanelNutzungsplaner
     */
    public JPanelNutzungsplaner(Stand stx, File dirx) throws IOException {
        initComponents();
        st = stx;
        dir = new File(dirx, "nutzungsplaner.db");
        String localPath="";
        File fi = new File("", "sqlnp.ini");
        if (fi.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(fi))) {
                dir = new File(in.readLine());
            } catch (Exception e) {
                dir = new File(dirx, "nutzungsplaner.db");
            }
        }
        if (dir.exists()) {
            filenameLabel.setText(dir.getCanonicalPath());
        }
        else {
           JFileChooser fc = new JFileChooser();
           DBFileFilter txtFilter = new DBFileFilter();
           txtFilter.setExtension("db");
           fc.addChoosableFileFilter(txtFilter);
           int auswahl = fc.showOpenDialog(this);
           dir = fc.getSelectedFile();
        }
        filenameLabel.setText(dir.getCanonicalPath());
        setVisible(true);
        nBestaende=loadBestaende();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        filenameLabel = new javax.swing.JLabel();
        changeDatabaseButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        searchStandLabel = new javax.swing.JLabel();
        standNameTextField = new javax.swing.JTextField();
        areaLabel = new javax.swing.JLabel();
        areaTextField = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        forwardButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("forestsimulator/gui"); // NOI18N
        filenameLabel.setText(bundle.getString("JPanelNutzungsplaner.filenameLabel.text")); // NOI18N
        jPanel2.add(filenameLabel);

        changeDatabaseButton.setText(bundle.getString("JPanelNutzungsplaner.changeDatabaseButton.text")); // NOI18N
        changeDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeDatabaseButtonActionPerformed(evt);
            }
        });
        jPanel2.add(changeDatabaseButton);

        add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        searchStandLabel.setText(bundle.getString("JPanelNutzungsplaner.searchStandLabel.text")); // NOI18N
        jPanel1.add(searchStandLabel);

        standNameTextField.setText(bundle.getString("JPanelNutzungsplaner.standNameTextField.text")); // NOI18N
        standNameTextField.setPreferredSize(new java.awt.Dimension(232, 20));
        jPanel1.add(standNameTextField);

        areaLabel.setText(bundle.getString("JPanelNutzungsplaner.areaLabel.text")); // NOI18N
        jPanel1.add(areaLabel);

        areaTextField.setText(bundle.getString("JPanelNutzungsplaner.areaTextField.text")); // NOI18N
        areaTextField.setMinimumSize(new java.awt.Dimension(26, 20));
        areaTextField.setPreferredSize(new java.awt.Dimension(42, 20));
        jPanel1.add(areaTextField);

        findButton.setText(bundle.getString("JPanelNutzungsplaner.findButton.text")); // NOI18N
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });
        jPanel1.add(findButton);

        forwardButton.setText(bundle.getString("JPanelNutzungsplaner.forwardButton.text")); // NOI18N
        forwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardButtonActionPerformed(evt);
            }
        });
        jPanel1.add(forwardButton);

        backButton.setText(bundle.getString("JPanelNutzungsplaner.backButton.text")); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(dataTable1);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        // In der Datenbank nach Namen suchen und Tabelle fuellen 
       loadBestand();
    }//GEN-LAST:event_findButtonActionPerformed

    private void forwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardButtonActionPerformed
        // next Stand
        int merk =0;
        for (int i=0;i < nBestaende;i++){
            if (bestaende[i].equals(standNameTextField.getText())) { 
                merk = i;
                break;
            }
        }
        if ( merk < nBestaende-1) {
            merk = merk+1;
            standNameTextField.setText(bestaende[merk].toString());
        }
        loadBestand();
    }//GEN-LAST:event_forwardButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // back
                // next Stand
        int merk =0;
        for (int i=0;i < nBestaende;i++){
            if (bestaende[i].equals(standNameTextField.getText())) { 
                merk = i;
                break;
            }
        }
        if ( merk > 0) {
            merk = merk-1;
            standNameTextField.setText(bestaende[merk].toString());
        }
        loadBestand();
    }//GEN-LAST:event_backButtonActionPerformed

    private void changeDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeDatabaseButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        DBFileFilter dbFilter = new DBFileFilter();
        dbFilter.setExtension("db");
        fc.addChoosableFileFilter(dbFilter);
        fc.setFileFilter(dbFilter); 
        fc.setAcceptAllFileFilterUsed(true);
        fc.setCurrentDirectory(dir);
 
        int auswahl = fc.showOpenDialog(this);
        try {
           dir = fc.getSelectedFile();
           filenameLabel.setText(dir.getCanonicalPath());
           setVisible(true);
           nBestaende=loadBestaende();
        }
        catch (Exception eio){System.out.println(eio);}  
        
    }//GEN-LAST:event_changeDatabaseButtonActionPerformed

    private double setdbh(int code, double a, double h){
        double dgx = 0.0;
        int art = 211;
        if (code < 211) art=111;
        if (code > 500 ) art = 511;
        if (code == 611) art = 611;
        if (code == 711) art = 711;
        if (art == 111) dgx = 2.2133044+0.3372101*a-0.0005661*a*a-0.3666360*h+0.0302228*h*h;
        if (art == 211) dgx = 3.009+0.275*a-0.0004572*a*a-0.3646*h+0.0265*h*h;
        if (art == 511) dgx = 4.999+0.27*a-0.0009989*a*a+0.3669*h+0.0093306*h*h;
        if (art == 611) dgx = 1.3719960+0.5216833*a-0.0019608*a*a+0.2648483*h+0.0116218*h*h;
        if (art == 711) dgx = 0.4691+0.2676*a-0.00067*a*a+0.447*h+0.009401*h*h;
        if (dgx < 7.0) dgx = 7.0;

        dgx =  Math.round(dgx*10.0)/10.0;
        return dgx;
    }
    
    private double setdmax(int code, double dgx, double h){
        double dgm = 0.0;
        int art = 211;
        if (code < 211) art=111;
        if (code > 500 ) art = 511;
        if (code == 611) art = 611;
        if (code == 711) art = 711;
        if (dgx < 7.0) dgx = 7.0;

        dgx =  Math.round(dgx*10.0)/10.0;
        if (art == 111) dgm = 9.35514+1.19655*dgx+0.31098*h;
        if (art == 211) dgm = 9.60310+0.97132*dgx+0.55732*h;
        if (art == 511) dgm = 9.56268+1.15093*dgx+0.24856*h;
        if (art == 611) dgm = 1.9660+1.9492*dgx-0.4995*h;
        if (art == 711) dgm = 10.10099+1.04032*dgx+0.30663*h;
        dgm =  Math.round(dgm*10.0)/10.0;
        return dgm;
    }
    
    private int loadBestaende(){
        int m = 0;
        try (Connection cn = DriverManager.getConnection("jdbc:sqlite:" + dir, "", ""); Statement statement = cn.createStatement()) {
            String namAlt = "";
            String name = "neu";
            try (ResultSet rs = statement.executeQuery("SELECT * FROM Nutzungsplanung ")) {
                while (rs.next()) {
                    name = rs.getString("name");
                    if (name.equals(namAlt) == false) {
                        bestaende[m] = name;
                        namAlt = name;
                        m = m + 1;
                    }
                }
            }
        } catch (SQLException eio) {
            System.out.println(eio);
        }
        return m;
    }
    
    private void loadBestand(){
        for (int i = dataTable1.getRowCount(); i > 0; i = i - 1) {
            dataTable1.removeRow(i - 1);
        }
        try (Connection cn = DriverManager.getConnection("jdbc:sqlite:" + dir, "", ""); Statement statement = cn.createStatement()) {
            String name = standNameTextField.getText();
            try (ResultSet rs = statement.executeQuery("SELECT * FROM Nutzungsplanung WHERE name = '" + name + "'")) {
                int m = 0;
                while (rs.next()) {
                    dataTable1.addRow(rowData1);
                    String nam = rs.getString("name");
                    jTable1.setValueAt(nam, m, 0);
                    String art = rs.getString("art");
                    jTable1.setValueAt(art, m, 1);
                    String schicht = rs.getString("schicht");
                    jTable1.setValueAt(schicht, m, 2);
                    String mischung = rs.getString("mischung");
                    jTable1.setValueAt(mischung, m, 3);
                    String alt = rs.getString("alt");
                    jTable1.setValueAt(alt, m, 4);
                    String hoehe = rs.getString("hoehe");
                    jTable1.setValueAt(hoehe, m, 5);
                    String gha = rs.getString("gha");
                    jTable1.setValueAt(gha, m, 6);
                    m = m + 1;
                }
            }
        } catch (SQLException eio) {
            System.out.println(eio);
        }
    }
 
    public Stand createStand(){
        double size= Double.parseDouble(areaTextField.getText());
        StandFactory.newStand(st, standNameTextField.getText(), size);
        st.year=2015;
        //Schichten einlesen
        for (int i=0; i<dataTable1.getRowCount() ; i++){
             int art = Integer.parseInt(jTable1.getValueAt(i,1).toString());
             double hg = Double.parseDouble(jTable1.getValueAt(i,5).toString());  
             double g = Double.parseDouble(jTable1.getValueAt(i,6).toString());
             int alt = Integer.parseInt(jTable1.getValueAt(i,4).toString());
             double dg = setdbh(art,alt,hg);
             double dm = setdmax(art, dg, hg);
                        if ( hg > 5.0 && dg > 7.0 && g > 0.0){
             try {
                 GenDistribution gdb = new GenDistribution();
                 gdb.weibull(st, art, alt, dg, hg, dm, g * st.size,false);

                 SIofDistrib siod = new SIofDistrib();
                 FunctionInterpreter fi = new FunctionInterpreter();
                 siod.si(st, art, alt, dg, hg);
                 for (int j = 0; j < st.ntrees; j++) {
                    if (st.tr[j].h == 0.0) {
                       Tree tree = new Tree();
                       tree.code = art;
                       tree.sp = st.tr[j].sp;
                       tree.sp.dg = dg;
                       tree.sp.hg = hg;
                       tree.sp.h100 = 0.0;
                       tree.sp.d100 = 0.0;
                       tree.d = st.tr[j].d;
                       tree.code = st.tr[j].code;
                       tree.sp = st.tr[j].sp;
                       tree.st = st;
//                                st.tr[j].h = fi.getValueForTree(tree, tree.sp.spDef.uniformHeightCurveXML) + fi.getValueForTree(tree, tree.sp.spDef.heightVariationXML) * nd.value(3.0);
                       st.tr[j].h = fi.getValueForTree(tree, tree.sp.spDef.uniformHeightCurveXML) ;
                    }
                 }
                 for (int j = 0; j < st.ntrees; j++) {
                      st.tr[j].setMissingData();
                 }
                 GenerateXY gxy = new GenerateXY();
                 gxy.setGroupRadius(0.0);
                 gxy.zufall(st);
                 st.sortbyd();
                 st.descspecies();
               } catch (Exception ex) {}
           
             }
       }
       return(st);

    }
    
    public void saveSetting(){
        java.io.File f = new java.io.File(""); 
        String localPath="";
        try{ 
           localPath= f.getCanonicalPath();
          } catch (Exception e){ }
        String finame = localPath+System.getProperty("file.separator")+"sqlnp.ini";

        try
        {
            java.io.PrintWriter ausgabe = new java.io.PrintWriter(new java.io.FileWriter(finame));
            ausgabe.println(dir);
            ausgabe.close();
        }
        catch(java.io.IOException e){}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areaLabel;
    private javax.swing.JTextField areaTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JButton changeDatabaseButton;
    private javax.swing.JLabel filenameLabel;
    private javax.swing.JButton findButton;
    private javax.swing.JButton forwardButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel searchStandLabel;
    private javax.swing.JTextField standNameTextField;
    // End of variables declaration//GEN-END:variables
}
