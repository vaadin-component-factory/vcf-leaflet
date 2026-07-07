/*-
 * #%L
 * Leaflet
 * %%
 * Copyright (C) 2023 Vaadin Ltd
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
 
/* 
 * This file incorporates work licensed under the Apache License, Version 2.0
 * Copyright 2020 Gabor Kokeny and contributors
 */
package org.vaadin.addons.componentfactory.leaflet.operations;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;
import java.io.Serializable;
import org.vaadin.addons.componentfactory.leaflet.controls.LeafletControl;
import org.vaadin.addons.componentfactory.leaflet.layer.Identifiable;

/**
 * {@link LeafletOperation} class contains all pieces of information is required
 * to perform function invocations on client-side e.g. flyTo() on map.
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-03-11
 * @version 1.0
 */
public class LeafletOperation implements Serializable {

    private static final long serialVersionUID = -7752937288867492721L;
    private String layerId;
    private boolean controlOperation;
    private String functionName;
    private Serializable[] arguments;
    private final ObjectMapper mapper = JsonMapper.builder()
            .changeDefaultPropertyInclusion(incl -> incl.withValueInclusion(Include.NON_NULL))
            .build();

    /**
     * Creates a new operation describing a client-side function call on the
     * given target.
     *
     * @param target
     *            the client object (layer or control) the function is called on
     * @param functionName
     *            the name of the function to invoke
     * @param arguments
     *            the arguments passed to the function
     */
    public LeafletOperation(Identifiable target, String functionName, Serializable... arguments) {
        this.layerId = target.getUuid();
        this.functionName = functionName;
        this.arguments = arguments;
        this.controlOperation = target instanceof LeafletControl;
    }

    /**
     * Returns the id of the target layer the function is called on.
     *
     * @return the layerId
     */
    public String getLayerId() {
        return layerId;
    }

    /**
     * Returns the name of the function to invoke on the client side.
     *
     * @return the functionName
     */
    public String getFunctionName() {
        return functionName;
    }


    /**
     * Returns whether the operation targets a control rather than a layer.
     *
     * @return {@code true} if the target is a control
     */
    public boolean isControlOperation() {
        return controlOperation;
    }

    /**
     * Returns the operation arguments serialized to JSON.
     *
     * @return the arguments
     */
    public String getArguments() {
        try {
            return mapper.writeValueAsString(arguments);
        } catch (RuntimeException e) {
            throw new RuntimeException("Unable to convert arguments to JSON.", e);
        }
    }

}
