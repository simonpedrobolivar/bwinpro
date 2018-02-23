/* http://www.nw-fva.de
   Version 07-11-2008

   (c) 2002 Juergen Nagel, Northwest German Forest Research Station, 
       Gr�tzelstr.2, 37079 G�ttingen, Germany
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
import javax.swing.*;
/**
 *
 * @author  J. Nagel
 */
public class TgProgramInfo extends JPanel {
    
    /** Creates a new instance of TgProgramInfo */
    public TgProgramInfo(TgJFrame parent) {
            String name = parent.plugIn;
            name = name.replaceAll(".xml", ".jpg");
	    ImageIcon startImage = new ImageIcon(parent.programDir+System.getProperty("file.separator")+"models"+System.getProperty("file.separator")+
                    "logo"+System.getProperty("file.separator")+name);
            JLabel jLabelBild = new JLabel(startImage);
            add(jLabelBild);
 
}}
