package org.nibiru.hardware.gwt.geolocation;


import org.nibiru.hardware.core.api.geolocation.Coordinates;
import org.nibiru.hardware.core.api.geolocation.Position;

import static com.google.common.base.Preconditions.checkNotNull;

public class PositionAdapter implements Position {
    private final com.googlecode.gwtphonegap.client.geolocation.Position position;

    public PositionAdapter(
            com.googlecode.gwtphonegap.client.geolocation.Position position) {
        this.position = checkNotNull(position);
    }

    @Override
    public Coordinates getCoordinates() {
        return new CoordinatesAdapter(position.getCoordinates());
    }

    @Override
    public long getTimeStamp() {
        return position.getTimeStamp();
    }
}
