package com.imherolddev.dreamcircles.settings;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.widget.Toast;

import com.imherolddev.dreamcircles.R;

/**
 * @author imherolddev
 *
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2) public class SettingsFragment extends PreferenceFragment {

	private Preference enable;

	/**
	 * No arg constructor
	 */
	public SettingsFragment() {
		// Empty
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.fragment_settings);

		enable = (Preference) findPreference("enable");
		enable.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {

				startActivity(new Intent(
						android.provider.Settings.ACTION_DREAM_SETTINGS));
				Toast.makeText(getActivity(), R.string.dream_direction,
						Toast.LENGTH_LONG).show();

				return true;

			}

		});

	}

}
