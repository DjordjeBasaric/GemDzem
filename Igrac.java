package svemir;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac  {
	private int x, y, sirina, visina, zivoti;
	private Color boja;
	
	public Igrac(int x, int y, int sirina, int visina)
	{
		this.x = x;
		this.y = y;
		this.sirina = sirina;
		this.visina = visina;
		this.zivoti = zivoti;
		this.boja = boja;
	}
	

	public void crtaj(Graphics g) 
	{
		g.setColor(Color.RED);
		g.drawRect(x, y, sirina, visina);
	}
	
	
	
	
}
