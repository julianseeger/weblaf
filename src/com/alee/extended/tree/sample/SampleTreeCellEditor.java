/*
* This file is part of WebLookAndFeel library.
*
* WebLookAndFeel library is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* WebLookAndFeel library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.extended.tree.sample;

import com.alee.laf.text.WebTextField;
import com.alee.laf.tree.WebTreeCellEditor;

import javax.swing.*;
import java.awt.*;

/**
 * Sample tree cell editor.
 *
 * @author Mikle Garin
 * @since 1.4
 */

public class SampleTreeCellEditor extends WebTreeCellEditor
{
    /**
     * Last edited node.
     */
    private SampleNode sampleNode;

    /**
     * Constructs sample tree cell editor.
     */
    public SampleTreeCellEditor ()
    {
        super ();
    }

    /**
     * Returns custom tree cell editor component.
     *
     * @param tree       tree
     * @param value      cell value
     * @param isSelected whether cell is selected or not
     * @param expanded   whether cell is expanded or not
     * @param leaf       whether cell is leaf or not
     * @param row        cell row index
     * @return cell editor component
     */
    public Component getTreeCellEditorComponent ( JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row )
    {
        this.sampleNode = ( SampleNode ) value;
        WebTextField editor = ( WebTextField ) super.getTreeCellEditorComponent ( tree, value, isSelected, expanded, leaf, row );
        editor.setText ( sampleNode.getName () );
        return editor;
    }

    /**
     * Returns current editor's value.
     *
     * @return current editor's value
     */
    public Object getCellEditorValue ()
    {
        sampleNode.setName ( super.getCellEditorValue ().toString () );
        return sampleNode.getName ();
    }
}