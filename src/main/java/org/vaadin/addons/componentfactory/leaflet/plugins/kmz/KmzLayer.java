package org.vaadin.addons.componentfactory.leaflet.plugins.kmz;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import org.vaadin.addons.componentfactory.leaflet.annotations.LeafletArgument;
import org.vaadin.addons.componentfactory.leaflet.layer.Layer;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.EventTypeRegistry;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.LeafletEventType;

/**
 * <h2>KMZ file loader for Leaflet Maps</h2>
 * 
 * Web component: <a href=
 * "https://www.npmjs.com/package/leaflet-kmz">https://www.npmjs.com/package/leaflet-kmz</a><br>
 * <br>
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-07-23
 * @version 1.0
 */
@NpmPackage(value = "leaflet-kmz", version = "1.0.9")
@JsModule("leaflet-kmz/dist/leaflet-kmz-src.js")
public class KmzLayer extends Layer {

    private static final long serialVersionUID = 6515861726518730409L;

    public static enum KmzLayerEventType implements LeafletEventType {
        load;
    }

    static {
        EventTypeRegistry.register(KmzLayerEventType.class);
    }

    @LeafletArgument
    private String url;

    public KmzLayer(String url) {
        this.url = url;
    }

    public void load(String url) {
        executeJs("load", url);
    }

    public void onLoad(LeafletEventListener<LeafletEvent> listener) {
        on(KmzLayerEventType.load, listener);
    }

    public String getUrl() {
        return url;
    }
}
