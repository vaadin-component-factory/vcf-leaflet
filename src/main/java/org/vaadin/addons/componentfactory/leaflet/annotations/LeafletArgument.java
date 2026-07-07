package org.vaadin.addons.componentfactory.leaflet.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Most Leaflet classes have constructor with custom arguments. The fields in
 * the @Layer classes marked with this annotation will be injected as
 * constructor arguments on client-side during the layer instantiation. You can
 * change the argument orders with index parameter.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface LeafletArgument {
    /**
     * The position of the annotated field in the client-side constructor
     * argument list.
     *
     * @return the argument index
     */
    int index() default 0;
}