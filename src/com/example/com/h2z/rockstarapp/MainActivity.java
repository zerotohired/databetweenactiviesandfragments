package com.example.com.h2z.rockstarapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	public static final String MY_CUSTOM_FRAGMENT_KEY = "CUSTOM_TEXT";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, createCustomFragment()).commit();
		}
	}
	
	private Fragment createCustomFragment() {
		Bundle bundle = new Bundle();
		bundle.putString(MY_CUSTOM_FRAGMENT_KEY, "I am a rockstar programmer");
		
		PlaceholderFragment placeholderFragment = new PlaceholderFragment();
		placeholderFragment.setArguments(bundle);
		return placeholderFragment;
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			Bundle bundle = getArguments();
			
			String customText = bundle.getString(MY_CUSTOM_FRAGMENT_KEY);
			
			TextView myCustomTextView = (TextView) rootView.findViewById(R.id.my_custom_fragment);
			myCustomTextView.setText(customText);
			
			return rootView;
		}
	}
}
