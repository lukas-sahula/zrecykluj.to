package vinencoding.zrecyklujto.fragments

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.fragment.app.Fragment
import vinencoding.zrecyklujto.R
import vinencoding.zrecyklujto.utils.Constants
import vinencoding.zrecyklujto.utils.LocationHelper


class MapFragment : Fragment() {

    //sets default location when location permission is denied
    var latitude: Double = 50.073658
    var longitude: Double = 14.418540

    val mapyczHtml: String = "<!doctype html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<script src=\"https://api.mapy.cz/loader.js\"></script>\n" +
            "\t<script>Loader.load()</script>\n" +
            "</head>\n" +
            "\n" +
            "<body style=\"margin: 0; padding: 0\">\n" +
            "\t<div id=\"mapa\" style=\"width:100vw; height:100vh;\"></div>\n" +
            "\t<script type=\"text/javascript\">\n" +
            "\t\tvar stred = SMap.Coords.fromWGS84(14.41, 50.08);\n" +
            "\t\tvar mapa = new SMap(JAK.gel(\"mapa\"), stred, 10);\n" +
            "\t\tmapa.addDefaultLayer(SMap.DEF_BASE).enable();\n" +
            "\t\tmapa.addDefaultControls();\t      \t      \n" +
            "\t</script>\n" +
            "</body>\n" +
            "</html>"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webview: WebView = view.findViewById(R.id.webview)
        webview.settings.javaScriptEnabled = true
        webview.loadData(mapyczHtml, "text/html", "UTF-8") // todo search for containers with https://api.mapy.cz/view?page=geocoding

        checkLocationPermission()
    }

    // get list of all obejcts from geoJson, use distanceTo method of location, return least distance from list

    private fun checkLocationPermission(){
        if (ActivityCompat.checkSelfPermission(context!!, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(context!!, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                activity!!, arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ),
                Constants.LOCATION_PERMISSION_REQUEST_CODE
            )
            showRationalDialogForPermissions()
        }else{
            Log.e("Location Permission", "Permission Granted")
            getCurrentLocation()
        }
    }

    private fun getCurrentLocation() {
        LocationHelper().startListeningUserLocation(context!!, object : LocationHelper.MyLocationListener{
            override fun onLocationChanged(location: Location) {
                latitude = location.latitude
                longitude = location.longitude

                Log.e("Location", "$latitude $longitude")
            }
        })
    }

    private fun showRationalDialogForPermissions(){
        AlertDialog.Builder(context!!).setMessage(resources.getString(R.string.enable_location_in_settings))
            .setPositiveButton(resources.getString(R.string.go_to_settings))
            {_, _ ->
                try {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", activity!!.packageName, null)
                    intent.data = uri
                    startActivity(intent)
                }catch (e: ActivityNotFoundException){
                    e.printStackTrace()
                }
            }
            .setNegativeButton(resources.getString(R.string.cancel))
            {dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}