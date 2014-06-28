/**
 * 
 */
package com.imherolddev.multithreadedcircles;

/**
 * @author imherolddev
 *
 */
public class Circle {
	
	private int x;
	private int y;
	private int xVelocity;
	private int yVelocity;
	private int degrees;
	private int radius;
	private int color;
	
	/**
	 * Create a circle with given parameters
	 * @param x - the x to set
	 * @param y - the y to set
	 * @param velocity - the velocity to set
	 * @param degrees - the degrees to set
	 * @param radius - the radius to set
	 * @param color - the color to set
	 */
	public Circle(int x, int y, int velocity, int degrees, int radius, int color) {
		
		this.x = x;
		this.y = y;
		this.xVelocity = velocity;
		this.yVelocity = velocity;
		this.degrees = degrees;
		this.radius = radius;
		this.color = color;
		
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

	public int getDegrees() {
		return degrees;
	}

	public void setDegrees(int degrees) {
		this.degrees = degrees;
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
