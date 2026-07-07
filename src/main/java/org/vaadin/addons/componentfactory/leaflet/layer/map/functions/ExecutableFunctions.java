// Copyright 2020 Gabor Kokeny and contributors
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.vaadin.addons.componentfactory.leaflet.layer.map.functions;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import org.vaadin.addons.componentfactory.leaflet.layer.Identifiable;

/**
 * Defines the operations for invoking Leaflet JavaScript functions on the
 * client side, either as fire-and-forget calls or as calls that return a
 * result.
 */
public interface ExecutableFunctions extends Identifiable {

    /**
     * Executes the given client-side JavaScript function on this object without
     * expecting a return value.
     *
     * @param functionName the name of the client-side function to execute
     * @param arguments    the arguments passed to the function
     */
    default void executeJs(String functionName, Serializable... arguments) {
        executeJs(this, functionName, arguments);
    }

    /**
     * Executes the given client-side JavaScript function on the given target
     * without expecting a return value.
     *
     * @param target       the object the function is executed on
     * @param functionName the name of the client-side function to execute
     * @param arguments    the arguments passed to the function
     */
    void executeJs(Identifiable target, String functionName, Serializable... arguments);

    /**
     * Calls the given client-side JavaScript function on this object and returns
     * its result asynchronously.
     *
     * @param <T>          the type of the returned result
     * @param functionName the name of the client-side function to call
     * @param resultType   the type the result is converted to
     * @param arguments    the arguments passed to the function
     * @return a future that completes with the result of the client-side call
     */
    default <T extends Serializable> CompletableFuture<T> call(String functionName, Class<T> resultType,
            Serializable... arguments) {
        return call(this, functionName, resultType, arguments);
    }

    /**
     * Calls the given client-side JavaScript function on the given target and
     * returns its result asynchronously.
     *
     * @param <T>          the type of the returned result
     * @param target       the object the function is called on
     * @param functionName the name of the client-side function to call
     * @param resultType   the type the result is converted to
     * @param arguments    the arguments passed to the function
     * @return a future that completes with the result of the client-side call
     */
    <T extends Serializable> CompletableFuture<T> call(Identifiable target, String functionName, Class<T> resultType,
            Serializable... arguments);

}