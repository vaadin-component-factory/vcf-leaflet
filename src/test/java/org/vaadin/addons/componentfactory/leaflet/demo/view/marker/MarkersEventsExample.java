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

package org.vaadin.addons.componentfactory.leaflet.demo.view.marker;

import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.demo.LeafletDemoApp;
import org.vaadin.addons.componentfactory.leaflet.demo.components.ExampleContainer;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.DefaultMapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.MapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.ui.marker.Marker;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;

@PageTitle("Marker events")
@Route(value = "marker/events", layout = LeafletDemoApp.class)
public class MarkersEventsExample extends ExampleContainer {

	private NativeLabel eventLabel;

	@Override
	protected void initDemo() {

		eventLabel = new NativeLabel();
		eventLabel.getStyle().set("font-weight", "bold");

		MapOptions options = new DefaultMapOptions();
		options.setCenter(new LatLng(47.070121823, 19.2041015625));
		options.setZoom(7);
		LeafletMap leafletMap = new LeafletMap(options);
		leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");

		Marker marker = new Marker(new LatLng(46.470121823, 18.3041015625));
		marker.setDraggable(true);
		marker.bindPopup("Hi, I'am an interactive marker!");
		marker.bindTooltip("hey, drag me if you want.");
		marker.onClick(this::logEvent);
		marker.onAdd(this::logEvent);
		marker.onDoubleClick(this::logEvent);
		marker.onPopupOpen(this::logEvent);
		marker.onPopupClose(this::logEvent);
		marker.onTooltipOpen(this::logEvent);
		marker.onTooltipClose(this::logEvent);
		marker.onDragStart(this::logEvent);
		marker.onDragEnd(this::logEvent);
		marker.onDrag(this::logEvent);
		marker.onContextMenuOpened(this::logEvent);
		marker.onMouseDown(this::logEvent);
		marker.onMouseUp(this::logEvent);
		marker.addTo(leafletMap);

		addToContent(eventLabel, leafletMap);
	}

	protected void logEvent(LeafletEvent leafletEvent) {
		this.eventLabel.setText("'" + leafletEvent.getType().name() + "' event caught in listener.");
	}
}
