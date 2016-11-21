/*
 * Copyright © 2016 Opendaylight and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.ext.cli.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.opendaylight.ext.cli.api.ExtCliCommands;

public class ExtCliCommandsImpl implements ExtCliCommands {

    private static final Logger LOG = LoggerFactory.getLogger(ExtCliCommandsImpl.class);
    private final DataBroker dataBroker;

    public ExtCliCommandsImpl(final DataBroker db) {
        this.dataBroker = db;
        LOG.info("ExtCliCommandImpl initialized");
    }

    @Override
    public Object testCommand(Object testArgument) {
        return "This is a test implementation of test-command";
    }
}