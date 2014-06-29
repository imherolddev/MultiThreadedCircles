package com.imherolddev.multithreadedcircles;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

/**
 * 
 * @author imherolddev
 * 
 */
public class MyView extends View {

	private int numCircles = 50;

	private int width;
	private int height;

	private Paint paint = new Paint();

	private List<Circle> circles = new ArrayList<Circle>();

	private Handler h;
	private Runnable r;

	private final int FRAME_RATE = 16;

	/**
	 * Constructor with context
	 * 
	 * @param context
	 *            - the context to set
	 */
	public MyView(Context context) {
		super(context);

		/*
		 * circleA = new Circle(-1, -1); this.setAngle(circleA);
		 * circles.add(circleA); circleB = new Circle(-1, -1);
		 * this.setAngle(circleB); circles.add(circleB); circleC = new
		 * Circle(-1, -1); this.setAngle(circleC); circles.add(circleC);
		 */

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

	@Override
	public void onSizeChanged(int w, int h, int oldw, int oldh) {

		super.onSizeChanged(w, h, oldw, oldh);
		
		this.width = w;
		this.height = h;

		for (int i = 1; i <= this.numCircles; i++) {

			Circle c = new Circle(w, h);
			this.setAngle(c);
			circles.add(c);

		}

	}

	/**
	 * Get new coordinates for circle
	 * 
	 * @param circle
	 *            - the circle to set
	 */
	private void moveCircle(Circle circle) {

		if (circle.getX() > this.getXBoundary(circle.getRadius())) {

			circle.setXVelocity(circle.getXVelocity() * -1);

		} else if (circle.getX() < circle.getRadius()) {

			circle.setXVelocity(circle.getXVelocity() * -1);

		}

		if (circle.getY() > this.getYBoundary(circle.getRadius())) {

			circle.setYVelocity(circle.getYVelocity() * -1);

		} else if (circle.getY() < circle.getRadius()) {

			circle.setYVelocity(circle.getYVelocity() * -1);

		}

		circle.setX(circle.getX() + circle.getXVelocity());
		circle.setY(circle.getY() + circle.getYVelocity());

	}

	private void setAngle(Circle circle) {

		circle.setXVelocity((int) (Math.cos(circle.getDegrees()) * Circle.VELOCITY));
		circle.setYVelocity((int) (Math.sin(circle.getDegrees()) * Circle.VELOCITY));

	}

	private int getXBoundary(int radius) {

		return this.width - radius;

	}

	private int getYBoundary(int radius) {

		return this.height - radius;

	}

}
