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
package org.vaadin.addons.componentfactory.leaflet.plugins.esri;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import org.vaadin.addons.componentfactory.leaflet.layer.Layer;

/**
 * Abstract base class for layers provided by the esri-leaflet plugin.
 * <p>
 * It loads the required {@code esri-leaflet} client-side resources and serves as
 * the common parent for the concrete Esri layer implementations (such as
 * {@link DynamicMapLayer}).
 */
@NpmPackage(value = "esri-leaflet", version = "3.0.12")
@NpmPackage(value = "maplibre-gl", version = "3.6.2")
@JsModule("esri-leaflet/dist/esri-leaflet.js")
public abstract class EsriLeafletLayer extends Layer {

}
