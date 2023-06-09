package info3.game.vue.toolkitUI;

import java.awt.Graphics;

public abstract class UIComponent {
	private int positionX;
	private int positionY;
	private int height;
	private int width;

	public UIComponent(int x, int y, int h, int w) {
		this.positionX = x;
		this.positionY = y;
		this.height = h;
		this.width = w;
	}

	public abstract void paint(Graphics g);

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
