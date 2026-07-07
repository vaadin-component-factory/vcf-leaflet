package org.vaadin.addons.componentfactory.leaflet.layer.vectors;

import java.io.Serializable;

/**
 * Contains options shared between vector overlays (Polygon, Polyline, Circle).
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * 
 * @since 2020-03-22
 * @version 1.0
 */
public class PathOptions implements Serializable {

	private static final long serialVersionUID = -7714457256248051646L;
	private boolean stroke = true;
	private String color = "#3388ff";
	private double weight = 3;
	private double opacity = 1.0;
	private String lineCap = "round";
	private String lineJoin = "round";
	private String dashArray;
	private String dashOffset;
	private boolean fill = true;
	private String fillColor = "#3388ff";
	private double fillOpacity = 0.2;
	private String fillRule = "evenodd";
	private String className;

	/**
	 * Creates a new set of path options initialized with the Leaflet default
	 * values.
	 */
	public PathOptions() {
	}

	/**
	 * Creates a new set of path options using the given color for both the stroke
	 * and the fill.
	 *
	 * @param color the stroke and fill color
	 */
	public PathOptions(String color) {
		this.color = color;
		this.fillColor = color;
	}

	/**
	 * Creates a new set of path options using the given color for both the stroke
	 * and the fill, and the given stroke width.
	 *
	 * @param color  the stroke and fill color
	 * @param weight the stroke width in pixels
	 */
	public PathOptions(String color, double weight) {
		this.color = color;
		this.fillColor = color;
		this.weight = weight;
	}

	/**
	 * Whether to draw stroke along the path.
	 *
	 * @return {@code true} if the stroke is drawn along the path
	 */
	public boolean isStroke() {
		return stroke;
	}

	/**
	 * Whether to draw stroke along the path. Set it to false to disable borders on
	 * polygons or circles.
	 * 
	 * @param stroke Set it to false to disable borders on polygons or circles.
	 */
	public void setStroke(boolean stroke) {
		this.stroke = stroke;
	}

	/**
	 * Gets the stroke color.
	 *
	 * @return the color of the stroke
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Stroke color
	 * 
	 * @param color the color of the stroke
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets the stroke width in pixels.
	 *
	 * @return the weight of the path
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Stroke width in pixels
	 * 
	 * @param weight the weight of the path
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Gets the stroke opacity.
	 *
	 * @return the opacity of the path
	 */
	public double getOpacity() {
		return opacity;
	}

	/**
	 * Stroke opacity
	 * 
	 * @param opacity the opacity of the path
	 */
	public void setOpacity(double opacity) {
		this.opacity = opacity;
	}

	/**
	 * Gets the shape to be used at the end of the stroke.
	 *
	 * @return the shape used at the end of the stroke
	 */
	public String getLineCap() {
		return lineCap;
	}

	/**
	 * A string that defines shape to be used at the end of the stroke.
	 * 
	 * @param lineCap shape to be used at the end of the stroke
	 */
	public void setLineCap(String lineCap) {
		this.lineCap = lineCap;
	}

	/**
	 * Gets the shape to be used at the corners of the stroke.
	 *
	 * @return the shape used at the corners of the stroke
	 */
	public String getLineJoin() {
		return lineJoin;
	}

	/**
	 * A string that defines shape to be used at the corners of the stroke.
	 * 
	 * @param lineJoin shape to be used at the corners of the stroke
	 */
	public void setLineJoin(String lineJoin) {
		this.lineJoin = lineJoin;
	}

	/**
	 * Gets the stroke dash pattern.
	 *
	 * @return the string that defines the stroke dash pattern
	 */
	public String getDashArray() {
		return dashArray;
	}

	/**
	 * A string that defines the stroke dash pattern. Doesn't work on Canvas-powered
	 * layers in some old browsers.
	 * 
	 * @param dashArray efines the stroke dash pattern
	 */
	public void setDashArray(String dashArray) {
		this.dashArray = dashArray;
	}

	/**
	 * Gets the distance into the dash pattern to start the dash.
	 *
	 * @return the string that defines the distance into the dash pattern to start
	 *         the dash
	 */
	public String getDashOffset() {
		return dashOffset;
	}

	/**
	 * A string that defines the distance into the dash pattern to start the dash.
	 * Doesn't work on Canvas-powered layers in some old browsers.
	 * 
	 * @param dashOffset defines the distance into the dash pattern to start the
	 *                   dash
	 */
	public void setDashOffset(String dashOffset) {
		this.dashOffset = dashOffset;
	}

	/**
	 * Whether to fill the path with color.
	 *
	 * @return {@code true} if the path is filled with color
	 */
	public boolean isFill() {
		return fill;
	}

	/**
	 * Whether to fill the path with color. Set it to false to disable filling on
	 * polygons or circles.
	 * 
	 * @param fill Set it to false to disable filling on polygons or circles
	 */
	public void setFill(boolean fill) {
		this.fill = fill;
	}

	/**
	 * Gets the fill color.
	 *
	 * @return the fill color of the path
	 */
	public String getFillColor() {
		return fillColor;
	}

	/**
	 * Fill color. Defaults to the value of the color option
	 * 
	 * @param fillColor the fill color of the path
	 */
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	/**
	 * Gets the fill opacity.
	 *
	 * @return the fill opacity (0 between 1)
	 */
	public double getFillOpacity() {
		return fillOpacity;
	}

	/**
	 * Fill opacity.
	 * 
	 * @param fillOpacity the fill opacity (0 between 1)
	 */
	public void setFillOpacity(double fillOpacity) {
		this.fillOpacity = fillOpacity;
	}

	/**
	 * Gets how the inside of a shape is determined.
	 *
	 * @return the string that defines how the inside of a shape is determined
	 */
	public String getFillRule() {
		return fillRule;
	}

	/**
	 * A string that defines how the inside of a shape is determined.
	 * 
	 * @param fillRule the string that defines how the inside of a shape is
	 *                 determined
	 */
	public void setFillRule(String fillRule) {
		this.fillRule = fillRule;
	}

	/**
	 * Gets the custom class name set on the element.
	 *
	 * @return the class name set on an element
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Custom class name set on an element. Only for SVG renderer.
	 * 
	 * @param className the class name set on an element
	 */
	public void setClassName(String className) {
		this.className = className;
	}

}
