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

package org.vaadin.addons.componentfactory.leaflet.layer;

import org.vaadin.addons.componentfactory.leaflet.layer.vectors.PathOptions;

/**
 * Common interface of the leaflet layers which have style.
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-03-12
 * @version 1.0
 * 
 * @see PathOptions
 */
public interface HasStyle {

    /**
     * Returns the current path style options applied to this layer.
     *
     * @return the current style options
     */
    PathOptions getStyle();

    /**
     * Changes the appearance of this layer by applying the given path style
     * options.
     *
     * @param pathOptions the style options to apply
     */
    void setStyle(PathOptions pathOptions);
}
