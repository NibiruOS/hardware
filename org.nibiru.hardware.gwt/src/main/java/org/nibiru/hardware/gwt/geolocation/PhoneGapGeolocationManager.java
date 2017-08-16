package org.nibiru.hardware.gwt.geolocation;

import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.geolocation.Geolocation;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationCallback;
import com.googlecode.gwtphonegap.client.geolocation.GeolocationOptions;
import com.googlecode.gwtphonegap.client.geolocation.PositionError;

import org.nibiru.hardware.core.api.geolocation.GeolocationManager;
import org.nibiru.hardware.core.api.geolocation.Position;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.model.core.impl.java.JavaValue;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class PhoneGapGeolocationManager implements GeolocationManager {
    private final Geolocation geolocation;

    @Inject
    public PhoneGapGeolocationManager(PhoneGap phoneGap) {
        checkNotNull(phoneGap);
        this.geolocation = phoneGap.getGeolocation();
    }

    @Override
    public Value<Position> watchPosition() {
        Value<Position> value = JavaValue.of(JavaType.of(Position.class));

        GeolocationOptions options = new GeolocationOptions();
        options.setTimeout(1000);

        geolocation.watchPosition(options, new GeolocationCallback() {
            @Override
            public void onSuccess(
                    com.googlecode.gwtphonegap.client.geolocation.Position position) {
                value.set(new PositionAdapter(position));
            }

            @Override
            public void onFailure(PositionError error) {
            }
        });
        return value;
    }
}
