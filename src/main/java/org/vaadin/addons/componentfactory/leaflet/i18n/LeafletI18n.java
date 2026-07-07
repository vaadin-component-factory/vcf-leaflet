
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

/*
* Internationalization object for customizing the component UI texts.
*/
package org.vaadin.addons.componentfactory.leaflet.i18n;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

import com.vaadin.flow.internal.JacksonUtils;

import tools.jackson.databind.JsonNode;

public class LeafletI18n implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8240099358732023102L;
    private static final JsonNode DEFAULT_I18N;

    static {
        try (InputStream in = LeafletI18n.class.getResourceAsStream("leaflet-i18n.json")) {
            DEFAULT_I18N = JacksonUtils
                    .readTree(new String(in.readAllBytes(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new IllegalStateException("Cannot find the default i18n configuration");
        }
    }

    /**
     * @return a new instance with the default messages
     */
    public static LeafletI18n createDefault() {
        return JacksonUtils.readValue(DEFAULT_I18N, LeafletI18n.class);
    }

}