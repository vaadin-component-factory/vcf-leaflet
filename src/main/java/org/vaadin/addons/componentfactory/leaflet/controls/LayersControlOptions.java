package org.vaadin.addons.componentfactory.leaflet.controls;

import java.io.Serializable;

/**
 * Configuration options for a {@link LayersControl}.
 */
public class LayersControlOptions implements Serializable {

    private static final long serialVersionUID = 1218151748533368492L;
    private boolean collapsed = true;
    private boolean autoZIndex = true;
    private boolean hideSingleBase = false;
    private boolean sortLayers = false;

    /**
     * Gets whether the control is initially collapsed into an icon and expanded
     * on mouse hover or touch.
     *
     * @return {@code true} if the control is collapsed, {@code false} otherwise
     */
    public boolean isCollapsed() {
        return collapsed;
    }

    /**
     * Sets whether the control is initially collapsed into an icon and expanded
     * on mouse hover or touch.
     *
     * @param collapsed {@code true} to collapse the control, {@code false}
     *                  otherwise
     */
    public void setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
    }

    /**
     * Gets whether the z-index of the layers is set automatically based on
     * their order in the control.
     *
     * @return {@code true} if the z-index is set automatically, {@code false}
     *         otherwise
     */
    public boolean isAutoZIndex() {
        return autoZIndex;
    }

    /**
     * Sets whether the z-index of the layers is set automatically based on
     * their order in the control, enabling a correct display order for overlays.
     *
     * @param autoZIndex {@code true} to set the z-index automatically,
     *                   {@code false} otherwise
     */
    public void setAutoZIndex(boolean autoZIndex) {
        this.autoZIndex = autoZIndex;
    }

    /**
     * Gets whether the base layers section is hidden when there is only a
     * single base layer.
     *
     * @return {@code true} if a single base layer is hidden, {@code false}
     *         otherwise
     */
    public boolean isHideSingleBase() {
        return hideSingleBase;
    }

    /**
     * Sets whether the base layers section is hidden when there is only a
     * single base layer.
     *
     * @param hideSingleBase {@code true} to hide a single base layer,
     *                       {@code false} otherwise
     */
    public void setHideSingleBase(boolean hideSingleBase) {
        this.hideSingleBase = hideSingleBase;
    }

    /**
     * Gets whether the layers are sorted by name in the control.
     *
     * @return {@code true} if the layers are sorted, {@code false} otherwise
     */
    public boolean isSortLayers() {
        return sortLayers;
    }

    /**
     * Sets whether the layers are sorted by name in the control.
     *
     * @param sortLayers {@code true} to sort the layers, {@code false}
     *                   otherwise
     */
    public void setSortLayers(boolean sortLayers) {
        this.sortLayers = sortLayers;
    }

}
