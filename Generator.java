package svemir;

import java.awt.Color;

public class Generator extends Thread {
	private Svemir owner;
	
	public Generator(Svemir owner) {
		this.owner = owner;
	}
	public synchronized void pokreni() {
		start();
	}
	
	public synchronized void zavrsi() {
		interrupt();
	}
	

	@Override
	public void run() {
			while (!isInterrupted()) {
				synchronized (owner.nebeskaTela) {
					owner.nebeskaTela.add(new Kometa((int) (Math.random() * 800), 0, Color.GRAY, Math.random() * 20 + 10));
				}
				try {
					sleep(900);
				} catch (InterruptedException e) { break;}
		}
			
	}
	
}