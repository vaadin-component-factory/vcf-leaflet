package org.vaadin.addons.componentfactory.leaflet;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import org.vaadin.addons.componentfactory.leaflet.annotations.LeafletArgument;
import org.vaadin.addons.componentfactory.leaflet.layer.Identifiable;
import org.vaadin.addons.componentfactory.leaflet.layer.map.functions.ExecutableFunctions;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

/**
 * Base class for serializable client-side Leaflet objects. It provides a unique
 * identifier, JSON serialization and access to the Leaflet constructor
 * arguments declared through {@link LeafletArgument}.
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(value = { "json" })
public abstract class LeafletObject implements ExecutableFunctions, Serializable {
    private static final long serialVersionUID = -1268468998583672106L;
    private String json;
    private String uuid;
    private ExecutableFunctions parent;
    private final ObjectMapper objectMapper;

    /**
     * Creates a new Leaflet object, initializing its Jackson mapper and
     * assigning it a random unique identifier.
     */
    protected LeafletObject() {
        JsonMapper.Builder builder = JsonMapper.builder();
        configureObjectMapper(builder);
        this.objectMapper = builder.build();
        this.uuid = UUID.randomUUID().toString();
    }

    /**
     * Hook for subclasses to customize the Jackson mapper used for serializing
     * this object. Jackson 3 mappers are immutable, so configuration must be
     * applied to the {@link JsonMapper.Builder} before the mapper is built.
     *
     * @param builder
     *            the mapper builder to configure
     */
    protected void configureObjectMapper(final JsonMapper.Builder builder) {
    }

    /**
     * Returns the unique identifier of this object.
     *
     * @return the object uuid
     */
    @Override
    public String getUuid() {
        return this.uuid;
    }

    /**
     * Returns the JSON representation of this object, computing it lazily on
     * first access.
     *
     * @return the JSON representation of this object
     */
    public String getJson() {
        if (this.json == null) {
            try {
                this.json = objectMapper.writeValueAsString(this);
                return this.json;
            } catch (RuntimeException e) {
                throw new RuntimeException("Unable to convert Layer into JSON type", e);
            }
        }
        return this.json;
    }

    /**
     * Returns the names of the fields used as client-side constructor
     * arguments, ordered by their {@link LeafletArgument} index.
     *
     * @return the constructor argument names
     */
    public List<String> getConstructorArgumentNames() {
        return findLeafletArguments(getClass()).stream().map(Field::getName).distinct().collect(Collectors.toList());
    }

    /**
     * Returns the Leaflet type name of this object, used to instantiate the
     * matching class on the client side.
     *
     * @return the Leaflet type name
     */
    public String getLeafletType() {
        return getClass().getSimpleName();
    }

    static List<Field> findLeafletArguments(Class<?> layer) {
        List<Field> fields = Arrays.asList(layer.getDeclaredFields()).stream()
                .filter(f -> f.isAnnotationPresent(LeafletArgument.class))
                .sorted(Comparator.comparingInt(field-> field.getAnnotation(LeafletArgument.class).index()))
                .collect(Collectors.toList());
        if (layer.getSuperclass() != null) {
            fields.addAll(findLeafletArguments(layer.getSuperclass()));
        }
        return fields;
    }
    
    /**
     * Delegates the execution of the named client-side function to the parent,
     * if any.
     *
     * @param target
     *            the client object to invoke the function on
     * @param functionName
     *            the name of the function to call
     * @param arguments
     *            the arguments passed to the function
     */
    @Override
    public void executeJs(Identifiable target, String functionName, Serializable... arguments) {
        if (parent instanceof ExecutableFunctions) {
            parent.executeJs(target, functionName, arguments);
        }
    }

    /**
     * Delegates a client-side function call, returning a result, to the parent,
     * if any.
     *
     * @param <T>
     *            the type of the returned result
     * @param target
     *            the client object to invoke the function on
     * @param functionName
     *            the name of the function to call
     * @param resultType
     *            the type the client result should be deserialized to
     * @param arguments
     *            the arguments passed to the function
     * @return a future completed with the function result, or {@code null} if
     *         there is no parent to delegate to
     */
    @Override
    public <T extends Serializable> CompletableFuture<T> call(Identifiable target, String functionName, Class<T> resultType, Serializable... arguments) {
        if (parent instanceof ExecutableFunctions) {
            return parent.call(target, functionName, resultType, arguments);
        } else {
            return null;
        }
    }

    /**
     * Sets the parent through which client-side function calls are delegated.
     *
     * @param parent
     *            the parent to set
     */
    protected void setParent(ExecutableFunctions parent) {
        this.parent = parent;
    }

    /**
     * Returns the parent through which client-side function calls are
     * delegated.
     *
     * @return the parent
     */
    protected ExecutableFunctions getParent() {
        return parent;
    }
}
