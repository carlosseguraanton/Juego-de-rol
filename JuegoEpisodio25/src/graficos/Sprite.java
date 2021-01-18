package graficos;

import java.awt.Point;

public final class Sprite {

	public static int x = 32;
	public static int y = 32;

	public static int lado = 32;

	public static int mascara = lado - 1;

	private static int columna;
	private static int fila;

	private static Point coordenadasSprite = new Point(fila, columna);

	public int[] pixeles;

	private int totalPixeles;

	private HojaSprites hojaSprites;

//	 	coleccion de sprites del personaje o jugador
	public static final Sprite jugador = new Sprite(32, 0, 0, HojaSprites.jugador);
	
	public static final Sprite ABAJO0 = new Sprite(32, 0, 0, HojaSprites.jugador);
	public static final Sprite ABAJO1 = new Sprite(32, 0, 1, HojaSprites.jugador);
	public static final Sprite ABAJO2 = new Sprite(32, 0, 2, HojaSprites.jugador);

	public static final Sprite ARRIBA0 = new Sprite(32, 1, 0, HojaSprites.jugador);
	public static final Sprite ARRIBA1 = new Sprite(32, 1, 1, HojaSprites.jugador);
	public static final Sprite ARRIBA2 = new Sprite(32, 1, 2, HojaSprites.jugador);

	public static final Sprite DERECHA0 = new Sprite(32, 2, 0, HojaSprites.jugador);
	public static final Sprite DERECHA1 = new Sprite(32, 2, 1, HojaSprites.jugador);
	public static final Sprite DERECHA2 = new Sprite(32, 2, 2, HojaSprites.jugador);

	public static final Sprite IZQUIERDA0 = new Sprite(32, 3, 0, HojaSprites.jugador);
	public static final Sprite IZQUIERDA1 = new Sprite(32, 3, 1, HojaSprites.jugador);
	public static final Sprite IZQUIERDA2 = new Sprite(32, 3, 2, HojaSprites.jugador);
	
//		fin coleccion

//		coleccion de sprites del mapa SUBTERRANEO
//		public static final Sprite VACIO = new Sprite(32, 0);
	public static final Sprite SUELO = new Sprite(32, 0, 0, HojaSprites.subterraneo);
	public static final Sprite ENTRADA = new Sprite(32, 0, 1, HojaSprites.subterraneo);
	public static final Sprite TIERRA = new Sprite(32, 3, 1, HojaSprites.subterraneo);
	public static final Sprite PARED = new Sprite(32, 4, 0, HojaSprites.subterraneo);
	public static final Sprite CONTROL_ACCESO = new Sprite(32, 8, 0, HojaSprites.subterraneo);
	public static final Sprite PUERTA = new Sprite(32, 9, 1, HojaSprites.subterraneo);
//		fin subterraneo

//		coleccion de sprites del mapa DESIERTO
//		public static final Sprite VACIO = new Sprite(32, 0);
	public static final Sprite ASFALTO = new Sprite(32, 0, 0, HojaSprites.desierto);
	public static final Sprite ARENA = new Sprite(32, 1, 0, HojaSprites.desierto);
	public static final Sprite BORDE = new Sprite(32, 2, 0, HojaSprites.desierto);
	public static final Sprite OXIDO = new Sprite(32, 9, 0, HojaSprites.desierto);
//		fin de la coleccion

	public Sprite(final int lado, final int columna, final int fila, final HojaSprites hojaSprites) {

		totalPixeles = lado * lado;

		pixeles = new int[totalPixeles];

		Sprite.x = columna * lado;
		Sprite.y = fila * lado;

		this.hojaSprites = hojaSprites;

		for (int y = 0; y < lado; y++) {

			for (int x = 0; x < lado; x++) {

				int indexDelPixelAOcupar = x + y * lado;

				int posicionFinalX = x + this.getX();
				int posicionFinalY = y + this.getY();

				int indexDelPixelATransferir = posicionFinalX + posicionFinalY * this.hojaSprites.getX();

				int valorDelPixelATransferir = this.hojaSprites.pixeles[indexDelPixelATransferir];

				pixeles[indexDelPixelAOcupar] = valorDelPixelATransferir;

			}

		}
		
	}
	
