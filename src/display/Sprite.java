package display;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import mechanics.Vector2D;

public class Sprite {

	boolean isStatic;
	String name;
	Vector2D pos, vel, acc;
	Dimension size;
	
	public Sprite(int x, int y, int w, int h, boolean isStatic) {
		name = null;
		this.isStatic = isStatic;
		pos = new Vector2D(x, y);
		size = new Dimension(w, h);
		if(isStatic)
			vel = acc = null;
		else {
			vel = new Vector2D();
			acc = new Vector2D();
		}
	}
	
	public void update(double dt) {
		if(isStatic)
			return;
		pos.add(Vector2D.mult(vel, dt));
		vel.add(Vector2D.mult(acc, dt));
		acc.mult(0);
	}
	
	public void applyForce(Vector2D force) {
		if(isStatic)
			return;
		acc.add(force);
	}
	
	public void render(Graphics g, SpriteSheet s) {
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.dispose();
	}
}
