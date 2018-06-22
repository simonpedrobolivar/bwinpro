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
package forestsimulator.standsimulation;

import treegross.base.thinning.ThinningType;
import java.text.*;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import treegross.base.*;
import treegross.base.rule.SkidTrailRules;
import treegross.base.rule.ThinningRegime;
import treegross.treatment.*;


/**
 *
 * @author  nagel
 */
public class TgTreatmentMan3 extends JPanel {
    private final DefaultTableModel data;
    private final ResourceBundle messages = ResourceBundle.getBundle("forestsimulator/gui");
    private final Stand st;
    Object[] rowData={" "," "," "," "," "," "};
    TgYieldTable  yt  = null;
    Treatment2 treat = new Treatment2();
    
    public TgTreatmentMan3(Stand stparent,  TgJFrame frameparent) {
        initComponents();
        st = stparent;
        yt = frameparent.yt;

        thinningIntensityComboBox.removeAllItems();
        thinningIntensityComboBox.addItem(ThinningIntensity.None);
        thinningIntensityComboBox.addItem(ThinningIntensity.Low);
        thinningIntensityComboBox.addItem(ThinningIntensity.Moderate);
        thinningIntensityComboBox.addItem(ThinningIntensity.Heavy);
        thinningIntensityComboBox.addItem(ThinningIntensity.VeryHeavy);
        thinningIntensityComboBox.addItem("0.9");
        thinningIntensityComboBox.addItem("1.1");
        thinningIntensityComboBox.addItem("1.3");
        thinningIntensityComboBox.addItem("1.4");
        thinningIntensityComboBox.addItem("1.6");
        thinningIntensityComboBox.addItem("1.7");
        thinningIntensityComboBox.addItem("1.8");
        thinningIntensityComboBox.addItem("1.9");
        
        data = new DefaultTableModel(
            new Object [][] {  },
            TreatmentTableColumn.values()
        );
        jTable1.setModel(data);
        
        thinningIntensityComboBox.setSelectedIndex(2);
        loadTable();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        simulationDurationLabel = new javax.swing.JLabel();
        simulationDurationTextField = new javax.swing.JTextField();
        simulationDurationUnitLabel = new javax.swing.JLabel();
        useRandomEffectsCheckBox = new javax.swing.JCheckBox();
        useIngrowthModelCheckBox = new javax.swing.JCheckBox();
        useRiskModelCheckBox = new javax.swing.JCheckBox();
        startSimulationButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        scenarioSettingsHeadingLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        developmentLabel = new javax.swing.JLabel();
        developmentCheckBox = new javax.swing.JCheckBox();
        skidtrailDistanceLabel = new javax.swing.JLabel();
        skidtrailDistanceTextField = new javax.swing.JTextField();
        skidtrailWidthLabel = new javax.swing.JLabel();
        skidtrailWidthTextField = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        thinningTypeLabel = new javax.swing.JLabel();
        thinningTypeComboBox = new javax.swing.JComboBox();
        thinningIntensityLabel = new javax.swing.JLabel();
        thinningIntensityComboBox = new javax.swing.JComboBox();
        thinningAmountMinimumLabel = new javax.swing.JLabel();
        thinningAmountMinimumTextField = new javax.swing.JTextField();
        thinningAmountMaximumLabel = new javax.swing.JLabel();
        thinningAmountMaximumTextField = new javax.swing.JTextField();
        releaseOnlyCropTreesCheckBox = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        harvestingTypeLabel = new javax.swing.JLabel();
        harvestingTypeComboBox = new javax.swing.JComboBox();
        harvestingAmountMinimumLabel = new javax.swing.JLabel();
        harvestingAmountMinimumTextField = new javax.swing.JTextField();
        harvestingAmountMaximumLabel = new javax.swing.JLabel();
        harvestingAmountMaximumTextField = new javax.swing.JTextField();
        clearingLabel = new javax.swing.JLabel();
        clearingTextField = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        natureProtectionLabel = new javax.swing.JLabel();
        habitatTreesLabel = new javax.swing.JLabel();
        habitatTreesTextField = new javax.swing.JTextField();
        woodTypeComboBox = new javax.swing.JComboBox();
        minorityProtectionCheckBox = new javax.swing.JCheckBox();
        minimumCoverLabel = new javax.swing.JLabel();
        minimumCoverTextField = new javax.swing.JTextField();
        protectionThicknessLabel = new javax.swing.JLabel();
        protectionThicknessTextField = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        plantingLabel = new javax.swing.JLabel();
        plantingCheckbox = new javax.swing.JCheckBox();
        unterstoryRemovalCheckBox = new javax.swing.JCheckBox();
        plantAtLabel = new javax.swing.JLabel();
        plantAtTextField = new javax.swing.JTextField();
        speciesCodeLabel = new javax.swing.JLabel();
        speciesCodeTextField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        speciesSettingsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        simulationDurationLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("forestsimulator/gui"); // NOI18N
        simulationDurationLabel.setText(bundle.getString("TgTreatmentMan3.simulationDurationLabel.text")); // NOI18N
        jPanel1.add(simulationDurationLabel);

        simulationDurationTextField.setText(bundle.getString("TgTreatmentMan3.simulationDurationTextField.text")); // NOI18N
        simulationDurationTextField.setPreferredSize(new java.awt.Dimension(22, 20));
        simulationDurationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulationDurationTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(simulationDurationTextField);

        simulationDurationUnitLabel.setText(bundle.getString("TgTreatmentMan3.simulationDurationUnitLabel.text")); // NOI18N
        jPanel1.add(simulationDurationUnitLabel);

        useRandomEffectsCheckBox.setSelected(true);
        useRandomEffectsCheckBox.setText(bundle.getString("TgTreatmentMan3.useRandomEffectsCheckBox.text")); // NOI18N
        useRandomEffectsCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        useRandomEffectsCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel1.add(useRandomEffectsCheckBox);

        useIngrowthModelCheckBox.setSelected(true);
        useIngrowthModelCheckBox.setText(bundle.getString("TgTreatmentMan3.useIngrowthModelCheckBox.text")); // NOI18N
        useIngrowthModelCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        useIngrowthModelCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel1.add(useIngrowthModelCheckBox);

        useRiskModelCheckBox.setSelected(true);
        useRiskModelCheckBox.setText(bundle.getString("TgTreatmentMan3.useRiskModelCheckBox.text")); // NOI18N
        jPanel1.add(useRiskModelCheckBox);

        startSimulationButton.setText(bundle.getString("TgTreatmentMan3.startSimulationButton.text")); // NOI18N
        startSimulationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSimulationButtonActionPerformed(evt);
            }
        });
        jPanel1.add(startSimulationButton);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.GridLayout(2, 0));

        jPanel4.setLayout(new java.awt.GridLayout(6, 0));

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        scenarioSettingsHeadingLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        scenarioSettingsHeadingLabel.setText(bundle.getString("TgTreatmentMan3.scenarioSettingsHeadingLabel.text")); // NOI18N
        jPanel11.add(scenarioSettingsHeadingLabel);

        jPanel4.add(jPanel11);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        developmentLabel.setText(bundle.getString("TgTreatmentMan3.developmentLabel.text")); // NOI18N
        jPanel6.add(developmentLabel);

        developmentCheckBox.setText(bundle.getString("TgTreatmentMan3.developmentCheckBox.text")); // NOI18N
        developmentCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        developmentCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        developmentCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                developmentCheckBoxActionPerformed(evt);
            }
        });
        jPanel6.add(developmentCheckBox);

        skidtrailDistanceLabel.setText(bundle.getString("TgTreatmentMan3.skidtrailDistanceLabel.text")); // NOI18N
        jPanel6.add(skidtrailDistanceLabel);

        skidtrailDistanceTextField.setText(bundle.getString("TgTreatmentMan3.skidtrailDistanceTextField.text")); // NOI18N
        skidtrailDistanceTextField.setPreferredSize(new java.awt.Dimension(35, 20));
        jPanel6.add(skidtrailDistanceTextField);

        skidtrailWidthLabel.setText(bundle.getString("TgTreatmentMan3.skidtrailWidthLabel.text")); // NOI18N
        jPanel6.add(skidtrailWidthLabel);

        skidtrailWidthTextField.setText(bundle.getString("TgTreatmentMan3.skidtrailWidthTextField.text")); // NOI18N
        skidtrailWidthTextField.setPreferredSize(new java.awt.Dimension(30, 20));
        jPanel6.add(skidtrailWidthTextField);

        jPanel4.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        thinningTypeLabel.setText(bundle.getString("TgTreatmentMan3.thinningTypeLabel.text")); // NOI18N
        jPanel7.add(thinningTypeLabel);

        thinningTypeComboBox.setModel(new DefaultComboBoxModel(ThinningType.values()));
        thinningTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thinningTypeComboBoxActionPerformed(evt);
            }
        });
        jPanel7.add(thinningTypeComboBox);

        thinningIntensityLabel.setText(bundle.getString("TgTreatmentMan3.thinningIntensityLabel.text")); // NOI18N
        jPanel7.add(thinningIntensityLabel);

        jPanel7.add(thinningIntensityComboBox);

        thinningAmountMinimumLabel.setText(bundle.getString("TgTreatmentMan3.thinningAmountMinimumLabel.text")); // NOI18N
        jPanel7.add(thinningAmountMinimumLabel);

        thinningAmountMinimumTextField.setText(bundle.getString("TgTreatmentMan3.thinningAmountMinimumTextField.text")); // NOI18N
        thinningAmountMinimumTextField.setPreferredSize(new java.awt.Dimension(35, 20));
        jPanel7.add(thinningAmountMinimumTextField);

        thinningAmountMaximumLabel.setText(bundle.getString("TgTreatmentMan3.thinningAmountMaximumLabel.text")); // NOI18N
        jPanel7.add(thinningAmountMaximumLabel);

        thinningAmountMaximumTextField.setText(bundle.getString("TgTreatmentMan3.thinningAmountMaximumTextField.text")); // NOI18N
        thinningAmountMaximumTextField.setPreferredSize(new java.awt.Dimension(35, 20));
        thinningAmountMaximumTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thinningAmountMaximumTextFieldActionPerformed(evt);
            }
        });
        jPanel7.add(thinningAmountMaximumTextField);

        releaseOnlyCropTreesCheckBox.setText(bundle.getString("TgTreatmentMan3.releaseOnlyCropTreesCheckBox.text")); // NOI18N
        releaseOnlyCropTreesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                releaseOnlyCropTreesCheckBoxActionPerformed(evt);
            }
        });
        jPanel7.add(releaseOnlyCropTreesCheckBox);

        jPanel4.add(jPanel7);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        harvestingTypeLabel.setText(bundle.getString("TgTreatmentMan3.harvestingTypeLabel.text")); // NOI18N
        jPanel8.add(harvestingTypeLabel);

        harvestingTypeComboBox.setModel(new DefaultComboBoxModel(HarvestingType.values()));
        harvestingTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harvestingTypeComboBoxActionPerformed(evt);
            }
        });
        jPanel8.add(harvestingTypeComboBox);

        harvestingAmountMinimumLabel.setText(bundle.getString("TgTreatmentMan3.harvestingAmountMinimumLabel.text")); // NOI18N
        jPanel8.add(harvestingAmountMinimumLabel);

        harvestingAmountMinimumTextField.setText(bundle.getString("TgTreatmentMan3.harvestingAmountMinimumTextField.text")); // NOI18N
        harvestingAmountMinimumTextField.setPreferredSize(new java.awt.Dimension(35, 20));
        jPanel8.add(harvestingAmountMinimumTextField);

        harvestingAmountMaximumLabel.setText(bundle.getString("TgTreatmentMan3.harvestingAmountMaximumLabel.text")); // NOI18N
        jPanel8.add(harvestingAmountMaximumLabel);

        harvestingAmountMaximumTextField.setText(bundle.getString("TgTreatmentMan3.harvestingAmountMaximumTextField.text")); // NOI18N
        harvestingAmountMaximumTextField.setPreferredSize(new java.awt.Dimension(35, 20));
        harvestingAmountMaximumTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harvestingAmountMaximumTextFieldActionPerformed(evt);
            }
        });
        jPanel8.add(harvestingAmountMaximumTextField);

        clearingLabel.setText(bundle.getString("TgTreatmentMan3.clearingLabel.text")); // NOI18N
        jPanel8.add(clearingLabel);

        clearingTextField.setText(bundle.getString("TgTreatmentMan3.clearingTextField.text")); // NOI18N
        clearingTextField.setPreferredSize(new java.awt.Dimension(135, 20));
        jPanel8.add(clearingTextField);

        jPanel4.add(jPanel8);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        natureProtectionLabel.setText(bundle.getString("TgTreatmentMan3.natureProtectionLabel.text")); // NOI18N
        jPanel9.add(natureProtectionLabel);

        habitatTreesLabel.setText(bundle.getString("TgTreatmentMan3.habitatTreesLabel.text")); // NOI18N
        jPanel9.add(habitatTreesLabel);

        habitatTreesTextField.setText(bundle.getString("TgTreatmentMan3.habitatTreesTextField.text")); // NOI18N
        habitatTreesTextField.setPreferredSize(new java.awt.Dimension(35, 20));
        jPanel9.add(habitatTreesTextField);

        woodTypeComboBox.setModel(new DefaultComboBoxModel(WoodType.values()));
        jPanel9.add(woodTypeComboBox);

        minorityProtectionCheckBox.setText(bundle.getString("TgTreatmentMan3.minorityProtectionCheckBox.text")); // NOI18N
        jPanel9.add(minorityProtectionCheckBox);

        minimumCoverLabel.setText(bundle.getString("TgTreatmentMan3.minimumCoverLabel.text")); // NOI18N
        jPanel9.add(minimumCoverLabel);

        minimumCoverTextField.setText(bundle.getString("TgTreatmentMan3.minimumCoverTextField.text")); // NOI18N
        minimumCoverTextField.setPreferredSize(new java.awt.Dimension(26, 20));
        jPanel9.add(minimumCoverTextField);

        protectionThicknessLabel.setText(bundle.getString("TgTreatmentMan3.protectionThicknessLabel.text")); // NOI18N
        jPanel9.add(protectionThicknessLabel);

        protectionThicknessTextField.setText(bundle.getString("TgTreatmentMan3.protectionThicknessTextField.text")); // NOI18N
        protectionThicknessTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                protectionThicknessTextFieldActionPerformed(evt);
            }
        });
        jPanel9.add(protectionThicknessTextField);

        jPanel4.add(jPanel9);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        plantingLabel.setText(bundle.getString("TgTreatmentMan3.plantingLabel.text")); // NOI18N
        jPanel10.add(plantingLabel);

        plantingCheckbox.setText(bundle.getString("TgTreatmentMan3.plantingCheckbox.text")); // NOI18N
        jPanel10.add(plantingCheckbox);

        unterstoryRemovalCheckBox.setText(bundle.getString("TgTreatmentMan3.unterstoryRemovalCheckBox.text")); // NOI18N
        jPanel10.add(unterstoryRemovalCheckBox);

        plantAtLabel.setText(bundle.getString("TgTreatmentMan3.plantAtLabel.text")); // NOI18N
        jPanel10.add(plantAtLabel);

        plantAtTextField.setText(bundle.getString("TgTreatmentMan3.plantAtTextField.text")); // NOI18N
        plantAtTextField.setPreferredSize(new java.awt.Dimension(35, 20));
        jPanel10.add(plantAtTextField);

        speciesCodeLabel.setText(bundle.getString("TgTreatmentMan3.speciesCodeLabel.text")); // NOI18N
        jPanel10.add(speciesCodeLabel);

        speciesCodeTextField.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel10.add(speciesCodeTextField);

        jPanel4.add(jPanel10);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        speciesSettingsLabel.setText(bundle.getString("TgTreatmentMan3.speciesSettingsLabel.text")); // NOI18N
        jPanel5.add(speciesSettingsLabel, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void harvestingAmountMaximumTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harvestingAmountMaximumTextFieldActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_harvestingAmountMaximumTextFieldActionPerformed

private void releaseOnlyCropTreesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_releaseOnlyCropTreesCheckBoxActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_releaseOnlyCropTreesCheckBoxActionPerformed

private void simulationDurationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulationDurationTextFieldActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_simulationDurationTextFieldActionPerformed

private void startSimulationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSimulationButtonActionPerformed
    loadSettingsToStandRule();

    int simTime = Integer.parseInt(simulationDurationTextField.getText());
    int nSimSteps = (int) Math.ceil(Double.parseDouble(simulationDurationTextField.getText()) / st.timeStep);
    Simulation simulation = new Simulation(st, treat);
    for (int i = 0; i < nSimSteps; i++){
        int time = st.timeStep;
        if (simTime < st.timeStep) {
            time = simTime;
        }
        simulation.executeStep(time, (t) -> {
            yt.enterStandDesc(t);
        });
        simTime -= st.timeStep;
    }
}//GEN-LAST:event_startSimulationButtonActionPerformed

