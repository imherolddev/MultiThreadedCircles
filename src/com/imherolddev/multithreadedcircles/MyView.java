package com.imherolddev.multithreadedcircles;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

/**
 * 
 * @author imherolddev
 * 
 */
public class MyView extends View {

	private int velocity = 10;

	private Circle circleA;
	private Circle circleB;
	private Circle circleC;

	private Paint paint = new Paint();

	private List<Circle> circles = new ArrayList<Circle>();

	private Handler h;
	private Runnable r;

	private final int FRAME_RATE = 30;

	/**
	 * Constructor with context
	 * 
	 * @param context
	 *            - the context to set
	 */
	public MyView(Context context) {
		super(context);

		circleA = new Circle(-1, -1, this.velocity, 360, 100, Color.RED);
		circles.add(circleA);
		circleB = new Circle(-1, -1, this.velocity, 360, 100, Color.YELLOW);
		circles.add(circleB);
		circleC = new Circle(-1, -1, this.velocity, 360, 100, Color.BLUE);
		circles.add(circleC);

		h = new Handler();
		r = new Runnable() {

			@Override
			public void run() {

				invalidate();

			}

		};

	}

	@Override
	public void onDraw(Canvas canvas) {

		for (Circle c : circles) {

			this.moveCircle(c);
			paint.setColor(c.getColor());
			canvas.drawCircle(c.getX(), c.getY(), c.getRadius(), paint);

		}

		h.postDelayed(r, this.FRAME_RATE);

	}

	/**
	 * Get new coordinates for circle
	 * 
	 * @param circle
	 *            - the circle to set
	 */
	private void moveCircle(Circle circle) {

		if (circle.getX() < 0 && circle.getY() < 0) {

			circle.setX(this.getWidth() / 2);
			circle.setY(this.getHeight() / 2);
			;

		} else {

			circle.setX(circle.getX() + circle.getXVelocity());
			circle.setY(circle.getY() + circle.getYVelocity());

			if (circle.getX() > (this.getWidth() - this.getWidth() / 10)
					|| circle.getX() < 0) {

				circle.setXVelocity(circle.getXVelocity() * -1);

			}

			if (circle.getY() > (this.getHeight() - this.getWidth() / 10)
					|| circle.getY() < 0) {

				circle.setYVelocity(circle.getYVelocity() * -1);

			}

		}

	}

}
