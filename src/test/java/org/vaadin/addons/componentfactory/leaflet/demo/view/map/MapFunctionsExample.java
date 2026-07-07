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

package org.vaadin.addons.componentfactory.leaflet.demo.view.map;

import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.demo.LeafletDemoApp;
import org.vaadin.addons.componentfactory.leaflet.demo.components.ExampleContainer;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.DefaultMapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.MapOptions;
import org.vaadin.addons.componentfactory.leaflet.options.ZoomOptions;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;

@PageTitle("Map functions")
@Route(value = "map/functions", layout = LeafletDemoApp.class)
public class MapFunctionsExample extends ExampleContainer {

    @Override
    protected void initDemo() {

        NativeLabel eventLabel = new NativeLabel("Click on map to fly to a coordinate or right-click to fit World");
        eventLabel.getStyle().set("font-weight", "bold");

        final MapOptions options = new DefaultMapOptions();
        options.setCenter(new LatLng(47.070121823, 19.204101562500004));
        options.setZoom(7);
        final LeafletMap leafletMap = new LeafletMap(options);
        leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");

        leafletMap.onClick((event) -> {
            leafletMap.flyTo(event.getLatLng(), options.getZoom(), new ZoomOptions());
        });
        leafletMap.onContextMenuOpened((event) -> {
            leafletMap.fitWorld();
        });

        addToContent(eventLabel, leafletMap);
    }

}
