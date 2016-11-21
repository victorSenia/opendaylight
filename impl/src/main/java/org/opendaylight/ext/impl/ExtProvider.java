/*
 * Copyright © 2016 Opendaylight and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.ext.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ext.rev150105.ExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtProvider {

    private static final Logger LOG = LoggerFactory.getLogger(ExtProvider.class);

    private final DataBroker dataBroker;
    private final RpcProviderRegistry rpcProviderRegistry;
    private BindingAwareBroker.RpcRegistration<ExtService> serviceRegistration;

    public ExtProvider(final DataBroker dataBroker, RpcProviderRegistry rpcProviderRegistry) {
        this.dataBroker = dataBroker;
        this.rpcProviderRegistry = rpcProviderRegistry;
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        serviceRegistration = rpcProviderRegistry.addRpcImplementation(ExtService.class, new ExtHelloWorldImpl());
        LOG.info("ExtProvider Session Initiated");
    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    public void close() {
        serviceRegistration.close();
        LOG.info("ExtProvider Closed");
    }
}