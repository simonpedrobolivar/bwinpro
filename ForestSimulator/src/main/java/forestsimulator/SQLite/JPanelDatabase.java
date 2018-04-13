/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forestsimulator.SQLite;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import treegross.base.GenerateXY;
import treegross.base.SpeciesNotDefinedException;
import treegross.base.Stand;

/**
 *
 * @author nagel
 */
public class JPanelDatabase extends JPanel {
    Stand st = null;
    File dir = null;

    String bestaende[] = new String[1000];
    String bestand = "";
    int nBestaende = 0;
    int standID = -9;

    public JPanelDatabase(Stand stx, File dirx) throws IOException {
        initComponents();
        st = stx;
        dir = new File(dirx, "fsdatabase.db");
        String localPath = "";
        java.io.File f1 = new java.io.File("");
        try {
            localPath = f1.getCanonicalPath();
        } catch (Exception e) {
        }
        if (dir.exists()) {
            filenameLabel.setText(dir.getCanonicalPath());
        } else {
            JFileChooser fc = new JFileChooser();
            DBFileFilter txtFilter = new DBFileFilter();
            txtFilter.setExtension("db");
            fc.addChoosableFileFilter(txtFilter);
            int auswahl = fc.showOpenDialog(this);
            dir = fc.getSelectedFile();
        }
        filenameLabel.setText(dir.getCanonicalPath());
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        filenameLabel = new javax.swing.JLabel();
        changeDatabaseButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        standIdHeading = new javax.swing.JLabel();
        standNameHeading = new javax.swing.JLabel();
        yearHeading = new javax.swing.JLabel();
        areaSizeHeading = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        navigateToFirstButton = new javax.swing.JButton();
        navigateBackButton = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        saveActiveStandButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        navigateForwardButton = new javax.swing.JButton();
        navigateToLastButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("forestsimulator/gui"); // NOI18N
        filenameLabel.setText(bundle.getString("JPanelDatabase.filenameLabel.text")); // NOI18N
        jPanel1.add(filenameLabel);

        changeDatabaseButton.setText(bundle.getString("JPanelDatabase.changeDatabaseButton.text")); // NOI18N
        changeDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeDatabaseButtonActionPerformed(evt);
            }
        });
        jPanel1.add(changeDatabaseButton);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.GridLayout(2, 4));

        standIdHeading.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        standIdHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        standIdHeading.setText(bundle.getString("JPanelDatabase.standIdHeading.text")); // NOI18N
        standIdHeading.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        standIdHeading.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(standIdHeading);

        standNameHeading.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        standNameHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        standNameHeading.setText(bundle.getString("JPanelDatabase.standNameHeading.text")); // NOI18N
        standNameHeading.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        standNameHeading.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(standNameHeading);

        yearHeading.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        yearHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearHeading.setText(bundle.getString("JPanelDatabase.yearHeading.text")); // NOI18N
        yearHeading.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        yearHeading.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(yearHeading);

        areaSizeHeading.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        areaSizeHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        areaSizeHeading.setText(bundle.getString("JPanelDatabase.areaSizeHeading.text")); // NOI18N
        areaSizeHeading.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        areaSizeHeading.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(areaSizeHeading);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jLabel8);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jLabel9);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jLabel10);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jLabel11);

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel6.setLayout(new java.awt.GridLayout(1, 4));

        navigateToFirstButton.setText(bundle.getString("JPanelDatabase.navigateToFirstButton.text")); // NOI18N
        navigateToFirstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navigateToFirstButtonActionPerformed(evt);
            }
        });
        jPanel6.add(navigateToFirstButton);

        navigateBackButton.setText(bundle.getString("JPanelDatabase.navigateBackButton.text")); // NOI18N
        navigateBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navigateBackButtonActionPerformed(evt);
            }
        });
        jPanel6.add(navigateBackButton);

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        jPanel6.add(searchTextField);

        searchButton.setText(bundle.getString("JPanelDatabase.searchButton.text")); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel6.add(searchButton);

        saveActiveStandButton.setBackground(new java.awt.Color(246, 187, 239));
        saveActiveStandButton.setText(bundle.getString("JPanelDatabase.saveActiveStandButton.text")); // NOI18N
        saveActiveStandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActiveStandButtonActionPerformed(evt);
            }
        });
        jPanel6.add(saveActiveStandButton);

        deleteButton.setText(bundle.getString("JPanelDatabase.deleteButton.text")); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel6.add(deleteButton);

        navigateForwardButton.setText(bundle.getString("JPanelDatabase.navigateForwardButton.text")); // NOI18N
        navigateForwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navigateForwardButtonActionPerformed(evt);
            }
        });
        jPanel6.add(navigateForwardButton);

        navigateToLastButton.setText(bundle.getString("JPanelDatabase.navigateToLastButton.text")); // NOI18N
        navigateToLastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navigateToLastButtonActionPerformed(evt);
            }
        });
        jPanel6.add(navigateToLastButton);

        jPanel3.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

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
//           nBestaende=loadBestaende();
        }
        catch (Exception eio){System.out.println(eio);}  
    }//GEN-LAST:event_changeDatabaseButtonActionPerformed

    private void saveActiveStandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActiveStandButtonActionPerformed
        // save stand to database
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dir, "", "")) {
            try (PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO stand (name, size_ha, month, year, lat, lon, masl, region, district, sitetype, exposition_gon, "
                    + "slope_percentage) VALUES "
                    + "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                stm.setString(1, st.standname);
                stm.setDouble(2, st.size);
                stm.setInt(3, st.monat);
                stm.setInt(4, st.year);
                stm.setDouble(5, st.hochwert_m);
                stm.setDouble(6, st.rechtswert_m);
                stm.setDouble(7, st.hoehe_uNN_m);
                stm.setString(8, st.wuchsgebiet);
                stm.setString(9, st.wuchsgebiet);
                stm.setString(10, st.standort);
                stm.setInt(11, st.exposition_Gon);
                stm.setDouble(12, st.hangneigungProzent);
                stm.execute();
            }
            //  Bestandes ID merken
            standID = -9;
            try (Statement stm = connection.createStatement(); ResultSet rs = stm.executeQuery("SELECT _id FROM stand ORDER BY _id DESC LIMIT 1;")) {
                while (rs.next()) {
                    standID = rs.getInt("_id");
                }
            }
            System.out.println("Letzte Id: = " + standID);
            try (PreparedStatement ps = connection.prepareStatement("INSERT INTO cornerpoints (standid, name, x, y, z) VALUES (?, ?, ?, ?, ?)")) {
                ps.setInt(1, standID);
                ps.setString(2, st.center.no);
                ps.setDouble(3, st.center.x);
                ps.setDouble(4, st.center.y);
                ps.setDouble(5, st.center.z);
                ps.execute();
            }
            try (PreparedStatement ps = connection.prepareStatement("INSERT INTO cornerpoints (standid, name, x, y, z) VALUES (?, ?, ?, ?, ?")) {
                for (int i = 0; i < st.ncpnt; i++) {
                    ps.setInt(1, standID);
                    ps.setString(2, st.cpnt[i].no);
                    ps.setDouble(3, st.cpnt[i].x);
                    ps.setDouble(4, st.cpnt[i].y);
                    ps.setDouble(5, st.cpnt[i].z);
                    ps.execute();
                }
            }
//  alle Bäume speichern 
            try (PreparedStatement ps = connection.prepareStatement("INSERT INTO trees "
                    + "(standid, code, name, year, age, dbh, h, si, cb, cw, alive, status, x, y, z, crop, habitat, fac, remarks, layer) VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                for (int i = 0; i < st.ntrees; i++) {
                    ps.setInt(1, standID);
                    ps.setInt(2, st.tr[i].code);
                    ps.setString(3, st.tr[i].no);
                    ps.setInt(4, st.year);
                    ps.setInt(5, st.tr[i].age);
                    ps.setDouble(6, st.tr[i].d);
                    ps.setDouble(7, st.tr[i].h);
                    ps.setDouble(8, st.tr[i].si);
                    ps.setDouble(9, st.tr[i].cb);
                    ps.setDouble(10, st.tr[i].cw);
                    ps.setInt(11, st.tr[i].out);
                    ps.setInt(12, st.tr[i].outtype);
                    ps.setDouble(13, st.tr[i].x);
                    ps.setDouble(14, st.tr[i].y);
                    ps.setDouble(15, st.tr[i].z);
                    ps.setBoolean(16, st.tr[i].crop);
                    ps.setBoolean(17, st.tr[i].habitat);
                    ps.setDouble(18,st.tr[i].fac);
                    ps.setString(19, st.tr[i].remarks);
                    ps.setInt(20, st.tr[i].layer);
                    ps.execute();
                }
            }
        } catch (SQLException eio) {
            System.out.println(eio);
        }
        lastDataset();
    }//GEN-LAST:event_saveActiveStandButtonActionPerformed

    private void navigateToFirstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigateToFirstButtonActionPerformed
        // find First
        firstDataset();
    }//GEN-LAST:event_navigateToFirstButtonActionPerformed

    private void navigateToLastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigateToLastButtonActionPerformed
        // Find last record
       lastDataset();

    }//GEN-LAST:event_navigateToLastButtonActionPerformed

    private void navigateBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigateBackButtonActionPerformed
        try (Connection cn = DriverManager.getConnection("jdbc:sqlite:" + dir, "", "");
                PreparedStatement ps = cn.prepareStatement("SELECT _id FROM stand WHERE _id < ? ORDER BY _id DESC LIMIT 1")) {
            ps.setInt(1, standID);
            int idold = standID;
            standID = -9;
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    standID = rs.getInt("_id");
                }
            }
            if (standID == -9) {
                standID = idold;
            }
            jLabel8.setText(String.valueOf(standID));
        } catch (SQLException eio) {
            Logger.getLogger(JPanelDatabase.class.getName()).log(Level.SEVERE, "Problem with database", eio);
        }
        dispStandID();
    }//GEN-LAST:event_navigateBackButtonActionPerformed

    private void navigateForwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigateForwardButtonActionPerformed
        // Next standid
        nextDataset();
        dispStandID();
        // Find next
 
    }//GEN-LAST:event_navigateForwardButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // delete standID
        try (Connection cn = DriverManager.getConnection("jdbc:sqlite:" + dir, "", "" )) {
            try (PreparedStatement stm = cn.prepareStatement("DELETE FROM stand WHERE _id = ?")) {
                stm.setInt(1, standID);
                stm.execute();
            }
            try (PreparedStatement stm = cn.prepareStatement("DELETE FROM cornerpoints WHERE standid = ?")) {
                stm.setInt(1, standID);
                stm.execute();
            }
            try (PreparedStatement stm = cn.prepareStatement("DELETE FROM trees WHERE standid = ?")) {
                stm.setInt(1, standID);
                stm.execute();
            }
        } catch (SQLException eio){
            Logger.getLogger(JPanelDatabase.class.getName()).log(Level.SEVERE, "Problem with database", eio);
        } 
        int wert = nextDataset(); 
        if (wert < 0) {
            firstDataset();
        }
        dispStandID();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        //search stand first by id then by name
        String suche = searchTextField.getText();
        boolean found = false;
        try (Connection cn = DriverManager.getConnection("jdbc:sqlite:" + dir, "", "" )) {
            try (PreparedStatement stm = cn.prepareStatement("SELECT * FROM stand WHERE _id = ?")) {
                stm.setString(1, suche);
                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()){
                        standID = rs.getInt("_id");
                        found = true;
                    } 
                }
            }
            if (!found) {
                try (PreparedStatement stm = cn.prepareStatement("SELECT * FROM stand WHERE name like ?")) {
                    stm.setString(1, suche);
                    try (ResultSet rs = stm.executeQuery()) {
                        while (rs.next()){
                           standID = rs.getInt("_id");
                           found = true;
                        }
                    }                    
                }
            }
        } catch (Exception eio){System.out.println(eio);}  
        if (found) {
            dispStandID();
        } 
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void dispStandID(){
        try (Connection cn = DriverManager.getConnection("jdbc:sqlite:" + dir, "", "");
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM stand WHERE _id = ?")) {
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    jLabel8.setText(String.valueOf(standID));
                    jLabel9.setText(rs.getString("name"));
                    jLabel10.setText(String.valueOf(rs.getInt("year")));
                    jLabel11.setText(rs.getString("size_ha"));
                }
            }
        } catch (SQLException eio) {
            Logger.getLogger(JPanelDatabase.class.getName()).log(Level.SEVERE, "Problem with database", eio);
        }
    }
    
    private int nextDataset() {
        int erg = -9;
        try (Connection cn = DriverManager.getConnection("jdbc:sqlite:" + dir, "", "");
                PreparedStatement ps = cn.prepareStatement("SELECT _id FROM stand WHERE _id > ? ORDER BY _id LIMIT 1;")) {
            ps.setInt(1, standID);
            int idold = standID;
            standID = -9;
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    standID = rs.getInt("_id");
                    erg = standID;
                }
            }
            if (standID == -9) {
                standID = idold;
            }
            jLabel8.setText(String.valueOf(standID));
        } catch (SQLException eio) {
            Logger.getLogger(JPanelDatabase.class.getName()).log(Level.SEVERE, "Problem with database", eio);
        }
        dispStandID();
        return erg;
    }
    
    private int firstDataset() {
        int erg = -9;
        try (Connection cn = DriverManager.getConnection("jdbc:sqlite:" + dir, "", "");
                Statement stm = cn.createStatement()) {
            standID = -9;
            try (ResultSet rs = stm.executeQuery("SELECT _id FROM stand ORDER BY _id LIMIT 1;")) {
                while (rs.next()) {
                    standID = rs.getInt("_id");
                }
            }
            jLabel8.setText(String.valueOf(standID));
        } catch (SQLException eio) {
            Logger.getLogger(JPanelDatabase.class.getName()).log(Level.SEVERE, "Problem with database", eio);
        }
        dispStandID();
        return erg;
    }

    private int lastDataset() {
        int erg = -9;
        try (Connection cn = DriverManager.getConnection("jdbc:sqlite:" + dir, "", "");
                Statement stm = cn.createStatement()) {
            standID = -9;
            try (ResultSet rs = stm.executeQuery("SELECT _id FROM stand ORDER BY _id DESC LIMIT 1")) {
            while (rs.next()) {
                standID = rs.getInt("_id");
                erg = standID;
            }
            }
            jLabel8.setText(String.valueOf(standID));
        } catch (SQLException eio) {
            Logger.getLogger(JPanelDatabase.class.getName()).log(Level.SEVERE, "Problem with database", eio);
        }
        dispStandID();
        return erg;
    }

    public Stand createStand() {
        try (Connection cn = DriverManager.getConnection("jdbc:sqlite:" + dir, "", "");
                PreparedStatement stm = cn.prepareStatement("SELECT * FROM stand WHERE _id = ?")) {
            stm.setInt(1, standID);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    st.standname = rs.getString("name");
                    st.year = rs.getInt("year");
                    st.size = Double.parseDouble(rs.getString("size_ha"));
                    st.monat = rs.getInt("month");
                    st.rechtswert_m = Double.parseDouble(rs.getString("lat"));
                    st.hochwert_m = Double.parseDouble(rs.getString("lon"));
                    st.hoehe_uNN_m = Double.parseDouble(rs.getString("masl"));
                    st.wuchsgebiet = rs.getString("region");
                    st.wuchsbezirk = rs.getString("district");
                    st.standort = rs.getString("sitetype");
                    st.exposition_Gon = (int) (Math.round(Double.parseDouble(rs.getString("exposition_gon"))));
                    st.hangneigungProzent = Double.parseDouble(rs.getString("slope_percentage"));
                }
            }
            try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM cornerpoints WHERE standid = ?")) {
                ps.setInt(1, standID);
                try (ResultSet rs = ps.executeQuery()) {
                    st.ncpnt = 0;
                    while (rs.next()) {
                        String na = rs.getString("name");
                        if (na.contains("circle") || na.contains("polygon")) {
                            st.center.no = na;
                            st.center.x = Double.parseDouble(rs.getString("x"));
                            st.center.y = Double.parseDouble(rs.getString("y"));
                            st.center.z = Double.parseDouble(rs.getString("z"));
                        } else {
                            double xx = Double.parseDouble(rs.getString("x"));
                            double yy = Double.parseDouble(rs.getString("y"));
                            double zz = Double.parseDouble(rs.getString("z"));
                            st.addcornerpoint(na, xx, yy, zz);
                        }
                    }
                }
            }
            try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM trees WHERE standid = ?")) {
                ps.setInt(1, standID);
                try (ResultSet rs = stm.executeQuery()) {
                    st.ntrees = 0;
                    while (rs.next()) {
                        String na = rs.getString("name");
                        int cc = rs.getInt("code");
                        int aa = rs.getInt("age");
                        double dd = Double.parseDouble(rs.getString("dbh"));
                        double hh = Double.parseDouble(rs.getString("h"));
                        double si = Double.parseDouble(rs.getString("si"));
                        double ccb = Double.parseDouble(rs.getString("cb"));
                        double ccw = Double.parseDouble(rs.getString("cw"));
                        int oout = rs.getInt("alive");
                        int oouttype = rs.getInt("status");
                        boolean ccrop = Boolean.parseBoolean(rs.getString("crop"));
                        boolean hhabitat = Boolean.parseBoolean(rs.getString("habitat"));
                        boolean tz = false;
                        String rm = rs.getString("remarks");
                        double xx = Double.parseDouble(rs.getString("x"));
                        double yy = Double.parseDouble(rs.getString("y"));
                        double zz = Double.parseDouble(rs.getString("z"));
                        double ff = Double.parseDouble(rs.getString("fac"));
                        int lay = rs.getInt("layer");

                        int nclone = 1;
                        if (ff >= 2.0) {
                            nclone = (int) Math.floor(ff);
                            ff = ff / Math.floor(ff);
                        }
                        for (int k = 0; k < nclone; k++) {
                            String nam = na;
                            if (k > 0) {
                                nam = na + "_" + k;
                                xx = -9.0;
                                yy = -9.0;
                            }
                            st.addXMLTree(cc, nam, aa, oout, oouttype, dd, hh, ccb, ccw, si, ff, xx, yy, zz, ccrop, tz, hhabitat, 0, 0.0, rm);
                            st.tr[st.ntrees - 1].layer = lay;
                        }
                    }
                } catch (SpeciesNotDefinedException ex) {
                    Logger.getLogger(JPanelDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException eio) {
            Logger.getLogger(JPanelDatabase.class.getName()).log(Level.SEVERE, "Problem with database", eio);
        }
        st.missingData();
        GenerateXY gen = new GenerateXY();
        gen.zufall(st);
        st.descspecies();
        return (st);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areaSizeHeading;
    private javax.swing.JButton changeDatabaseButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel filenameLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton navigateBackButton;
    private javax.swing.JButton navigateForwardButton;
    private javax.swing.JButton navigateToFirstButton;
    private javax.swing.JButton navigateToLastButton;
    private javax.swing.JButton saveActiveStandButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel standIdHeading;
    private javax.swing.JLabel standNameHeading;
    private javax.swing.JLabel yearHeading;
    // End of variables declaration//GEN-END:variables
}