	public Sprite(final int lado, final int columna, final int fila, int version, final HojaSprites hojaSprites) {

		totalPixeles = lado * lado;

		pixeles = new int[totalPixeles];

		Sprite.x = columna * lado;
		Sprite.y = fila * lado;

		this.hojaSprites = hojaSprites;

		for (int y = 0; y < lado; y++) {

			for (int x = 0; x < lado; x++) {

				int indexDelPixelAOcupar = x + y * lado;

				int posicionFinalX = x + this.getX();
				int posicionFinalY = y + this.getY();

				int indexDelPixelATransferir = posicionFinalX + posicionFinalY * this.hojaSprites.getX();

				int valorDelPixelATransferir = this.hojaSprites.pixeles[indexDelPixelATransferir];

				pixeles[indexDelPixelAOcupar] = valorDelPixelATransferir;

			}

		}
		
//		if (version == 0) {
//		
//			cargaNormal();
//		
//		} else {
//		
//			cargaManipulada(version);
//		
//		}
		
	}

//
//	public Sprite(final int lado, final int color) {
//		
//		Sprite.lado = lado;
//		
//		pixeles = new int[lado * lado];
//
//		for (int i = 0; i < pixeles.length; i++) {
//		
//			pixeles[i] = color;
//		
//		}
//	
//	}
//
//	public int obtenLado() {
//		
//		return lado;
//		
//	}
//
//	private void cargarSprite(int version) {
//		
//		if (version == 0) {
//		
//			cargaNormal();
//		
//		} else {
//		
//			cargaManipulada(version);
//		
//		}
//	
//	}
//
//	private void cargaNormal() {
//		
//		for (int y = 0; y < lado; y++) {
//		
//			for (int x = 0; x < lado; x++) {
//			
//				int indexDelPixelAOcupar = x + y * lado;
//				
//				int posicionFinalX = x + this.getX();
//				int posicionFinalY = y + this.getY();
//				
//				int indexDelPixelATransferir = posicionFinalX + posicionFinalY * this.hojaSprites.getAncho();
//
//				int valorDelPixelATransferir = this.hojaSprites.pixeles[indexDelPixelATransferir];
//				
//				pixeles[indexDelPixelAOcupar] = valorDelPixelATransferir;
//		
//			}
//		
//		}
//		
//	}
//
//	private void cargaManipulada(int version) { // pasandole la verion que queremos del sprite y una copia de sus
//												// pixeles manipularemos la manera de cargar los pixeles para rotar los
//												// sprites
//		int[] pixelesTemporales = iniciarPixelesTemporales();
//
//		// dependiedo de la version rotamos los sprites
//		switch (version) {
//		case 1:
//			invertirX(pixelesTemporales);
//			break;
//		case 2:
//			invertirY(pixelesTemporales);
//			break;
//		case 3:
//			invertirXY(pixelesTemporales);
//			break;
//		case 4:
//			rotar90I(pixelesTemporales);
//			break;
//		case 5:
//			rotar90D(pixelesTemporales);
//			break;
//		case 6:
//			rotarI90InvertirY(pixelesTemporales);
//			break;
//		case 7:
//			rotarD90InvertirY(pixelesTemporales);
//			break;
//		default:
//			cargaNormal();
//		}
//
//	}
//
//	private int[] iniciarPixelesTemporales() { // hacemos una copia de los pixeles de un sprite temporalmente para
//												// rotarlos
//		int[] pixelesTemporales = new int[lado * lado];
//
//		for (int y = 0; y < lado; y++) {
//			
//			for (int x = 0; x < lado; x++) {
//			
//				int indexDelPixelAOcupar = x + y * lado;
//				
//				int posicionFinalX = x + this.getX();
//				int posicionFinalY = y + this.getY();
//				
//				int indexDelPixelATransferir = posicionFinalX + posicionFinalY * this.hojaSprites.getAncho();
//
//				int valorDelPixelATransferir = this.hojaSprites.pixeles[indexDelPixelATransferir];
//				
//				pixeles[indexDelPixelAOcupar] = valorDelPixelATransferir;
//		
//			}
//		
//		}
//		
//		return pixelesTemporales;
//		
//	}
//
//	// 1
//	private void invertirX(int[] pixelesTemporales) { // le pasamos la copia del sprite temporal
//		
//		int i = 0;
//		
//		for (int y = 0; y < lado; y++) {
//			
//			for (int x = lado - 1; x > -1; x--) {
//				
//				pixeles[i] = pixelesTemporales[x + y * lado];
//				
//				i++;
//				
//			}
//			
//		}
//		
//	}
//
//	// 2
//	private void invertirY(int[] pixelesTemporales) {
//		
//		int i = 0;
//		
//		for (int y = lado - 1; y > -1; y--) {
//			
//			for (int x = 0; x < lado; x++) {
//				
//				pixeles[i] = pixelesTemporales[x + y * lado];
//				
//				i++;
//				
//			}
//			
//		}
//		
//	}
//
//	// 3
//	private void invertirXY(int[] pixelesTemporales) {
//		
//		for (int i = 0; i < pixeles.length; i++) {
//			
//			pixeles[i] = pixelesTemporales[pixelesTemporales.length - 1 - i];
//			
//		}
//		
//	}
//
//	// 4
//	private void rotar90I(int[] pixelesTemporales) {
//		
//		int i = 0;
//		
//		for (int x = lado - 1; x > -1; x--) {
//			
//			for (int y = 0; y < lado; y++) {
//				
//				pixeles[i] = pixelesTemporales[x + y * lado];
//				
//				i++;
//				
//			}
//			
//		}
//		
//	}
//
//	// 5
//	private void rotar90D(int[] pixelesTemporales) {
//		
//		int i = 0;
//		
//		for (int x = 0; x < lado; x++) {
//			
//			for (int y = lado - 1; y > -1; y--) {
//				
//				pixeles[i] = pixelesTemporales[x + y * lado];
//				
//				i++;
//				
//			}
//			
//		}
//		
//	}
//
//	// 6
//	private void rotarI90InvertirY(int[] pixelesTemporales) {
//		
//		int i = 0;
//		
//		for (int x = 0; x < lado; x++) {
//			
//			for (int y = 0; y < lado; y++) {
//				
//				pixeles[i] = pixelesTemporales[x + y * lado];
//				
//				i++;
//				
//			}
//			
//		}
//		
//	}
//
//	// 7
//	private void rotarD90InvertirY(int[] pixelesTemporales) {
//		
//		int i = 0;
//		
//		for (int x = lado - 1; x > -1; x--) {
//			
//			for (int y = lado - 1; y > -1; y--) {
//				
//				pixeles[i] = pixelesTemporales[x + y * lado];
//				
//				i++;
//				
//			}
//			
//		}
//		
//	}

	private int getY() {

		return y;

	}

	private int getX() {

		return x;

	}
	
	public int getLado() {
		return lado;
	}

	public static void setLado(int lado) {
		Sprite.lado = lado;
	}

	public static int getMascara() {

		return mascara;

	}

	public static void setMascara(int mascara) {

		Sprite.mascara = mascara;

	}

	public static Point getCoordenadasSprite() {

		return coordenadasSprite;

	}

	public static void setCoordenadasSprite(Point coordenadasSprite) {

		Sprite.coordenadasSprite = coordenadasSprite;

	}

	public int[] getPixeles() {

		return pixeles;

	}

	public void setPixeles(int[] pixeles) {

		this.pixeles = pixeles;

	}

}
