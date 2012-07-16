package com.example.localizador;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Gps extends Activity{ 
	
	private static final String TAG = "Debug";
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		LocationListener ll = new MyLocationListener();
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
	}
	
	
	public class MyLocationListener implements LocationListener{

		public void onLocationChanged(Location location) {
			double lat = location.getLatitude();
			double lon = location.getLongitude();
			String text = "Longitud: " + lon + "\n" + "Latitud: " + lat ;
			Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
			String longitud = "Longitud" + location.getLongitude();	
			Log.v(TAG, longitud);
			String latitud = "Latitud" + location.getLatitude();
			Log.v(TAG, latitud);
			
		}

		public void onProviderDisabled(String provider) {
			String text = "Gps desactivado";
			Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT ).show();
		}

		public void onProviderEnabled(String provider) {
			String text = "Gps activado";
			Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT ).show();	
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}