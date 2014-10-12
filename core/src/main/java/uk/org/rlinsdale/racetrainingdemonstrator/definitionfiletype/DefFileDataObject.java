/*
 * Copyright (C) 2014 Richard Linsdale (richard.linsdale at blueyonder.co.uk)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package uk.org.rlinsdale.racetrainingdemonstrator.definitionfiletype;

import java.io.IOException;
import uk.org.rlinsdale.racetrainingdemonstrator.core.ScenarioEditorDisplay;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.text.MultiViewEditorElement;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * The DataObject for the definition file.
 * 
 * @author Richard Linsdale (richard.linsdale at blueyonder.co.uk)
 */
@Messages({
    "LBL_DefFile_LOADER=Definition Files"
})
@MIMEResolver.ExtensionRegistration(
        displayName = "#LBL_DefFile_LOADER",
        mimeType = "text/x-rtd",
        extension = {"rtd", "RTD"})
@DataObject.Registration(
        mimeType = "text/x-rtd",
        iconBase = "uk/org/rlinsdale/racetrainingdemonstrator/definitionfiletype/shape_flip_horizontal.png",
        displayName = "#LBL_DefFile_LOADER",
        position = 300)
@ActionReferences({
    @ActionReference(
            path = "Loaders/text/x-rtd/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.OpenAction"),
            position = 100,
            separatorAfter = 200),
    @ActionReference(
            path = "Loaders/text/x-rtd/Actions",
            id =
            @ActionID(category = "Edit", id = "org.openide.actions.CutAction"),
            position = 300),
    @ActionReference(
            path = "Loaders/text/x-rtd/Actions",
            id =
            @ActionID(category = "Edit", id = "org.openide.actions.CopyAction"),
            position = 400,
            separatorAfter = 500),
    @ActionReference(
            path = "Loaders/text/x-rtd/Actions",
            id =
            @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"),
            position = 600),
    @ActionReference(
            path = "Loaders/text/x-rtd/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.RenameAction"),
            position = 700,
            separatorAfter = 800),
    @ActionReference(
            path = "Loaders/text/x-rtd/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.SaveAsTemplateAction"),
            position = 900,
            separatorAfter = 1000),
    @ActionReference(
            path = "Loaders/text/x-rtd/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.FileSystemAction"),
            position = 1100,
            separatorAfter = 1200),
    @ActionReference(
            path = "Loaders/text/x-rtd/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.ToolsAction"),
            position = 1300),
    @ActionReference(
            path = "Loaders/text/x-rtd/Actions",
            id =
            @ActionID(category = "System", id = "org.openide.actions.PropertiesAction"),
            position = 1400)
})
public class DefFileDataObject extends MultiDataObject {

    /**
     * Constructor.
     * 
     * @param pf the file object
     * @param loader the loader
     * @throws DataObjectExistsException if failure
     * @throws IOException if failure
     */
    public DefFileDataObject(FileObject pf, MultiFileLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        registerEditor("text/x-rtd", true);
    }

    @Override
    protected int associateLookup() {
        return 1;
    }

    /**
     * Create the associated editor element.
     * 
     * @param lkp the top component element
     * @return the editor element
     */
    @MultiViewElement.Registration(
            displayName = "#LBL_DefFile_EDITOR",
            iconBase = "uk/org/rlinsdale/racetrainingdemonstrator/definitionfiletype/shape_flip_horizontal.png",
            mimeType = "text/x-rtd",
            persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED,
            preferredID = "DefFile",
            position = 1000)
    @Messages("LBL_DefFile_EDITOR=Definition File")
    public static MultiViewEditorElement createEditor(Lookup lkp) {
        return new ScenarioEditorDisplay(lkp);
    }
}