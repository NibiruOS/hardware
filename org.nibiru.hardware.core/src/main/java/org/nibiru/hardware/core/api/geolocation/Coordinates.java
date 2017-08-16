package org.nibiru.hardware.core.api.geolocation;

/**
 * Location coordinates.
 */
public interface Coordinates {
	/**
	 * @return The latitude
	 */
	double getLatitude();

	/**
	 * @return The longitude
	 */
	double getLongitude();

	/**
	 * @return The altitude
	 */
	double getAltitude();

	/**
	 * @return The accuracy
	 */
	double getAccuracy();

	double getSpeed();
}
