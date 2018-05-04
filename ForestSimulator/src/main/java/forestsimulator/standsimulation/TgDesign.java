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

import java.awt.event.KeyEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import treegross.base.*;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.*;
import org.jdom.DocType;
import java.util.*;
import java.net.*;

import javax.swing.*;

public class TgDesign extends JPanel {

    Stand st = new Stand();
    TgJFrame frame;
    File programDir;

    public TgDesign(Stand st1, TgJFrame parent, Locale preferredLanguage) {
        st = st1;
        frame = parent;
        programDir = parent.programDir;
        initComponents();
        rasterLabel.setVisible(false);
        rasterXTextField.setVisible(false);
        rasterYTextField.setVisible(false);
        startPositionLabel.setVisible(false);
        startXTextField.setVisible(false);
        startYTextField.setVisible(false);
//        jLabel5.setText(messages.getString("age"));
//        jLabel6.setText(messages.getString("Dg"));
//        jLabel7.setText(messages.getString("Dmax"));
//        jLabel8.setText(messages.getString("Hg"));
//        jLabel9.setText(messages.getString("Basal_area"));
//        jButton2.setText(messages.getString("start_creating"));
//        jLabel1.setText(messages.getString("Site_index"));
//        jLabel3.setText(messages.getString("Raster"));
//        jLabel2.setText(messages.getString("Start"));
//        jComboBox2.removeAllItems();
//        jComboBox2.addItem(messages.getString("create_distribution"));
//        jComboBox2.addItem(messages.getString("create_tree"));
//        jComboBox2.addItem(messages.getString("regeneration"));
//        jComboBox1.removeAllItems();
//        jComboBox1.addItem(messages.getString("random_coordinates"));
//        jComboBox1.addItem(messages.getString("raster_coordinates"));
//        jCheckBox1.setText(messages.getString("skidtrails"));
//        jLabel13.setText(messages.getString("layer"));
        loadSpecies(programDir.getPath());
        setdbh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        speciesCodeLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        diameterLabel = new javax.swing.JLabel();
        maxDiameterLabel = new javax.swing.JLabel();
        heightLabel = new javax.swing.JLabel();
        basalAreaLabel = new javax.swing.JLabel();
        td2 = new javax.swing.JTextField();
        td3 = new javax.swing.JTextField();
        td4 = new javax.swing.JTextField();
        td5 = new javax.swing.JTextField();
        td6 = new javax.swing.JTextField();
        speciesCodeComboBox = new javax.swing.JComboBox();
        startButton = new javax.swing.JButton();
        siteIndexLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        rasterLabel = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();
        rasterXTextField = new javax.swing.JTextField();
        rasterYTextField = new javax.swing.JTextField();
        startPositionLabel = new javax.swing.JLabel();
        startXTextField = new javax.swing.JTextField();
        startYTextField = new javax.swing.JTextField();
        developmentCheckBox = new javax.swing.JCheckBox();
        distanceLabel = new javax.swing.JLabel();
        distanceTextField = new javax.swing.JTextField();
        widthLabel = new javax.swing.JLabel();
        widthTextField = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox();
        mixtureLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();

        setMaximumSize(new java.awt.Dimension(330, 407));
        setMinimumSize(new java.awt.Dimension(322, 407));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(187, 242, 242));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("forestsimulator/gui"); // NOI18N
        speciesCodeLabel.setText(bundle.getString("TgDesign.speciesCodeLabel.text")); // NOI18N
        jPanel2.add(speciesCodeLabel);
        speciesCodeLabel.setBounds(20, 40, 140, 14);

        ageLabel.setText(bundle.getString("TgDesign.ageLabel.text")); // NOI18N
        jPanel2.add(ageLabel);
        ageLabel.setBounds(20, 70, 60, 14);

        diameterLabel.setText(bundle.getString("TgDesign.diameterLabel.text")); // NOI18N
        jPanel2.add(diameterLabel);
        diameterLabel.setBounds(20, 100, 70, 14);

