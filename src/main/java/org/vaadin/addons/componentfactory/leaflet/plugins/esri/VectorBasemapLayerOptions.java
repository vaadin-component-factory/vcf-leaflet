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
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Configuration options for a {@link VectorBasemapLayer}.
 * <p>
 * These options mirror the settings accepted by the esri-leaflet-vector
 * {@code vectorBasemapLayer} and control authentication and localization of the
 * requested ArcGIS vector basemap (API key or token, style version, language,
 * worldview, and places). The ArcGIS {@code apiKey} is required and therefore a
 * constructor argument.
 */
@Getter
@Setter
@RequiredArgsConstructor
public class VectorBasemapLayerOptions implements Serializable {

  private static final long serialVersionUID = 1L;

  private final String apiKey;
  private String token;
  private String version;
  private String language;
  private String worldview;
  private String places;

}
