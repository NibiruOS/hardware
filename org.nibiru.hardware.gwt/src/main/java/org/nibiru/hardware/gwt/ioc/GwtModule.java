package org.nibiru.hardware.gwt.ioc;


import org.nibiru.hardware.core.api.geolocation.GeolocationManager;
import org.nibiru.hardware.gwt.geolocation.PhoneGapGeolocationManager;

import dagger.Module;
import dagger.Provides;

@Module
public class GwtModule {
    @Provides
    public GeolocationManager getBootstrap(PhoneGapGeolocationManager manager) {
        return manager;
    }
}
