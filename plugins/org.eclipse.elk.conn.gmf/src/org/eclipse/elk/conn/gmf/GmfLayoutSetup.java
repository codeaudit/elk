/*******************************************************************************
 * Copyright (c) 2016 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Kiel University - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.conn.gmf;

import java.util.Collection;

import org.eclipse.elk.core.service.IDiagramLayoutConnector;
import org.eclipse.elk.core.service.ILayoutConfigurationStore;
import org.eclipse.elk.core.service.ILayoutSetup;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * Layout setup for the generic GMF connector.
 */
public class GmfLayoutSetup implements ILayoutSetup {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supports(final Object object) {
        if (object instanceof Collection) {
            Collection<?> collection = (Collection<?>) object;
            for (Object o : collection) {
                if (o instanceof IGraphicalEditPart) {
                    return true;
                }
            }
            return false;
        }
        return object instanceof DiagramEditor || object instanceof IGraphicalEditPart;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Injector createInjector(final Module defaultModule) {
        return Guice.createInjector(Modules.override(defaultModule).with(new GmfLayoutModule()));
    }
    
    /**
     * Guice module for the generic GMF connector.
     */
    public static class GmfLayoutModule implements Module {

        @Override
        public void configure(final Binder binder) {
            binder.bind(IDiagramLayoutConnector.class).to(GmfDiagramLayoutConnector.class);
            binder.bind(ILayoutConfigurationStore.Provider.class).to(GmfLayoutConfigurationStore.Provider.class);
        }
        
    }

}
