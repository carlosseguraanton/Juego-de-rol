package graficos;

import jugador.Jugador;

public final class PreparadorImagenes {

	private static int ancho;
	private static int alto;

	private static int x;
	private static int y;

	private int totalPixeles;
	
	public static int[] pixeles;

	public PreparadorImagenes(final int ancho, final int alto) {

		PreparadorImagenes.ancho = ancho;
		PreparadorImagenes.alto = alto;

		totalPixeles = ancho * alto;
		
		pixeles = new int[totalPixeles];

	}
	
	public void establecerPosicion(final int x, final int y) {

		PreparadorImagenes.x = x;
		PreparadorImagenes.y = y;

	}

	public static int[] obtenerSprite(Sprite sprite) {

		for (int y = 0; y < Sprite.lado; y++) {

			int posicionY = y;

			if (posicionY >= 0 && posicionY < alto) {

				for (int x = 0; x < Sprite.lado; x++) {

					int posicionX = x;

					if (posicionX >= 0 && posicionX < ancho) {

						int indexDelPixelAOcupar = posicionX + posicionY * ancho;

						int posicionFinalX = x & Sprite.mascara;
						int posicionFinalY = y & Sprite.mascara;

						int indexDelPixelATransferir = posicionFinalX + posicionFinalY * Sprite.lado;

						int valorDelPixelATransferir = sprite.pixeles[indexDelPixelATransferir];

						pixeles[indexDelPixelAOcupar] = valorDelPixelATransferir;

					}

				}

			}

		}
		
		return pixeles;

	}
	
	public static void capturarSpriteDesplazado(Sprite sprite) {

		for (int y = 0; y < Sprite.lado; y++) {

			int posicionY = y;

			if (posicionY >= 0 && posicionY < alto) {

				for (int x = 0; x < Sprite.lado; x++) {

					int posicionX = x;

					if (posicionX >= 0 && posicionX < ancho) {

						int indexDelPixelAOcupar = posicionX + posicionY * ancho;

						int posicionFinalX = x & Sprite.mascara;
						int posicionFinalY = y & Sprite.mascara;

						int indexDelPixelATransferir = posicionFinalX + posicionFinalY * Sprite.lado;

						int valorDelPixelATransferir = sprite.pixeles[indexDelPixelATransferir];

						pixeles[indexDelPixelAOcupar] = valorDelPixelATransferir;

					}

				}

			}

		}

	}
	

	public static int[] capturarSpriteDesplazado(int desplazamientoX, int desplazamientoY, Sprite sprite) {

		desplazamientoX = desplazamientoX - x;
		desplazamientoY = desplazamientoY - y;

		for (int y = 0; y < Sprite.lado; y++) {

			int posicionY = y + desplazamientoY;

			if (posicionY >= 0 && posicionY < alto) {

				for (int x = 0; x < Sprite.lado; x++) {

					int posicionX = x + desplazamientoX;

					if (posicionX >= 0 && posicionX < ancho) {

						int indexDelPixelAOcupar = posicionX + posicionY * ancho;

						int posicionFinalX = x & Sprite.mascara;
						int posicionFinalY = y & Sprite.mascara;

						int indexDelPixelATransferir = posicionFinalX + posicionFinalY * Sprite.lado;

						int valorDelPixelATransferir = sprite.pixeles[indexDelPixelATransferir];

						pixeles[indexDelPixelAOcupar] = valorDelPixelATransferir;

					}

				}

			}

		}
		
		return pixeles;

	}
	
	public static int[] obtenerPixelesPreparadosJugadorDesplazado(int desplazamientoX, int desplazamientoY, Jugador jugador) {


		desplazamientoX = desplazamientoX - x;
		desplazamientoY = desplazamientoY - y;

		for (int y = 0; y < Sprite.lado; y++) {

			int posicionDestinoY = y + desplazamientoY;

			if (posicionDestinoY >= 0 && posicionDestinoY < alto) {

				for (int x = 0; x < Sprite.lado; x++) {

					int posicionDestinoX = x + desplazamientoX;

					if (posicionDestinoX >= 0 && posicionDestinoX < ancho) {

						int posicionOrigenX = x & Sprite.mascara;
						int posicionOrigenY = y & Sprite.mascara;

						int indexUsadoPorElPixelATransferir = posicionOrigenX + posicionOrigenY * Sprite.lado;

						int valorDelPixelATransferir = Sprite.ASFALTO.pixeles[indexUsadoPorElPixelATransferir];

						int indexUsadoPorElPixelAOcupar = posicionDestinoX + posicionDestinoY * ancho;
						
						pixeles[indexUsadoPorElPixelAOcupar] = valorDelPixelATransferir;

					}

				}

			}

		}
		
		return pixeles;
		
	}

	public static int obtenAncho() {

		return ancho;

	}

	public static int obtenAlto() {

		return alto;

	}

	public int getX() {
		
		return x;
		
	}

	public void setX(int x) {
		
		PreparadorImagenes.x = x;
		
	}

	public int getY() {
		
		return y;
		
	}

	public void setY(int y) {
		
		PreparadorImagenes.y = y;
		
	}

}