private void developmentCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_developmentCheckBoxActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_developmentCheckBoxActionPerformed

private void thinningAmountMaximumTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thinningAmountMaximumTextFieldActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_thinningAmountMaximumTextFieldActionPerformed

private void harvestingTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harvestingTypeComboBoxActionPerformed
    if (harvestingTypeComboBox.getSelectedIndex()==0){
        clearingTextField.setVisible(true);
        clearingLabel.setVisible(true);
        harvestingAmountMinimumLabel.setVisible(true);
        harvestingAmountMaximumLabel.setVisible(true);
        harvestingAmountMinimumTextField.setVisible(true);
        harvestingAmountMaximumTextField.setVisible(true);
        clearingLabel.setText(messages.getString("TgTreatmentMan3.clearingLabel.text"));
        clearingTextField.setText("0.3");
    }
    if (harvestingTypeComboBox.getSelectedIndex()==1){
        clearingTextField.setVisible(true);
        clearingLabel.setVisible(true);
        harvestingAmountMinimumLabel.setVisible(false);
        harvestingAmountMaximumLabel.setVisible(false);
        harvestingAmountMinimumTextField.setVisible(false);
        harvestingAmountMaximumTextField.setVisible(false);
        clearingLabel.setText(messages.getString("TgTreatmentMan3.clearingLabel.regeneration.text"));
        if (st.trule.regenerationProcess.length()>1) clearingTextField.setText(st.trule.regenerationProcess);
            else clearingTextField.setText("0.7;0.4;0.2;0.0;");
    }
    if (harvestingTypeComboBox.getSelectedIndex()==2){
        harvestingAmountMinimumLabel.setVisible(false);
        harvestingAmountMaximumLabel.setVisible(false);
        harvestingAmountMinimumTextField.setVisible(false);
        harvestingAmountMaximumTextField.setVisible(false);
        clearingTextField.setVisible(false);
        clearingLabel.setVisible(false);
    }
}//GEN-LAST:event_harvestingTypeComboBoxActionPerformed

