package svemir;

import java.awt.Color;

public abstract class NebeskoTelo extends Objekat{
	double r;
	public NebeskoTelo(int x, int y, Color boja, double r) {
		super(x, y, boja);
		this.r = r;
	}

	

}
