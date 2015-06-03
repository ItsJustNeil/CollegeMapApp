package com.example.neil.projectmap;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import 	com.google.android.gms.maps.model.PolylineOptions;

public class MapActivity extends Activity {

    private final LatLng LOCATION_DUBLIN = new LatLng(53.3243201,-6.251695);
    private final LatLng LOCATION_DUNDALK = new LatLng(53.99776,-6.393935);
    private final LatLng LOCATION_DCU = new LatLng(53.3852876,-6.2567949);
    private final LatLng LOCATION_DKIT = new LatLng(53.9829635,-6.3927269);
    private final LatLng LOCATION_MAYNOOTH = new LatLng(53.3807,-6.594596);
    private final LatLng LOCATION_UCD = new LatLng(53.307262,-6.219077);
    private final LatLng LOCATION_TRINITY = new LatLng(53.3438966,-6.2544553);

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        //Markers
        addMapMarkers();

        //Polylines
        addPolylines();

        //Overlays
        addOverlays();

        map.setMyLocationEnabled(true);
    }

    public void onclick_Normal(View view){
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void onclick_Dublin(View view)
    {
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_DUBLIN, 11);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void addPolylines() {
        map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(53.3243201,-6.251695))
                        .add(new LatLng(53.99776,-6.393935))
        );
    }

    public void addMapMarkers() {
        MarkerOptions mark_Dublin = new MarkerOptions().position(LOCATION_DUBLIN).title("Dublin");
        MarkerOptions mark_Dundalk = new MarkerOptions().position(LOCATION_DUNDALK).title("Dundalk");
        MarkerOptions mark_DCU = new MarkerOptions().position(LOCATION_DCU).title("DCU");
        MarkerOptions mark_DkIT = new MarkerOptions().position(LOCATION_DKIT).title("DkIT");
        MarkerOptions mark_TCD = new MarkerOptions().position(LOCATION_TRINITY).title("TCD");
        MarkerOptions mark_NUIM = new MarkerOptions().position(LOCATION_MAYNOOTH).title("NUIM");
        MarkerOptions mark_UCD = new MarkerOptions().position(LOCATION_UCD).title("UCD");

        mark_Dublin.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        mark_Dundalk.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        mark_DCU.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        mark_DkIT.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        mark_TCD.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        mark_NUIM.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        mark_UCD.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

        map.addMarker(mark_Dublin);
        map.addMarker(mark_Dundalk);
        map.addMarker(mark_DCU);
        map.addMarker(mark_DkIT);
        map.addMarker(mark_TCD);
        map.addMarker(mark_NUIM);
        map.addMarker(mark_UCD);

    }

    public void addOverlays()
    {
        GroundOverlayOptions ucdMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.ucd))
                .position(LOCATION_UCD, 860f, 650f);
        map.addGroundOverlay(ucdMap);

        GroundOverlayOptions dkitMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.dkitlogo))
                .position(LOCATION_DKIT, 860f, 650f);
        map.addGroundOverlay(dkitMap);

        GroundOverlayOptions dcuMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.dculogo))
                .position(LOCATION_DCU, 860f, 650f);
        map.addGroundOverlay(dcuMap);

        GroundOverlayOptions maynoothMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.maynoothlogo))
                .position(LOCATION_MAYNOOTH, 860f, 650f);
        map.addGroundOverlay(maynoothMap);

        GroundOverlayOptions trinityMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.trinity))
                .position(LOCATION_TRINITY, 860f, 650f);
        map.addGroundOverlay(trinityMap);
    }

    public void onclick_Dundalk(View view)
    {
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_DUNDALK, 11);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

