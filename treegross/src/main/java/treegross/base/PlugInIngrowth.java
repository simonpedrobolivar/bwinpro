/*   (c) 2002-2007 Juergen Nagel,  Northwest German Forest Research Station,
 Grätzelstr.2, 37079 Göttingen, Germany
 E-Mail: Juergen.Nagel@nw-fva.de
 
 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 For more information see:
 http://www.nw-fva.de/~nagel/treegross/

 */
package treegross.base;

/**
 * This class is the plugin adapter for the regional competition model. The
 * regional model needs to be based on the stand and tree classes.
 *
 * - Version 7.1 2-AUG-2007
 */
public interface PlugInIngrowth {

    /**
     * Interface to get the ingrowth of a stand.
     *
     * @param st Stand object
     * @throws java.lang.Exception
     */
    public void predictIngrowth(Stand st) throws Exception;

    /**
     * Check models for corresponding species code
     *
     * @param st Stand object
     * @return < 0 all species defined, > code of species not defined in
     * ingrowth
     * @throws Exception
     */
    public int checkSpecies(Stand st) throws Exception;

    /**
     *
     * @return Model name of ingrowth plugin
     * @throws Exception
     */
    public String getModelName() throws Exception;
}
