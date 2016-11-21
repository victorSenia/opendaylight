/*
 * Copyright © 2016 Opendaylight and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.ext.impl;

import java.util.List;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ext.config.rev161101.modules.module.configuration.OpenflowjavaExtension;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ext.config.rev161101.modules.module.configuration.OpenflowjavaExtensionBuilder;
import org.opendaylight.openflowjava.protocol.api.util.EncodeConstants;
import org.opendaylight.openflowjava.protocol.spi.connection.SwitchConnectionProvider;
import org.opendaylight.openflowjava.protocol.api.keys.ExperimenterActionSerializerKey;
import org.opendaylight.openflowjava.protocol.api.keys.ExperimenterActionDeserializerKey;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtProvider {

    private static final Logger LOG = LoggerFactory.getLogger(ExtProvider.class);

    private final DataBroker dataBroker;
    private final List<SwitchConnectionProvider> providers;

    public ExtProvider(final DataBroker dataBroker) {
        this.dataBroker = dataBroker;

        OpenflowjavaExtensionBuilder builder = new OpenflowjavaExtensionBuilder();
        this.providers = builder.build().getOpenflowSwitchConnectionProvider();
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
      // helper = new ActionSerializerRegistryHelper(EncodeConstants.OF13_VERSION_ID, serializerRegistry);
      // helper.registerSerializer(ActionFoo.class, new FooActionSerializer());
      //ExperimenterActionSerializerKey key1 =
      //        new ExperimenterActionSerializerKey(EncodeConstants.OF13_VERSION_ID, ExtConstants.EXPERIMENTER_ID, null);
      //SwitchConnectionProviderImpl.registerActionSerializer(key1, new FooActionSerializer());
      //SwitchConnectionProvider.registerActionDeserializer(key, new FooActionDeserializer());
        LOG.info("ExtProvider Session Initiated");
    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    public void close() {
    //    ExperimenterActionSerializerKey key =
    //          new ExperimenterActionSerializerKey(EncodeConstants.OF13_VERSION_ID, ExtConstants.EXPERIMENTER_ID, null);
    //    SwitchConnectionProvider.unregisterSerializer(key);
    //    SwitchConnectionProvider.unregisterDeserializer(key);
        LOG.info("ExtProvider Closed");
    }
}
