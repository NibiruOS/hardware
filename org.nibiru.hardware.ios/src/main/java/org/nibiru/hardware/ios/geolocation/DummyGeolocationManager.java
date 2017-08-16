package org.nibiru.hardware.ios.geolocation;


import org.nibiru.hardware.core.api.geolocation.GeolocationManager;
import org.nibiru.hardware.core.api.geolocation.Position;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.model.core.impl.java.JavaValue;

public class DummyGeolocationManager implements GeolocationManager {
    @Override
    public Value<Position> watchPosition() {
        // TODO Implement Location manager
        Value<Position> value = JavaValue.of(JavaType.of(Position.class));
        return value;
    }
}
