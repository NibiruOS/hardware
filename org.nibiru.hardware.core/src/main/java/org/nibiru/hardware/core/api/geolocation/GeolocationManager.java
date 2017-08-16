package org.nibiru.hardware.core.api.geolocation;

import org.nibiru.model.core.api.Value;

/**
 * Manager for accessing geolocation information.
 */
public interface GeolocationManager {
    /**
     * Watches position changes.
     */
    Value<Position> watchPosition();
}
