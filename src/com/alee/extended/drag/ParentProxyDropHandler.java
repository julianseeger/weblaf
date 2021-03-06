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

package com.alee.extended.drag;

import javax.swing.*;
import java.awt.*;

/**
 * User: mgarin Date: 02.05.12 Time: 16:50
 */

public class ParentProxyDropHandler extends TransferHandler
{
    // Component onto which parent drop should be proxified
    private Component component;

    public ParentProxyDropHandler ( Component component )
    {
        super ();
        this.component = component;
    }

    public boolean canImport ( TransferHandler.TransferSupport info )
    {
        TransferHandler th = getParentTransferHandler ();
        return th != null && th.canImport ( info );
    }

    public boolean importData ( TransferHandler.TransferSupport info )
    {
        TransferHandler th = getParentTransferHandler ();
        return th != null && th.importData ( info );
    }

    private TransferHandler getParentTransferHandler ()
    {
        return getParentTransferHandler ( component.getParent () );
    }

    private TransferHandler getParentTransferHandler ( Container parent )
    {
        if ( parent != null && parent instanceof JComponent &&
                ( ( JComponent ) parent ).getTransferHandler () != null )
        {
            return ( ( JComponent ) parent ).getTransferHandler ();
        }
        else if ( parent != null && parent.getParent () != null )
        {
            return getParentTransferHandler ( parent.getParent () );
        }
        else
        {
            return null;
        }
    }
}