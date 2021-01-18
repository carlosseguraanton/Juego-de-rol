package jugador;

import java.awt.Point;

import control.Teclado;
import graficos.CapturadorPixeles;
import graficos.Sprite;

public class Jugador {

	private Teclado teclado;

	private Sprite sprite;

	private char direccion = 'n';

	private int x;
	private int y;

	private Point posicion = new Point(x, y);

	int[] pixeles;

	int desplazamientoX = 0;
	int desplazamientoY = 0;

	int velocidadDesplazamiento = 1;

	private boolean eliminado = false;

	public Jugador(Teclado teclado, Sprite sprite) {

		this.teclado = teclado;

		this.sprite = sprite;

	}

	public Jugador(Teclado teclado, Sprite sprite, int posicionX, int posicionY) {

		this.teclado = teclado;

		this.sprite = sprite;

		this.x = posicionX;
		this.y = posicionY;

	}

	public void actualizar() {

		mover(desplazamientoX, desplazamientoY);

	}

	public void mover(int desplazamientoX, int desplazamientoY) {

//		if (teclado.arriba) {
//
//			y--;
//
//		}
//
//		if (teclado.abajo) {
//
//			y++;
//
//		}
//
//		if (teclado.izquierda) {
//
//			x--;
//
//		}
//
//		if (teclado.derecha) {
//
//			x++;
//
//		}

		desplazamientoX = 0;
		desplazamientoY = 0;

		if (teclado.correr) {

			velocidadDesplazamiento = 2;

		}

		if (teclado.arriba) {

			desplazamientoY = desplazamientoY - velocidadDesplazamiento;

		}

		if (teclado.abajo) {

			desplazamientoY = desplazamientoY + velocidadDesplazamiento;

		}

		if (teclado.izquierda) {

			desplazamientoX = desplazamientoX - velocidadDesplazamiento;

		}

		if (teclado.derecha) {

			desplazamientoX = desplazamientoX + velocidadDesplazamiento;

		}
		
		modificarPosicionX(desplazamientoX);

		modificarPosicionY(desplazamientoY);

	}

	public char getDireccion() {

		return direccion;

	}

	public void setDireccion(char direccion) {

		this.direccion = direccion;

	}

	public Sprite obtenSprite() {

		return sprite;

	}

	public void eliminar() {

		eliminado = true;

	}

	public int obtenerPosicionX() {

		return x;

	}

	public int obtenerPosicionY() {

		return y;

	}

	public Point obtenerPosicion() {

		return posicion;

	}

	public void modificarPosicionX(int desplazamientoX) {

		x = x + desplazamientoX;

	}

	public void modificarPosicionY(int desplazamientoY) {

		y = y + desplazamientoY;

	}

	public boolean estaEliminado() {

		return eliminado;

	}

	public void transferirSpriteDesplazado() {

		CapturadorPixeles.capturarJugadorDesplazado(this.x, this.y, this);

	}

}
