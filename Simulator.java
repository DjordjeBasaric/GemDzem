package svemir;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame{
	private Svemir svemir = new Svemir();
	private Panel bottomPanel;
	private Generator generator = new Generator(svemir);
	
	
	public Simulator() {
		setBounds(300, 400, 800, 600);
		setResizable(false);
		setTitle("Svemir");
		napunitiWindow();
		addWindowListener(new WindowAdapter(){
				@Override
				public void windowClosing(WindowEvent e) {
					svemir.zavrsi();
					generator.zavrsi();
					dispose();
				}
		});
		
		setVisible(true);
		
	}
	
	private void napunitiWindow() {
		add(svemir, BorderLayout.CENTER);
		Button pokreni = new Button("Pokreni!");
		pokreni.addActionListener((ae)->{
			generator.pokreni();
			repaint();
			pokreni.setEnabled(false);
		});
		bottomPanel = new Panel();
		bottomPanel.add(pokreni);
		add(bottomPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new Simulator();
	}

}
