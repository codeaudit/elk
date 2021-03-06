/*******************************************************************************
 * Copyright (c) 2015 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Kiel University - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.core.util.labelspacing;

import org.eclipse.elk.core.util.nodespacing.Rectangle;

/**
 * Information wrapper for size and position of a group of labels. Basically a {@link Rectangle}
 * with an additional field for the current y-offset inside the group, used while placing the
 * labels.
 * 
 * @author csp
 */
public final class LabelGroup extends Rectangle {

    /** Next free y position. */
    // SUPPRESS CHECKSTYLE NEXT 1 |
    public double nextLabelYPos = 0;
}