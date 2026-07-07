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
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.vaadin.addons.componentfactory.leaflet.annotations.LeafletArgument;

/**
 * Esri layer that renders an ArcGIS vector basemap using the esri-leaflet-vector
 * {@code vectorBasemapLayer}.
 * <p>
 * The layer is identified by a basemap style key and configured through
 * {@link VectorBasemapLayerOptions}, which must supply the ArcGIS API key or
 * token used to authenticate the basemap requests.
 */
@RequiredArgsConstructor
@Getter
@NpmPackage(value = "esri-leaflet-vector", version = "4.2.3")
@JsModule("esri-leaflet-vector/dist/esri-leaflet-vector.js")
@JsModule("./esri-vector-basemap-layer.js")
public class VectorBasemapLayer extends EsriLeafletLayer {

  private static final long serialVersionUID = 1L;

  /** 
   * key refers to a basemap style enumeration, or to the item ID of a custom basemap style.
   */  
  @LeafletArgument
  private final String key;
  
  @LeafletArgument
  private final VectorBasemapLayerOptions options;

}
