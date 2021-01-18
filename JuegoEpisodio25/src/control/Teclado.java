package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	private static final int numeroTeclas = 120;
	
	private final boolean[] teclas = new boolean[numeroTeclas];

	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;
	
	public boolean correr;
	
	public boolean salir;

	public void actualizar() {

		int VK_W = KeyEvent.VK_W;
		int VK_S = KeyEvent.VK_S;
		int VK_A = KeyEvent.VK_A;
		int VK_D = KeyEvent.VK_D;
		
		int VK_SHIFT = KeyEvent.VK_SHIFT;
		
		int VK_ESCAPE = KeyEvent.VK_ESCAPE;
		
		arriba = teclas[VK_W];
		abajo = teclas[VK_S];
		izquierda = teclas[VK_A];
		derecha = teclas[VK_D];
		
		correr = teclas[VK_SHIFT];
		
		salir = teclas[VK_ESCAPE];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		teclas[keyCode] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		teclas[keyCode] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