private void protectionThicknessTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_protectionThicknessTextFieldActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_protectionThicknessTextFieldActionPerformed

private void thinningTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thinningTypeComboBoxActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_thinningTypeComboBoxActionPerformed
   
    public void formUpdate(Stand stand){
        loadTable();
    }

    private void loadTable(){
        useIngrowthModelCheckBox.setSelected(st.ingrowthActive);

        if (st.random.getRandomType() > 10) {
            useRandomEffectsCheckBox.setSelected(true);
        } else {
            useRandomEffectsCheckBox.setSelected(false);
        } 
        NumberFormat f=NumberFormat.getInstance(new Locale("en", "US"));
        f.setMaximumFractionDigits(0);
        f.setMinimumFractionDigits(0);
        f.setGroupingUsed(false);
         for (int i=data.getRowCount(); i>0 ; i=i-1){
            data.removeRow(i-1);
        }
        String pflArten ="";
        if (st.nspecies == 1) st.sp[0].trule.targetCrownPercent=100.0;
        for (int i=0; i< st.nspecies; i++){
               data.addRow(rowData);
               jTable1.setValueAt(st.sp[i].spDef.shortName,i,0);
               jTable1.setValueAt(st.sp[i].code,i,1);
               jTable1.setValueAt(f.format(st.sp[i].trule.minCropTreeHeight),i,2);
               jTable1.setValueAt(f.format(st.sp[i].trule.targetDiameter),i,3);
               jTable1.setValueAt(f.format(st.sp[i].trule.targetCrownPercent),i,5);
               Integer nct = (int) Math.round(st.sp[i].trule.numberCropTreesWanted/(st.sp[i].trule.targetCrownPercent/100.0));
               if (nct <= 1) nct = st.sp[i].spDef.cropTreeNumber;
 //              if (nct <= 2) nct = numberOfCropTrees(i,st.sp[i].trule.targetDiameter,
 //                                                          st.sp[i].trule.targetCrownPercent);
               jTable1.setValueAt(nct.toString(),i,4);
               Double flant = Math.round(st.sp[i].trule.targetCrownPercent/(10.0 ))/10.0;
               pflArten = pflArten + st.sp[i].code + "["+flant.toString()+"];";
        }
        if (st.status == 0) {
            speciesCodeTextField.setText(pflArten);
        }
    }
    
    public void loadSettingsToStandRule() {
      if (useRandomEffectsCheckBox.isSelected()) {
          st.random.setRandomType(11);
      } else {
          st.random.setRandomType(10);
      }
      st.ingrowthActive = useIngrowthModelCheckBox.isSelected();
      st.riskActive = useRiskModelCheckBox.isSelected();
      st.distanceDependent=true;
// Planting rules
      st.trule.setAutoPlanting(plantingCheckbox.isSelected(), unterstoryRemovalCheckBox.isSelected(), Double.parseDouble(plantAtTextField.getText()), speciesCodeTextField.getText());
      st.trule.setSkidTrails(
              new SkidTrailRules(developmentCheckBox.isSelected(),
                      Double.parseDouble(skidtrailDistanceTextField.getText()),
                      Double.parseDouble(skidtrailWidthTextField.getText()))
      );
      developmentCheckBox.setSelected(false);
      if (st.ntrees > 0) {  
// Set thinning  and intensity
        String thtxt = thinningIntensityComboBox.getSelectedItem().toString();
        thtxt = thtxt.substring(0,3);
        double thIntensity = Double.parseDouble(thtxt);
        boolean ctreesOnly = releaseOnlyCropTreesCheckBox.isSelected();

        st.trule.setThinningRegime(new ThinningRegime((ThinningType) thinningTypeComboBox.getSelectedItem(), thIntensity, Double.parseDouble(thinningAmountMinimumTextField.getText()),
                 Double.parseDouble(thinningAmountMaximumTextField.getText()), ctreesOnly));
// set Harvesting Regime
        double clearFak = 0.0;
        if (harvestingTypeComboBox.getSelectedIndex() == 0) {
            clearFak = Double.parseDouble(clearingTextField.getText());
        }
        st.trule.setHarvestRegime(harvestingTypeComboBox.getSelectedIndex(), Double.parseDouble(harvestingAmountMinimumTextField.getText()),
                Double.parseDouble(harvestingAmountMaximumTextField.getText()), clearFak, clearingTextField.getText());
// Set nature conversation
        st.trule.setNatureProtection(Integer.parseInt(habitatTreesTextField.getText()), woodTypeComboBox.getSelectedIndex(), 
                minorityProtectionCheckBox.isSelected(),Double.parseDouble(minimumCoverTextField.getText()),Integer.parseInt(protectionThicknessTextField.getText()));
      }
      for (int i=0; i < jTable1.getRowCount(); i++){
          int merk = -9;
          for (int j = 0; j < st.nspecies; j++){
              int codex = (Integer) (jTable1.getValueAt(i,1));
              if (st.sp[j].code == codex) merk= j;
          }
          if (merk > -9){
             st.sp[merk].trule.minCropTreeHeight = Double.parseDouble((String)(jTable1.getValueAt(i,2))); 
             st.sp[merk].trule.targetCrownPercent = Double.parseDouble((String)(jTable1.getValueAt(i,5))); 
             st.sp[merk].trule.targetDiameter = Double.parseDouble((String)(jTable1.getValueAt(i,3))); 
             st.sp[merk].trule.numberCropTreesWanted = (int)(Integer.parseInt((String)(jTable1.getValueAt(i,4)))*st.sp[merk].trule.targetCrownPercent/100.0);
          }
       }
      double sum=0.0; 
      for (int i=0; i< st.nspecies; i++) sum=sum+st.sp[i].trule.targetCrownPercent;
      for (int i=0; i< st.nspecies; i++) st.sp[i].trule.targetCrownPercent=100.0*st.sp[i].trule.targetCrownPercent/sum;
      loadTable();
    }

    public int numberOfCropTrees(int speciesIndex, double diameter, double percentage) {
        Tree atree = new Tree();
        atree.st = st;
        atree.code = st.sp[speciesIndex].code;
        atree.sp = st.sp[speciesIndex];
        atree.d = diameter;
        atree.h = st.sp[speciesIndex].hg;
        double dist_ct = atree.calculateCw();
        // Number of crop trees dependent on calcualted distance and actual mixture percent
        return (int) ((10000.0 / ((Math.PI * Math.pow(dist_ct, 2.0)) / 4)) * percentage / 100.0);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clearingLabel;
    private javax.swing.JTextField clearingTextField;
    private javax.swing.JCheckBox developmentCheckBox;
    private javax.swing.JLabel developmentLabel;
    private javax.swing.JLabel habitatTreesLabel;
    private javax.swing.JTextField habitatTreesTextField;
    private javax.swing.JLabel harvestingAmountMaximumLabel;
    private javax.swing.JTextField harvestingAmountMaximumTextField;
    private javax.swing.JLabel harvestingAmountMinimumLabel;
    private javax.swing.JTextField harvestingAmountMinimumTextField;
    private javax.swing.JComboBox harvestingTypeComboBox;
    private javax.swing.JLabel harvestingTypeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel minimumCoverLabel;
    private javax.swing.JTextField minimumCoverTextField;
    private javax.swing.JCheckBox minorityProtectionCheckBox;
    private javax.swing.JLabel natureProtectionLabel;
    private javax.swing.JLabel plantAtLabel;
    private javax.swing.JTextField plantAtTextField;
    private javax.swing.JCheckBox plantingCheckbox;
    private javax.swing.JLabel plantingLabel;
    private javax.swing.JLabel protectionThicknessLabel;
    private javax.swing.JTextField protectionThicknessTextField;
    private javax.swing.JCheckBox releaseOnlyCropTreesCheckBox;
    private javax.swing.JLabel scenarioSettingsHeadingLabel;
    private javax.swing.JLabel simulationDurationLabel;
    private javax.swing.JTextField simulationDurationTextField;
    private javax.swing.JLabel simulationDurationUnitLabel;
    private javax.swing.JLabel skidtrailDistanceLabel;
    private javax.swing.JTextField skidtrailDistanceTextField;
    private javax.swing.JLabel skidtrailWidthLabel;
    private javax.swing.JTextField skidtrailWidthTextField;
    private javax.swing.JLabel speciesCodeLabel;
    private javax.swing.JTextField speciesCodeTextField;
    private javax.swing.JLabel speciesSettingsLabel;
    private javax.swing.JButton startSimulationButton;
    private javax.swing.JLabel thinningAmountMaximumLabel;
    private javax.swing.JTextField thinningAmountMaximumTextField;
    private javax.swing.JLabel thinningAmountMinimumLabel;
    private javax.swing.JTextField thinningAmountMinimumTextField;
    private javax.swing.JComboBox thinningIntensityComboBox;
    private javax.swing.JLabel thinningIntensityLabel;
    private javax.swing.JComboBox thinningTypeComboBox;
    private javax.swing.JLabel thinningTypeLabel;
    private javax.swing.JCheckBox unterstoryRemovalCheckBox;
    private javax.swing.JCheckBox useIngrowthModelCheckBox;
    private javax.swing.JCheckBox useRandomEffectsCheckBox;
    private javax.swing.JCheckBox useRiskModelCheckBox;
    private javax.swing.JComboBox woodTypeComboBox;
    // End of variables declaration//GEN-END:variables
    
}
