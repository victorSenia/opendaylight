/*
 * Copyright © 2016 Opendaylight and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.ext.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import org.opendaylight.openflowjava.protocol.api.util.EncodeConstants;

import org.opendaylight.openflowjava.protocol.api.extensibility.OFDeserializer;

import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.action.rev150203.actions.grouping.Action;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.action.rev150203.actions.grouping.ActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.types.rev130731.ExperimenterId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ext.rev150105.action.container.action.choice.ActionFoo;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ext.rev150105.action.container.action.choice.ActionFooBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ext.rev150105.action.container.action.choice.action.foo.ExtActionFooBuilder;

public class FooActionDeserializer implements OFDeserializer<Action> {

   @Override
   public Action deserialize(ByteBuf input) {

       input.skipBytes(EncodeConstants.SIZE_OF_SHORT_IN_BYTES); // we know the type of action
       input.skipBytes(EncodeConstants.SIZE_OF_SHORT_IN_BYTES); // we don't need length

       ActionBuilder actionBuilder = new ActionBuilder();
       actionBuilder.setExperimenterId(new ExperimenterId(input.readUnsignedInt()));
       ActionFooBuilder actionFooBuilder = new ActionFooBuilder();
       ExtActionFooBuilder extActionFooBuilder = new ExtActionFooBuilder();
       extActionFooBuilder.setFirst(input.readUnsignedShort());
       extActionFooBuilder.setSecond(input.readUnsignedShort());
       input.skipBytes(4); // padding
       actionFooBuilder.setExtActionFoo(extActionFooBuilder.build());
       actionBuilder.setActionChoice(actionFooBuilder.build());
       return actionBuilder.build();
   }
}
