package dev.huskuraft.universal.api.config;

import com.electronwill.nightconfig.core.Config;
import com.electronwill.nightconfig.core.ConfigSpec;

public interface ConfigSerializer<T> {

    ConfigSpec getSpec(Config config);

    T getDefault();

    T deserialize(Config config);

    Config serialize(T t);

    default void validate(Config config) {
        getSpec(config).correct(config);
    }

    default boolean isCorrect(Object config) {
        return config instanceof Config config1 && getSpec(config1).isCorrect(config1);
    }

}
