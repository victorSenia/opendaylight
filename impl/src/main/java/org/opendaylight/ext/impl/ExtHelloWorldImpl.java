/*
 * Copyright © 2016 Opendaylight and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.ext.impl;

import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ext.rev150105.ExtHelloWorldInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ext.rev150105.ExtHelloWorldOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ext.rev150105.ExtHelloWorldOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ext.rev150105.ExtService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;

import java.util.concurrent.Future;

public class ExtHelloWorldImpl implements ExtService {

    @Override
    public Future<RpcResult<ExtHelloWorldOutput>> extHelloWorld(ExtHelloWorldInput input) {
        ExtHelloWorldOutputBuilder helloBuilder = new ExtHelloWorldOutputBuilder();
        helloBuilder.setGreeting("Hello " + input.getName());
        return RpcResultBuilder.success(helloBuilder.build()).buildFuture();
    }
}