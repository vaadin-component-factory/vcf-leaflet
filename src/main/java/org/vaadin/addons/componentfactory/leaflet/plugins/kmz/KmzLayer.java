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

    /**
     * The event types fired by a {@link KmzLayer}.
     */
    public static enum KmzLayerEventType implements LeafletEventType {
        /** Fired when the KMZ file has finished loading and parsing. */
        load;
    }

    static {
        EventTypeRegistry.register(KmzLayerEventType.class);
    }

    @LeafletArgument
    private String url;

    /**
     * Instantiates a KMZ layer that loads the KMZ file at the given URL.
     *
     * @param url the URL of the KMZ file to load
     */
    public KmzLayer(String url) {
        this.url = url;
    }

    /**
     * Loads the KMZ file at the given URL into this layer.
     *
     * @param url the URL of the KMZ file to load
     */
    public void load(String url) {
        executeJs("load", url);
    }

    /**
     * Registers a listener notified when the KMZ file has finished loading.
     *
     * @param listener the listener to call when the event occurs, not {@code null}
     */
    public void onLoad(LeafletEventListener<LeafletEvent> listener) {
        on(KmzLayerEventType.load, listener);
    }

    /**
     * Returns the URL of the KMZ file loaded by this layer.
     *
     * @return the KMZ file URL
     */
    public String getUrl() {
        return url;
    }
}
