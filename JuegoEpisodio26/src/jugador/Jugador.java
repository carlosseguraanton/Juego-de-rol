package jugador;

import java.awt.Point;

import control.Teclado;
import graficos.CapturadorPixeles;
import graficos.Sprite;

public class Jugador {

	private Teclado teclado;

	private Sprite sprite;

	private char direccion = 'n';

	private boolean enMovimiento = false;

	private int x;
	private int y;

	private Point posicion = new Point(x, y);

	int[] pixeles;

	int desplazamientoX = 0;
	int desplazamientoY = 0;

	int velocidadDesplazamiento = 1;

	private boolean eliminado = false;

	private int animacion;

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
		
		if (teclado.arriba) {

			y--;

		}

		if (teclado.abajo) {

			y++;

		}

		if (teclado.izquierda) {

			x--;

		}

		if (teclado.derecha) {

			x++;

		}
		
//		mover(desplazamientoX, desplazamientoY);

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

//		desplazamientoX = 0;
//		desplazamientoY = 0;
//
//		if (teclado.correr) {
//
//			velocidadDesplazamiento = 2;
//
//		}
//
//		if (teclado.arriba) {
//
//			desplazamientoY = desplazamientoY - velocidadDesplazamiento;
//
//		}
//
//		if (teclado.abajo) {
//
//			desplazamientoY = desplazamientoY + velocidadDesplazamiento;
//
//		}
//
//		if (teclado.izquierda) {
//
//			desplazamientoX = desplazamientoX - velocidadDesplazamiento;
//
//		}
//
//		if (teclado.derecha) {
//
//			desplazamientoX = desplazamientoX + velocidadDesplazamiento;
//
//		}

		
		
//		if (desplazamientoX != 0 || desplazamientoY != 0) {
//
//			establecerDireccion(desplazamientoX, desplazamientoY);
//
//			enMovimiento = true;
//
//		} else {
//
//			enMovimiento = false;
//
//		}
//
//		// ANIMACIONES
		
//		if (animacion < 32767) {
//		
//		animacion++;
//		
//	} else {
//		
//		animacion = 0;
//		
//	}
		
//		int resto = animacion % 40;
//
//		if (direccion == 'n') {
//
//			sprite = Sprite.ARRIBA0;
//
//			if (enMovimiento) {
//
//				if (resto > 10 && resto <= 20) {
//
//					sprite = Sprite.ARRIBA1;
//
//				} else if (resto > 20 && resto <= 30) {
//
//					sprite = Sprite.ARRIBA0;
//
//				} else if (resto > 30) {
//
//					sprite = Sprite.ARRIBA2;
//
//				} else {
//
//					sprite = Sprite.ARRIBA0;
//
//				}
//
//			}
//
//		}
//
//		if (direccion == 's') {
//
//			sprite = Sprite.ABAJO0;
//
//			if (enMovimiento) {
//
//				if (resto > 10 && resto <= 20) {
//
//					sprite = Sprite.ABAJO1;
//
//				} else if (resto > 20 && resto <= 30) {
//
//					sprite = Sprite.ABAJO0;
//
//				} else if (resto > 30) {
//
//					sprite = Sprite.ABAJO2;
//
//				} else {
//
//					sprite = Sprite.ABAJO0;
//
//				}
//
//			}
//
//		}
//
//		if (direccion == 'e') {
//
//			sprite = Sprite.DERECHA0;
//
//			if (enMovimiento) {
//
//				if (resto > 10 && resto <= 20) {
//
//					sprite = Sprite.DERECHA1;
//
//				} else if (resto > 20 && resto <= 30) {
//
//					sprite = Sprite.DERECHA0;
//
//				} else if (resto > 30) {
//
//					sprite = Sprite.DERECHA2;
//
//				} else {
//
//					sprite = Sprite.DERECHA0;
//
//				}
//
//			}
//
//		}
//
//		if (direccion == 'o') {
//
//			sprite = Sprite.IZQUIERDA0;
//
//			if (enMovimiento) {
//
//				if (resto > 10 && resto <= 20) {
//
//					sprite = Sprite.IZQUIERDA1;
//
//				} else if (resto > 20 && resto <= 30) {
//
//					sprite = Sprite.IZQUIERDA0;
//
//				} else if (resto > 30) {
//
//					sprite = Sprite.IZQUIERDA2;
//
//				} else {
//
//					sprite = Sprite.IZQUIERDA0;
//
//				}
//
//			}
//
//		}

//		if (!estaEliminado()) {
//
//			if (!enColision(desplazamientoX, 0)) {

				modificarPosicionX(desplazamientoX);

//			}

//			if (!enColision(0, desplazamientoY)) {

				modificarPosicionY(desplazamientoY);

//			}
				
//		}

	}

//	public void establecerDireccion(int desplazamientoX, int desplazamientoY) {
//
//		if (desplazamientoX > 0) {
//
//			direccion = 'e';
//
//		}
//
//		if (desplazamientoX < 0) {
//
//			direccion = 'o';
//
//		}
//
//		if (desplazamientoY > 0) {
//
//			direccion = 's';
//
//		}
//
//		if (desplazamientoY < 0) {
//
//			direccion = 'n';
//
//		}
//
//	}

//	private boolean enColision(int desplazamientoX, int desplazamientoY) {
//
//		boolean colision = false;
//
//		return colision;
//
//	}

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
