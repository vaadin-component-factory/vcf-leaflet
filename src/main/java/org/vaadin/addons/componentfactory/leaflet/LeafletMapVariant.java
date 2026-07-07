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

package org.vaadin.addons.componentfactory.leaflet;

import com.vaadin.flow.theme.lumo.Lumo;

/**
 * Set of theme variants applicable to the {@link LeafletMap} component.
 */
public enum LeafletMapVariant {
    /** Dark Lumo theme variant. */
    LUMO_DARK(Lumo.DARK),
    /** Light Lumo theme variant. */
    LUMO_LIGHT(Lumo.LIGHT);

    private final String variant;

    LeafletMapVariant(String variant) {
        this.variant = variant;
    }

    /**
     * Gets the theme variant name applied to the component.
     *
     * @return the variant name
     */
    public String getVariantName() {
        return variant;
    }
}