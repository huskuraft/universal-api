package dev.huskuraft.universal.api.tag;

public interface TagSerializer<T> extends TagDecoder<T>, TagEncoder<T> {

    default T validate(T value) {
        return value;
    }

}
