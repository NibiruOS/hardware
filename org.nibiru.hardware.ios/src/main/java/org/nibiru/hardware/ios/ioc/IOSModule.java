package org.nibiru.hardware.ios.ioc;


import org.nibiru.hardware.core.api.geolocation.GeolocationManager;
import org.nibiru.hardware.ios.geolocation.DummyGeolocationManager;

import dagger.Module;
import dagger.Provides;

@Module
public class IOSModule {
	@Provides
	public GeolocationManager getGeolocationManager() {
		return new DummyGeolocationManager();
	}
}
