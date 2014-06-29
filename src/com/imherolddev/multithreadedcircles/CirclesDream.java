/**
 * 
 */
package com.imherolddev.multithreadedcircles;

import android.annotation.TargetApi;
import android.os.Build;
import android.service.dreams.DreamService;

/**
 * @author imherolddev
 *
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class CirclesDream extends DreamService {

	private MyView dream;

	/**
	 * No arg constructor
	 */
	public CirclesDream() {
		//Empty
	}

	@Override
	public void onAttachedToWindow() {

		super.onAttachedToWindow();

		dream = new MyView(this);
		
		setInteractive(false);
		setFullscreen(true);
		setContentView(dream);

	}

}
