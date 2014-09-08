package com.example.gps;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity {
	Button button;
	double lat = 0.0;
	double lon = 0.0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		LocationManager locman = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		LocationListener lis = new LocationListener() {
			public void onLocationChanged(Location loc) {
//				lat = loc.getLatitude();
//				lon = loc.getLongitude();
//				addListenerOnButton();
			}
			public void onStatusChanged(String provider, int status, Bundle extras) {}
			public void onProviderEnabled(String provider) {
				String text = provider + " has been enabled.";
				Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
			}
			public void onProviderDisabled(String provider) {
				String text = provider + " has been disabled.";
				Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
			}
		};
		locman.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, lis);
		locman.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, lis);
		*/
		addListenerOnButton();
	}
	
	public void addListenerOnButton() {
		button = (Button) findViewById(R.id.button1);
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String text;
				if (lat == 0.0 && lon == 0.0) {
					text = "Damn, can you just wait?";
				}
				else {
					text = "Latitude: " + lat + "\nLongitude: " + lon;
				}
				Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
