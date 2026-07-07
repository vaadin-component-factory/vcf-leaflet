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
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.vaadin.addons.componentfactory.leaflet.annotations.LeafletArgument;

/**
 * <a href="https://github.com/Esri/esri-leaflet">Esri</a>
 * <a href="https://developers.arcgis.com/esri-leaflet/api-reference/layers/tiled-map-layer/">Tiled
 * map layer</a> plugin.  Access tiles from ArcGIS Online and ArcGIS Server.
 */
@AllArgsConstructor
public class TiledMapLayer extends EsriLeafletLayer {

  private static final long serialVersionUID = -7906787297109085580L;
  
  @Getter
  @LeafletArgument
  private final TiledMapLayerOptions options;
  
}