        maxDiameterLabel.setText(bundle.getString("TgDesign.maxDiameterLabel.text")); // NOI18N
        jPanel2.add(maxDiameterLabel);
        maxDiameterLabel.setBounds(20, 160, 80, 14);

        heightLabel.setText(bundle.getString("TgDesign.heightLabel.text")); // NOI18N
        jPanel2.add(heightLabel);
        heightLabel.setBounds(20, 130, 80, 14);

        basalAreaLabel.setText(bundle.getString("TgDesign.basalAreaLabel.text")); // NOI18N
        jPanel2.add(basalAreaLabel);
        basalAreaLabel.setBounds(20, 190, 130, 14);

        td2.setText(bundle.getString("TgDesign.td2.text")); // NOI18N
        td2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                td2KeyPressed(evt);
            }
        });
        jPanel2.add(td2);
        td2.setBounds(220, 70, 40, 20);

        td3.setText(bundle.getString("TgDesign.td3.text")); // NOI18N
        jPanel2.add(td3);
        td3.setBounds(220, 100, 40, 20);

        td4.setText(bundle.getString("TgDesign.td4.text")); // NOI18N
        td4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                td4KeyPressed(evt);
            }
        });
        jPanel2.add(td4);
        td4.setBounds(220, 130, 40, 20);

        td5.setText(bundle.getString("TgDesign.td5.text")); // NOI18N
        jPanel2.add(td5);
        td5.setBounds(220, 160, 40, 20);

        td6.setText(bundle.getString("TgDesign.td6.text")); // NOI18N
        jPanel2.add(td6);
        td6.setBounds(220, 190, 40, 20);
        jPanel2.add(speciesCodeComboBox);
        speciesCodeComboBox.setBounds(150, 40, 140, 20);

        startButton.setBackground(new java.awt.Color(51, 153, 255));
        startButton.setText(bundle.getString("TgDesign.startButton.text")); // NOI18N
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });
        jPanel2.add(startButton);
        startButton.setBounds(20, 530, 230, 23);

        siteIndexLabel.setText(bundle.getString("TgDesign.siteIndexLabel.text")); // NOI18N
        jPanel2.add(siteIndexLabel);
        siteIndexLabel.setBounds(20, 220, 140, 14);

        jTextField1.setText(bundle.getString("TgDesign.jTextField1.text")); // NOI18N
        jPanel2.add(jTextField1);
        jTextField1.setBounds(220, 220, 40, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "random coordinates", "raster coordinates" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(30, 370, 230, 20);

        rasterLabel.setText(bundle.getString("TgDesign.rasterLabel.text")); // NOI18N
        jPanel2.add(rasterLabel);
        rasterLabel.setBounds(30, 400, 120, 14);

        typeComboBox.setModel(new DefaultComboBoxModel(CreationType.values()));
        typeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboBoxActionPerformed(evt);
            }
        });
        jPanel2.add(typeComboBox);
        typeComboBox.setBounds(20, 10, 270, 20);

        rasterXTextField.setText(bundle.getString("TgDesign.rasterXTextField.text")); // NOI18N
        jPanel2.add(rasterXTextField);
        rasterXTextField.setBounds(160, 400, 40, 20);

        rasterYTextField.setText(bundle.getString("TgDesign.rasterYTextField.text")); // NOI18N
        jPanel2.add(rasterYTextField);
        rasterYTextField.setBounds(210, 400, 40, 20);

        startPositionLabel.setText(bundle.getString("TgDesign.startPositionLabel.text")); // NOI18N
        jPanel2.add(startPositionLabel);
        startPositionLabel.setBounds(30, 430, 120, 14);

        startXTextField.setText(bundle.getString("TgDesign.startXTextField.text")); // NOI18N
        jPanel2.add(startXTextField);
        startXTextField.setBounds(160, 430, 40, 20);

        startYTextField.setText(bundle.getString("TgDesign.startYTextField.text")); // NOI18N
        jPanel2.add(startYTextField);
        startYTextField.setBounds(210, 430, 40, 20);

        developmentCheckBox.setText(bundle.getString("TgDesign.developmentCheckBox.text")); // NOI18N
        developmentCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel2.add(developmentCheckBox);
        developmentCheckBox.setBounds(30, 460, 220, 15);

        distanceLabel.setText(bundle.getString("TgDesign.distanceLabel.text")); // NOI18N
        jPanel2.add(distanceLabel);
        distanceLabel.setBounds(50, 490, 60, 14);

        distanceTextField.setText(bundle.getString("TgDesign.distanceTextField.text")); // NOI18N
        jPanel2.add(distanceTextField);
        distanceTextField.setBounds(110, 490, 40, 20);

        widthLabel.setText(bundle.getString("TgDesign.widthLabel.text")); // NOI18N
        jPanel2.add(widthLabel);
        widthLabel.setBounds(160, 490, 60, 14);

        widthTextField.setText(bundle.getString("TgDesign.widthTextField.text")); // NOI18N
        jPanel2.add(widthTextField);
        widthTextField.setBounds(220, 490, 30, 20);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Einzelstamm", "Trupp", "Gruppe", "Horst" }));
        jPanel2.add(jComboBox4);
        jComboBox4.setBounds(120, 320, 140, 20);

        mixtureLabel.setText(bundle.getString("TgDesign.mixtureLabel.text")); // NOI18N
        jPanel2.add(mixtureLabel);
        mixtureLabel.setBounds(30, 320, 70, 14);

        jLabel13.setText(bundle.getString("TgDesign.jLabel13.text")); // NOI18N
        jPanel2.add(jLabel13);
        jLabel13.setBounds(20, 260, 70, 14);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        jPanel2.add(jComboBox5);
        jComboBox5.setBounds(210, 250, 50, 20);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboBoxActionPerformed
        // TODO add your handling code here:
        td2.setText("50");
        td4.setText("25");
        td6.setText("18.0");
        td3.setVisible(true);
        jTextField1.setText("-9.0");
        diameterLabel.setVisible(true);
        jComboBox4.setVisible(true);
        mixtureLabel.setVisible(true);
        jComboBox1.setVisible(true);
        developmentCheckBox.setVisible(true);
        distanceLabel.setVisible(true);
        distanceTextField.setVisible(true);
        widthLabel.setVisible(true);
        widthTextField.setVisible(true);
        if (typeComboBox.getSelectedIndex() == 0) {
//            jLabel6.setText(messages.getString("Dg"));
//            jLabel8.setText(messages.getString("Hg"));
//            jLabel9.setText(messages.getString("Basal_area"));
            maxDiameterLabel.setVisible(true);
            td5.setVisible(true);
            td6.setText("18.0");
            td3.setVisible(true);
        } else {
//            jLabel6.setText(messages.getString("dbh"));
//            jLabel8.setText(messages.getString("height"));
//            jLabel9.setText(messages.getString("number_of_trees"));
            maxDiameterLabel.setVisible(false);
            td5.setVisible(false);
            td6.setText("1");
        }
        if (typeComboBox.getSelectedIndex() == 2) {
            td2.setText("5");
            td4.setText("0.5");
            td6.setText("50.0");
            jTextField1.setText("30.0");
            diameterLabel.setVisible(false);
            td3.setVisible(false);
            maxDiameterLabel.setVisible(false);
            td5.setVisible(false);
//            jLabel9.setText(messages.getString("coveragePercent"));
            jComboBox4.setVisible(false);
            mixtureLabel.setVisible(false);
            jComboBox1.setVisible(false);
            developmentCheckBox.setVisible(false);
            distanceLabel.setVisible(false);
            distanceTextField.setVisible(false);
            widthLabel.setVisible(false);
            widthTextField.setVisible(false);
            jComboBox5.setSelectedIndex(2);

        }
    }//GEN-LAST:event_typeComboBoxActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if (jComboBox1.getSelectedIndex() == 1) {
            rasterLabel.setVisible(true);
            rasterXTextField.setVisible(true);
            rasterYTextField.setVisible(true);
            startPositionLabel.setVisible(true);
            startXTextField.setVisible(true);
            startYTextField.setVisible(true);
        } else {
            rasterLabel.setVisible(false);
            rasterXTextField.setVisible(false);
            rasterYTextField.setVisible(false);
            startPositionLabel.setVisible(false);
            startXTextField.setVisible(false);
            startYTextField.setVisible(false);
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionPerformed

        String cmd = evt.getActionCommand();

// check if size > 0.0 and stand created
        if (st.size > 0.0) {

            // generate diameter distribution
            if (cmd.equals("start creating")) {
                if (typeComboBox.getSelectedIndex() == 0) {
                    try {
                        GenDistribution gdb = new GenDistribution();
                        String codex = (String) (speciesCodeComboBox.getSelectedItem());
                        int m = codex.indexOf(":");
                        codex = codex.substring(0, m);
                        int lay = Integer.parseInt(jComboBox5.getSelectedItem().toString());
                        gdb.weibull(st, Integer.parseInt(codex), Integer.parseInt(td2.getText()), Double.parseDouble(td3.getText()), Double.parseDouble(td4.getText()), Double.parseDouble(td5.getText()), Double.parseDouble(td6.getText()) * st.size, false);
// missing data fuer die Verteilung generieren
                        if (Double.parseDouble(jTextField1.getText()) > -9) {
                            for (int j = 0; j < st.ntrees; j++) {
                                if (st.tr[j].si <= -9) {
                                    st.tr[j].si = Double.parseDouble(jTextField1.getText());
                                }
                            }
                        }
                        SIofDistrib siod = new SIofDistrib();
                        FunctionInterpreter fi = new FunctionInterpreter();
                        siod.si(st, Integer.parseInt(codex), Integer.parseInt(td2.getText()), Double.parseDouble(td3.getText()), Double.parseDouble(td4.getText()));
                        for (int j = 0; j < st.ntrees; j++) {
                            if (st.tr[j].h == 0.0) {
                                Tree tree = new Tree();
                                tree.code = Integer.parseInt(codex);
                                tree.sp = st.tr[j].sp;
                                tree.sp.dg = Double.parseDouble(td3.getText());
                                tree.sp.hg = Double.parseDouble(td4.getText());
                                tree.sp.h100 = 0.0;
                                tree.sp.d100 = 0.0;
                                tree.d = st.tr[j].d;
                                tree.code = st.tr[j].code;
                                tree.sp = st.tr[j].sp;
                                tree.st = st;
//                                st.tr[j].h = fi.getValueForTree(tree, tree.sp.spDef.uniformHeightCurveXML) + fi.getValueForTree(tree, tree.sp.spDef.heightVariationXML) * nd.value(3.0);
                                st.tr[j].h = fi.getValueForTree(tree, tree.sp.spDef.uniformHeightCurveXML);
                                st.tr[j].layer = lay;
                            }
                        }
                        for (int j = 0; j < st.ntrees; j++) {
                            st.tr[j].setMissingData();
                        }
                        GenerateXY gxy = null;
                        if (developmentCheckBox.isSelected()) {
                            double dist = Double.parseDouble(distanceTextField.getText());
                            double br = Double.parseDouble(widthTextField.getText());
                            if (dist < 0.1) {
                                dist = 20.0;
                            }
                            gxy = new GenerateXY(true, dist, br);
                        } else {
                            gxy = new GenerateXY();
                        }
                        if (jComboBox4.getSelectedIndex() == 0) {
                            gxy.setGroupRadius(0.0);
                        }
                        if (jComboBox4.getSelectedIndex() == 1) {
                            gxy.setGroupRadius(10.0);
                        }
                        if (jComboBox4.getSelectedIndex() == 2) {
                            gxy.setGroupRadius(20.0);
                        }
                        if (jComboBox4.getSelectedIndex() == 3) {
                            gxy.setGroupRadius(40.0);
                        }
                        if (jComboBox1.getSelectedIndex() == 0) {
                            gxy.zufall(st);
                        } else {
                            gxy.raster(st, Double.parseDouble(rasterXTextField.getText()), Double.parseDouble(rasterYTextField.getText()), Double.parseDouble(startXTextField.getText()), Double.parseDouble(startYTextField.getText()));
                        }
                        st.sortbyd();
                        st.descspecies();
                        frame.tfUpdateTrue = true;
                    } catch (Exception ex) {
                        Logger.getLogger(TgDesign.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (typeComboBox.getSelectedIndex() == 1) {
                    int lay = Integer.parseInt(jComboBox5.getSelectedItem().toString());
                    for (int j = 0; j < Integer.parseInt(td6.getText()); j++) {
                        try {
                            Integer nox = st.ntrees + 1;
                            String nrAdd = nox.toString();
                            String codex = (String) (speciesCodeComboBox.getSelectedItem());
                            int m = codex.indexOf(":");
                            codex = codex.substring(0, m);
                            st.addtree(Integer.parseInt(codex), nrAdd, Integer.parseInt(td2.getText()), -1, Double.parseDouble(td3.getText()), Double.parseDouble(td4.getText()), 0.0, 0.0, Double.parseDouble(jTextField1.getText()), -9.0, -9.0, 0.0, 0, 0, 0);
                            st.tr[st.ntrees - 1].layer = lay;
                        } catch (Exception ex) {
                            Logger.getLogger(TgDesign.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    st.missingData();
                    st.descspecies();
                    GenerateXY gxy = new GenerateXY();
                    if (jComboBox1.getSelectedIndex() == 0) {
                        gxy.zufall(st);
                    } else {
                        gxy.raster(st, Double.parseDouble(rasterXTextField.getText()), Double.parseDouble(rasterYTextField.getText()),
                                Double.parseDouble(startXTextField.getText()), Double.parseDouble(startYTextField.getText()));
                    }

                }

                if (typeComboBox.getSelectedIndex() == 2) {
                    String codex = (String) (speciesCodeComboBox.getSelectedItem());
                    int m = codex.indexOf(":");
                    codex = codex.substring(0, m);
                    double bon = Double.parseDouble(jTextField1.getText());
                    double hei = Double.parseDouble(td4.getText());
                    double d = hei;
                    int artx = Integer.parseInt(codex);
                    double cbx = 1.0;
                    double gx = 0.0;
                    if (d < 7.0) {
// get crown width at dbh= 7 cm of species at point of ingrowth            
                        Tree atree = new Tree(artx, "atree", 20, -1, 0, 7.0, 8.0, 2.0, 0.0, -99, 1.0, 0.0, 0.0, 0.0, false, false,
                                false, 3, 0.0, "");
                        try {
                            atree.sp = st.addspecies(atree);
                        } catch (Exception ex) {
                            Logger.getLogger(TgDesign.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        cbx = atree.calculateCw();
                        gx = Math.PI * Math.pow(cbx / 2.0, 2.0);

                    }

                    double cov = Double.parseDouble(td6.getText());
                    int anzahl = (int) Math.round(st.size * cov * 100.0 / gx);
                    for (int i = 0; i < anzahl; i++) {
                        try {
                            Integer nox = st.ntrees + 1;
                            String nrAdd = nox.toString();
                            if (d < 7.0) {
                                st.addtree(artx, nrAdd, Integer.parseInt(td2.getText()), -1, d, hei, hei / 2.0, cbx, bon, -9.0, -9.0, 0.0, 0, 0, 0);
                                st.tr[st.ntrees - 1].layer = 3;
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(TgDesign.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    GenerateXY gxy = new GenerateXY(false, 0.0, 0.0);
                    gxy.zufall(st);

                }

            }
        } else {
            frame.iframe[3].setVisible(false);
            frame.menubar.cmi[3].setSelected(false);
            /*                    JDialog newstand = new TgNewStand(frame, true, frame.st, frame, frame.language );   
                    Model mo =new Model();
                    frame.st.setModelRegion(mo.getPlugInName(frame.plugIn));
                    newstand.setVisible(true);
                    frame.tfUpdateTrue=true;  
             */ if (st.size > 0) {
                frame.iframe[3].setVisible(true);
                frame.menubar.cmi[3].setSelected(true);
            }
        }
//	

//           System.out.println("Bäume:"+st.ntrees);
        frame.tfUpdateTrue = true;
        frame.updatetp(false);

    }//GEN-LAST:event_ActionPerformed

    private void td2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_td2KeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            setho();
            setdbh();
        }

    }//GEN-LAST:event_td2KeyPressed

    private void td4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_td4KeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            setdbh();
        }

    }//GEN-LAST:event_td4KeyPressed
    
    private void loadSpecies(String Dir) {
        java.io.File file;
        String fname = "";
        try {
            URL url = null;
            int m = Dir.toUpperCase().indexOf("FILE");
            int m2 = Dir.toUpperCase().indexOf("HTTP");
            String trenn = System.getProperty("file.separator");
            fname = Dir + System.getProperty("file.separator") + "models" + System.getProperty("file.separator") + st.FileXMLSettings;
            if (m < 0 && m2 < 0) {
                fname = "file:" + trenn + trenn + trenn + fname;
            }
            System.out.println("SpeciesDef: URL: " + fname);
            try {
                url = new URL(fname);
            } catch (Exception e) {
                JTextArea about = new JTextArea("TgDesign: Url file not found: " + fname);
                JOptionPane.showMessageDialog(null, about, "About", JOptionPane.INFORMATION_MESSAGE);
            }

            SAXBuilder builder = new SAXBuilder();
            URLConnection urlcon = url.openConnection();

            Document doc = builder.build(urlcon.getInputStream());

            DocType docType = doc.getDocType();
//        
            Element sortimente = doc.getRootElement();
            List Sortiment = sortimente.getChildren("SpeciesDefinition");
            Iterator i = Sortiment.iterator();

            while (i.hasNext()) {
                Element sortiment = (Element) i.next();
                speciesCodeComboBox.addItem(sortiment.getChild("Code").getText() + ":" + sortiment.getChild("ShortName").getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
            JTextArea about = new JTextArea("TgDesign file not found: " + fname);
            JOptionPane.showMessageDialog(null, about, "About", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("SpeciesDef: File nicht gefunden: " + fname);

        }

        speciesCodeComboBox.setSelectedIndex(0);
    }

    private double setho() {
        Double ho = 0.0;
        String txt = speciesCodeComboBox.getSelectedItem().toString();
        int m = txt.indexOf(":");
        int code = Integer.parseInt(txt.substring(0, m));
        int a = Integer.parseInt(td2.getText().trim());
        int art = 211;
        if (code < 211) {
            art = 111;
        }
        if (code > 500) {
            art = 511;
        }
        if (code == 611) {
            art = 611;
        }
        if (code == 711) {
            art = 711;
        }
        if (art == 111) {
            ho = 1.2164 * 24.0 * Math.exp(Math.log(1.0 - Math.exp(-0.0194 * a)) * 1.1344);
        }
        if (art == 211) {
            ho = -75.65900 + 23.19200 * Math.log(a) - 1.46800 * (Math.log(a) * Math.log(a)) + 0.0 * 28.6 + 0.21520 * 28.6 * Math.log(a);
        }
        if (art == 511) {
            ho = -49.87200 + 7.33090 * Math.log(a) + 0.77338 * (Math.log(a) * Math.log(a)) + 0.52684 * 31.2 + 0.10542 * 31.2 * Math.log(a);
        }
        if (art == 611) {
            ho = -47.09070 + 11.4322 * Math.log(a) - 0.0 * (Math.log(a) * Math.log(a)) - 0.0 * 40.0 + 0.20063 * 40.0 * Math.log(a);
        }
        if (art == 711) {
            ho = -31.67480 + 11.64500 * Math.log(a) - 1.04989 * (Math.log(a) * Math.log(a)) - 0.43221 * 28.9 + 0.31253 * 28.9 * Math.log(a);
        }
        if (ho < 7.5) {
            ho = 7.5;
        }
        ho = Math.round(ho * 10.0) / 10.0;
        td4.setText(ho.toString());
        return ho;
    }

    private void setdbh() {
        Double dgx = 0.0;
        Double dgm = 0.0;
        String txt = speciesCodeComboBox.getSelectedItem().toString();
        int m = txt.indexOf(":");
        int code = Integer.parseInt(txt.substring(0, m));
        if (code != 111 && code != 511 && code != 711) {
            code = 211;
        }
        int a = Integer.parseInt(td2.getText().trim());
        double h = Double.parseDouble(td4.getText().trim());
        int art = 211;
        if (code < 211) {
            art = 111;
        }
        if (code > 500) {
            art = 511;
        }
        if (code == 611) {
            art = 611;
        }
        if (code == 711) {
            art = 711;
        }
        if (art == 111) {
            dgx = 2.2133044 + 0.3372101 * a - 0.0005661 * a * a - 0.3666360 * h + 0.0302228 * h * h;
        }
        if (art == 211) {
            dgx = 3.009 + 0.275 * a - 0.0004572 * a * a - 0.3646 * h + 0.0265 * h * h;
        }
        if (art == 511) {
            dgx = 4.999 + 0.27 * a - 0.0009989 * a * a + 0.3669 * h + 0.0093306 * h * h;
        }
        if (art == 611) {
            dgx = 1.3719960 + 0.5216833 * a - 0.0019608 * a * a + 0.2648483 * h + 0.0116218 * h * h;
        }
        if (art == 711) {
            dgx = 0.4691 + 0.2676 * a - 0.00067 * a * a + 0.447 * h + 0.009401 * h * h;
        }
        if (dgx < 7.0) {
            dgx = 7.0;
        }

        dgx = Math.round(dgx * 10.0) / 10.0;
        td3.setText(dgx.toString());
        if (art == 111) {
            dgm = 9.35514 + 1.19655 * dgx + 0.31098 * h;
        }
        if (art == 211) {
            dgm = 9.60310 + 0.97132 * dgx + 0.55732 * h;
        }
        if (art == 511) {
            dgm = 9.56268 + 1.15093 * dgx + 0.24856 * h;
        }
        if (art == 611) {
            dgm = 1.9660 + 1.9492 * dgx - 0.4995 * h;
        }
        if (art == 711) {
            dgm = 10.10099 + 1.04032 * dgx + 0.30663 * h;
        }
        dgm = Math.round(dgm * 10.0) / 10.0;
        td5.setText(dgm.toString());
    }

    /*
    void showdesigner(stand st1)
	{
            st = st1;
            Double siz = new Double(st.size);
            tf0.setText("  "+siz.toString());
	}*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageLabel;
    private javax.swing.JLabel basalAreaLabel;
    private javax.swing.JCheckBox developmentCheckBox;
    private javax.swing.JLabel diameterLabel;
    private javax.swing.JLabel distanceLabel;
    private javax.swing.JTextField distanceTextField;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel maxDiameterLabel;
    private javax.swing.JLabel mixtureLabel;
    private javax.swing.JLabel rasterLabel;
    private javax.swing.JTextField rasterXTextField;
    private javax.swing.JTextField rasterYTextField;
    private javax.swing.JLabel siteIndexLabel;
    private javax.swing.JComboBox speciesCodeComboBox;
    private javax.swing.JLabel speciesCodeLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel startPositionLabel;
    private javax.swing.JTextField startXTextField;
    private javax.swing.JTextField startYTextField;
    private javax.swing.JTextField td2;
    private javax.swing.JTextField td3;
    private javax.swing.JTextField td4;
    private javax.swing.JTextField td5;
    private javax.swing.JTextField td6;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JLabel widthLabel;
    private javax.swing.JTextField widthTextField;
    // End of variables declaration//GEN-END:variables

}
