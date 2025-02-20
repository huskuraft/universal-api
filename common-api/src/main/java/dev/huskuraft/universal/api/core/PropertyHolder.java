package dev.huskuraft.universal.api.core;

public record PropertyHolder(
        Property property,
        PropertyValue value
) {

    public String getAsString() {
        return property.getName() + "=" + property.getName(value);
    }

}
