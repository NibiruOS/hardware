package org.nibiru.hardware.android.ioc;



import org.nibiru.hardware.android.geolocation.AndroidGeolocationManager;
import org.nibiru.hardware.core.api.geolocation.GeolocationManager;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {
	@Provides
	public GeolocationManager getGeolocationManager(AndroidGeolocationManager manager) {
		return manager;
	}
}
