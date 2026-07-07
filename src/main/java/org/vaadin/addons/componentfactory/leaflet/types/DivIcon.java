package org.vaadin.addons.componentfactory.leaflet.types;

/**
 * Represents a lightweight icon for markers that uses a simple element
 * instead of an image. Inherits from Icon but ignores the iconUrl and shadow
 * options. <br>
 * <br>
 * By default, it has a 'leaflet-div-icon' CSS class and is styled as a little
 * white square with a shadow.
 * 
 * 
 * <h2>Usage example</h2>
 * 
 * <pre>
 * Marker marker = new Marker(new LatLng(47.1, 18.4));
 * marker.setIcon(new DivIcon("my-div-icon"));
 * marker.addTo(leafletMap);
 * </pre>
 * 
 * 
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-05-29
 * @version 1.0
 */
public class DivIcon extends Icon {

    private static final long serialVersionUID = 5260221030669197125L;
    private static final String CSS_CLASS = "leaflet-div-icon";
    private String html;
    private Point bgPos = Point.of(0, 0);

    /**
     * Creates a DivIcon using the default {@code leaflet-div-icon} CSS class.
     */
    public DivIcon() {
        this(CSS_CLASS);
    }

    /**
     * Creates a DivIcon using the given CSS class name.
     *
     * @param className
     *            the CSS class name to apply to the icon element
     */
    public DivIcon(String className) {
        super();
        setClassName(className);
    }

    /**
     * Returns the custom HTML code placed inside the div element.
     *
     * @return the custom HTML content, or {@code null} if none is set
     */
    public String getHtml() {
        return html;
    }

    /**
     * Sets the custom HTML code to put inside the div element, empty by
     * default. Alternatively, an instance of HTMLElement.
     * 
     * @param html
     *            custom HTML code to put inside the div
     */
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     * Returns the relative position of the background, in pixels.
     *
     * @return the background position
     */
    public Point getBgPos() {
        return bgPos;
    }

    /**
     * Sets the Optional relative position of the background, in pixels
     *
     * @param bgPos
     *            the position of the background to be used
     */
    public void setBgPos(Point bgPos) {
        this.bgPos = bgPos;
    }
}
