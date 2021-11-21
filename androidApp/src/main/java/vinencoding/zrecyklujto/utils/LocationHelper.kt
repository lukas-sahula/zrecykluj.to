package vinencoding.zrecyklujto.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import vinencoding.zrecyklujto.MainActivity

class LocationHelper {

    private val locationRefreshTime = 3000 // 3 seconds. The Minimum Time to get location update
    private val locationRefreshDistance = 30 // 30 meters. The Minimum Distance to be changed to get location update

    var myLocationListener: MyLocationListener? = null

    interface MyLocationListener {
        fun onLocationChanged(location: Location)
    }

    fun startListeningUserLocation(context: Context, myListener: MyLocationListener) {
        myLocationListener = myListener

        val mLocationManager = context.getSystemService(LOCATION_SERVICE) as LocationManager

        val mLocationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {

                myLocationListener!!.onLocationChanged(location) // calling listener to inform that updated location is available
            }
            override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }
        // check for permissions
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
            && ContextCompat.checkSelfPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, locationRefreshTime.toLong(),locationRefreshDistance.toFloat(), mLocationListener)
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, Manifest.permission.ACCESS_FINE_LOCATION) || ActivityCompat.shouldShowRequestPermissionRationale(context,Manifest.permission.ACCESS_COARSE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(context,arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),Constants.LOCATION_PERMISSION_REQUEST_CODE)
            }
        }
    }
}