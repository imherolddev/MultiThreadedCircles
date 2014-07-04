/**
 * 
 */
package com.imherolddev.dreamcircles.dialog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.imherolddev.dreamcircles.R;

/**
 * @author imherolddev
 *
 */
public class StartupDialog extends DialogFragment {

	private View view;
	private TextView tv_dialog;

	/**
	 * No arg constructor
	 */
	public StartupDialog() {
		// Empty
	}

	@Override
	public AlertDialog onCreateDialog(Bundle savedInstanceState) {

		AlertDialog.Builder startupDialog = new AlertDialog.Builder(
				getActivity());

		LayoutInflater inflater = getActivity().getLayoutInflater();
		view = inflater.inflate(R.layout.dialog_startup, null);

		tv_dialog = (TextView) view.findViewById(R.id.tv_dialog);

		try {

			InputStreamReader input = new InputStreamReader(getResources()
					.openRawResource(R.raw.dialog));
			BufferedReader br = new BufferedReader(input);

			String line;

			while ((line = br.readLine()) != null) {

				tv_dialog.append(line);
				tv_dialog.append("\n");

			}

			input.close();
			br.close();

		} catch (IOException ioex) {

			// catch

		}

		return startupDialog.create();

	}

}
