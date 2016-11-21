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
import org.opendaylight.openflowjava.protocol.api.extensibility.OFSerializer;

import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.action.rev150203.actions.grouping.Action;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.action.rev150203.actions.grouping.ActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ext.rev150105.action.container.action.choice.ActionFoo;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ext.rev150105.action.container.action.choice.ActionFooBuilder;



public class FooActionSerializer implements OFSerializer<Action> {

  public static final short MESSAGE_LENGTH = 16;

   @Override
   public void serialize(Action action, ByteBuf outBuffer) {
       outBuffer.writeShort(EncodeConstants.EXPERIMENTER_VALUE);
       outBuffer.writeShort(MESSAGE_LENGTH);
       // we don't have to check for ExperimenterIdAction augmentation - our serializer
       // was called based on the vendor / experimenter ID, so we simply write it to buffer
       outBuffer.writeInt(ExtConstants.EXPERIMENTER_ID.intValue());

       ActionFoo foo = ((ActionFoo) action.getActionChoice());
       outBuffer.writeShort(foo.getExtActionFoo().getFirst().shortValue());
       outBuffer.writeShort(foo.getExtActionFoo().getSecond().shortValue());
       outBuffer.writeZero(4); //write padding
   }
}
