package svemir;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable{
	private Thread nit;
	ArrayList<NebeskoTelo> nebeskaTela = new ArrayList<>();
	private Igrac igrac;
	
	public Svemir() 
	{
		setBackground(Color.BLACK);	
		
		igrac = new Igrac(800 / 2 - 30, 600 - 150, 60, 60);	
	}
	
	@Override
	public void paint(Graphics g) {
		nit = new Thread(this);
		nit.start();
	}
	
	public synchronized void zavrsi() {
		if(nit != null) {
			nit.interrupt();
		}
		while (nit != null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
	}
	
	@Override
	public void run() {
		Graphics g = getGraphics();
		while(!nit.isInterrupted()) {
			g.clearRect(0, 0, 800, 600);
			synchronized (nebeskaTela) {
				for (NebeskoTelo nt : nebeskaTela) {
					nt.paint(g);
					igrac.crtaj(g);
					nt.izmeniY(+5);
				}
				try {
					Thread.sleep(100);
					
				} catch (InterruptedException e) {break;}
				
			}
		}
		synchronized (this) {
			nit = null;
			notify();
		}
		
	}

}
