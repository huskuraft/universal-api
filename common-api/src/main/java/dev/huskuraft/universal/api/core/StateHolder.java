package dev.huskuraft.universal.api.core;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dev.huskuraft.universal.api.platform.PlatformReference;

public interface StateHolder extends PlatformReference {

    Map<Property, PropertyValue> getPropertiesMap();

    default List<PropertyHolder> getProperties() {
        return getPropertiesMap().entrySet().stream().map(entry -> new PropertyHolder(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }

}
