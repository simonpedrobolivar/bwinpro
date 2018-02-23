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
package nwfva.assortment;

import java.io.*;
import javax.swing.filechooser.FileFilter;

/**
 * M�glichkeit die Dateiauswahl einzugrenzen
 * @author nagel
 */
public class TxtFileFilter extends FileFilter {
    
		String txt = "txt";
                public void TxtFileFilter(){
                    
                }
		public boolean accept(File f) {
			if(f.isDirectory())
				return true;
			String s = f.getName();
			int i = s.lastIndexOf('.');
			if(i > 0 &&  i < s.length() - 1) {
				String extension = s.substring(i+1).toLowerCase();
				if (txt.equals(extension) == true) 
					return true;
				else
					return false;
			}
			return false;
		}
                public void setExtension(String ext){
                    txt=ext;
                }
                
		public String getDescription() {
			return "Text Files (*."+txt+")";
		}
	}
