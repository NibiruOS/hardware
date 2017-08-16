package org.nibiru.hardware.android.geolocation;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import org.nibiru.hardware.core.api.geolocation.GeolocationManager;
import org.nibiru.hardware.core.api.geolocation.Position;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.model.core.impl.java.JavaValue;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class AndroidGeolocationManager implements GeolocationManager {
    private final LocationManager locationManager;

    @Inject
    public AndroidGeolocationManager(LocationManager locationManager) {
        this.locationManager = checkNotNull(locationManager);
    }

    @Override
    public Value<Position> watchPosition() {
        Value<Position> value = JavaValue.of(JavaType.of(Position.class));
        // TODO Provider type should be configrable
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000, 10, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        if (location != null) {
                            value.set(new LocationAdapter(location));
                        }
                    }

                    @Override
                    public void onStatusChanged(String arg0, int arg1,
                                                Bundle arg2) {
                    }

                    @Override
                    public void onProviderEnabled(String arg0) {
                    }

                    @Override
                    public void onProviderDisabled(String arg0) {
                    }

                });
        return value;
    }
}
