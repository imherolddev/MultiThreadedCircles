/**
 * 
 */
package com.imherolddev.dreamcircles;

import java.util.Random;

import android.graphics.Color;

/**
 * @author imherolddev
 * 
 */
public class Circle {

	static final int VELOCITY = 15;

	private int x;
	private int y;
	private int xVelocity;
	private int yVelocity;
	private double degrees;
	private int radius;
	private int color;

	private Random random = new Random();

	/**
	 * Create a circle with given parameters
	 * 
	 * @param width
	 *            - the width to set
	 * @param height
	 *            - the height to set
	 * 
	 */
	public Circle(int width, int height) {

		this.color = (int) ((random.nextDouble() * Color.BLACK) - 1);
		this.radius = random.nextInt(100) + 25;
		this.x = this.getRadius() + random.nextInt(width - this.getRadius() * 2);
		this.y = this.getRadius() + random.nextInt(height - this.getRadius() * 2);
		this.degrees = random.nextInt(360);

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getXVelocity() {
		return xVelocity;
	}

	public void setXVelocity(int velocity) {
		this.xVelocity = velocity;
	}

	public int getYVelocity() {
		return yVelocity;
	}

	public void setYVelocity(int velocity) {
		this.yVelocity = velocity;
	}

	public double getDegrees() {
		return degrees;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

}
