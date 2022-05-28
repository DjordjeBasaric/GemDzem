package svemir;

import java.awt.Color;
import java.awt.Graphics;

public class Kometa extends NebeskoTelo {
	
	private double angle;

	public Kometa(int x, int y, Color boja, double r) {
		super(x, y, boja, r);
		angle = Math.toRadians(Math.random()*360);
	}
	public int dohvX(double angle) {
		return (int)( r * Math.cos(angle));
	}
	
	public int dohvY(double angle) {
		return (int)( r * Math.sin(angle));
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		int x = dohvX(), y = dohvY();
		double inc = 2*Math.PI/5;
		int[] xs = new int [5];
		int[] ys = new int [5]; 
		for (int i = 0; i<5 ; i++){
			xs[i] = dohvX(angle) + x;
			ys[i] = dohvY(angle) + y;
			angle+=inc %(2*Math.PI);
		}
		g.drawPolygon(xs, ys, xs.length);
		g.fillPolygon(xs, ys, xs.length);
	}
}
