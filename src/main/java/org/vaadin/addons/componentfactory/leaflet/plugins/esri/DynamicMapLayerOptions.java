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

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Configuration options for a {@link DynamicMapLayer}.
 * <p>
 * These options mirror the settings accepted by the esri-leaflet
 * {@code dynamicMapLayer} and control how the ArcGIS dynamic map service is
 * requested and rendered (image format, transparency, visible layers, zoom
 * range, authentication, caching, and so on). The service {@code url} is
 * required and therefore a constructor argument.
 */
@Getter
@Setter
@RequiredArgsConstructor
public class DynamicMapLayerOptions implements Serializable {

  private static final long serialVersionUID = 1L;

  private final String url;
  private String format;
  private boolean transparent = true;
  private String f = "json";
  private String attribution;
  private int[] layers;
  private LayerDef[] layerDefs;
  private Double opacity;
  private String pane;
  private int zIndex;
  private String position;
  private Integer minZoom;
  private Integer maxZoom;
  private boolean disableCache = true;
  private String token;
  private String proxy;
  private boolean useCors = true;

  /**
   * Definition filter applied to a single sub-layer of the dynamic map service.
   * <p>
   * It associates a layer index with a SQL {@code query} (where clause) used to
   * restrict the features rendered for that layer.
   */
  @AllArgsConstructor
  @Getter
  public static class LayerDef implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int layer;
    private final String query;
  }

}
