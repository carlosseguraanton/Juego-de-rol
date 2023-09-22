package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import control.Teclado;
import graficos.CapturadorPixeles;

import graficos.Sprite;
import criaturas.jugador.Jugador;

public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static String CONTADOR_APS = "";
	private static String CONTADOR_FPS = "";

	private static int aps = 0;
	private static int dps = 0;

	private int x = 0;
	private int y = 0;

	private static final String NAME = "Juego de rol 2D";

	public static final short WIDTH = 768;
	public static final short HEIGHT = WIDTH / 3 * 2;

	final int posicionCentralCanvasX = WIDTH / 2;
	final int posicionCentralCanvasY = HEIGHT / 2;

	private static volatile boolean juegoEstaEnFuncionamiento = false;

	private static JFrame ventana;
	
	private static Thread threadGraficos;
	
	private static CapturadorPixeles capturadorPixeles;
	
	private static Teclado teclado;
	
	private static Jugador jugador;

	static int TYPE_INT_RGB = BufferedImage.TYPE_INT_RGB;

	private static BufferedImage img = new BufferedImage(WIDTH, HEIGHT, TYPE_INT_RGB);

	static WritableRaster writableRaster = img.getRaster();

	static DataBuffer dataBuffer = writableRaster.getDataBuffer();

	private static DataBufferInt dataBufferInt = (DataBufferInt) dataBuffer;

	private static int[] pixelesCanvas = dataBufferInt.getData();
	
	private int[] pixelesCapturados;
	
	static String rutaIcono = "/images/icono/Ginger_man_icon.png";
	
	static URL URL = Juego.class.getResource(rutaIcono);

	private static final ImageIcon icono = new ImageIcon(URL);

	private Juego() {

		capturadorPixeles = new CapturadorPixeles(WIDTH, HEIGHT);
		
		teclado = new Teclado();
		
		addKeyListener(teclado);
		
		jugador = new Jugador(teclado, Sprite.jugador);
//		jugador = new Jugador(teclado, Sprite.jugador, posicionCentralCanvasX, posicionCentralCanvasY);
		
		Dimension dimension = new Dimension(WIDTH, HEIGHT);

		setPreferredSize(dimension);
		
		ventana = new JFrame(NAME);

		int operation = JFrame.EXIT_ON_CLOSE;

		ventana.setDefaultCloseOperation(operation);

		ventana.setResizable(false);
		
		Image img = icono.getImage();

		ventana.setIconImage(img);

		BorderLayout newBorderLayout = new BorderLayout();

		ventana.setLayout(newBorderLayout);

		String borderLayoutCenter = BorderLayout.CENTER;

		ventana.add(this, borderLayoutCenter);

		ventana.pack();

		ventana.setLocationRelativeTo(null);

		ventana.setVisible(true);

		requestFocus();

	}

	public static void main(String[] args) {

		Juego juego = new Juego();

		juego.iniciar();

	}

	private synchronized void iniciar() {

		juegoEstaEnFuncionamiento = true;

		threadGraficos = new Thread(this, "Graficos");

		threadGraficos.start();
		
	}
	
	private synchronized void detener() {

		juegoEstaEnFuncionamiento = false;

		threadGraficos.interrupt();

		int status = 0;
		
		System.exit(status);
		
	}

	private void actualizar() {

		teclado.actualizar();
		
		jugador.actualizar();

		if (teclado.salir) {
			
			this.detener();

		}
		
		aps = aps + 1;

	}

	private void refrescarCanvas() {

		BufferStrategy bufferStrategy = getBufferStrategy();

		if (bufferStrategy == null) {

			createBufferStrategy(3);

			return;

		}

		int posicionJugadorX = jugador.obtenerPosicionX();
		int posicionJugadorY = jugador.obtenerPosicionY();
		
		int centroCapturadorX = CapturadorPixeles.obtenAncho() / 2;
		int centroCapturadorY = CapturadorPixeles.obtenAlto() / 2;
		
		int desplazamientoJugadorX = posicionJugadorX - centroCapturadorX + jugador.obtenSprite().getLado() / 2;
		int desplazamientoJugadorY = posicionJugadorY - centroCapturadorY + jugador.obtenSprite().getLado() / 2;
		
//		capturadorPixeles.establecerPosicion(this.x, this.y);
		capturadorPixeles.establecerPosicion(desplazamientoJugadorX, desplazamientoJugadorY);
		
		int valorMinimoPosicionY = desplazamientoJugadorY >> 5;
		
		int valorMaximoPosicionY = (desplazamientoJugadorY + CapturadorPixeles.obtenAlto() + Sprite.lado) >> 5;

//		int valorMinimoPosicionY = y >> 5;
//
//		int valorMaximoPosicionY = (y + CapturadorPixeles.obtenAlto() + Sprite.lado) >> 5;

		for (int y = valorMinimoPosicionY; y < valorMaximoPosicionY; y++) {

//			int valorMinimoPosicionX = x >> 5;
//
//			int valorMaximoPosicionX = (x + CapturadorPixeles.obtenAncho() + Sprite.lado) >> 5;
			
			int valorMinimoPosicionX = desplazamientoJugadorX >> 5;
		
			int valorMaximoPosicionX = (desplazamientoJugadorX + CapturadorPixeles.obtenAncho() + Sprite.lado) >> 5;

			for (int x = valorMinimoPosicionX; x < valorMaximoPosicionX; x++) {

				int desplazamientoX = x << 5;
				int desplazamientoY = y << 5;
				
//				pixelesCapturados = CapturadorPixeles.capturarSpriteDesplazado(desplazamientoX, desplazamientoY, Sprite.ASFALTO);
				
					pixelesCapturados = CapturadorPixeles.capturarSpriteDesplazado(desplazamientoX, desplazamientoY, Sprite.ASFALTO);
				
				
			}

		}
		
		jugador.transferirSpriteDesplazado();
		
		System.arraycopy(pixelesCapturados, 0, pixelesCanvas, 0, pixelesCanvas.length);

		Graphics g = bufferStrategy.getDrawGraphics();

		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);

		Color red = Color.red;
		
		g.setColor(red);
		
		g.drawString(CONTADOR_APS, 10, 20);
		g.drawString(CONTADOR_FPS, 10, 35);

		g.drawString("aps: " + aps, 10, 80);
		g.drawString("dps: " + dps, 10, 95);

		g.drawString("X: " + x, 10, 50);
		g.drawString("Y: " + y, 10, 65);
		
		String stringPosicionJugadorX = "PosicionJugadorX: " + jugador.obtenerPosicionX();
		String stringPosicionJugadorY = "PosicionJugadorY: " + jugador.obtenerPosicionY();
		
		g.drawString(stringPosicionJugadorX, 10, 110);
		g.drawString(stringPosicionJugadorY, 10, 125);
		
		String posicionCapturadorX = "PosicionCapturadorX: " + capturadorPixeles.getX();
		String posicionCapturadorY = "PosicionCapturadorY: " + capturadorPixeles.getY();
		
		g.drawString(posicionCapturadorX, 10, 140);
		g.drawString(posicionCapturadorY, 10, 155);
		
		String direccion = "Direccion: " + jugador.getDireccion();
		
		g.drawString(direccion, 10, 170);
		
		g.dispose();

		bufferStrategy.show();

		dps = dps + 1;

	}

	@Override
	public void run() {

		final int nanoSegundosQueHayEnUnSegundo = 1000000000;

		final byte actualizacionesAEfectuarEnCadaSegundoComoObjetivo_APS = 60;

		final long tiempoATranscurrirEntreActualizaciones = nanoSegundosQueHayEnUnSegundo / actualizacionesAEfectuarEnCadaSegundoComoObjetivo_APS;

		long referenciaTemporalDeActualizacionFueraDelBucleWhile = System.nanoTime();
		
		long referenciaTemporalParaElIndicador = System.nanoTime();

		float tiempoEstimadoQueHaTranscurridoEntreAsignacionesReferenciasTemporales;

		float acumuladorTiempoTranscurridoRealmente_delta = 0;

		while (juegoEstaEnFuncionamiento) {

			final long referenciaAlInicioDelBucleWhile = System.nanoTime();

			tiempoEstimadoQueHaTranscurridoEntreAsignacionesReferenciasTemporales = referenciaAlInicioDelBucleWhile - referenciaTemporalDeActualizacionFueraDelBucleWhile;

			referenciaTemporalDeActualizacionFueraDelBucleWhile = referenciaAlInicioDelBucleWhile;

			float tiempoTranscurridoRealmenteEntreAsignaciones = tiempoEstimadoQueHaTranscurridoEntreAsignacionesReferenciasTemporales / tiempoATranscurrirEntreActualizaciones;

			acumuladorTiempoTranscurridoRealmente_delta = acumuladorTiempoTranscurridoRealmente_delta + tiempoTranscurridoRealmenteEntreAsignaciones;
			
			final byte unSegundo = 1;

			while (acumuladorTiempoTranscurridoRealmente_delta >= unSegundo) {

				actualizar();

				acumuladorTiempoTranscurridoRealmente_delta = acumuladorTiempoTranscurridoRealmente_delta - 1;

			}

			refrescarCanvas();

			long referenciaPreSubtraccion = System.nanoTime();

			long tiempoTranscurridoDesdeReferenciaPreSubtraccionHastaReferenciaParaElIndicador = referenciaPreSubtraccion - referenciaTemporalParaElIndicador;

			if (tiempoTranscurridoDesdeReferenciaPreSubtraccionHastaReferenciaParaElIndicador > nanoSegundosQueHayEnUnSegundo) {

				ventana.setTitle(NAME + " || Actualizaciones por segundo: " + acumulador_aps + " || Dibujos por segundo: " + acumulador_dps);

				ACUMULADOR_APS = "APS: " + acumulador_aps;
				ACUMULADOR_FPS = "DPS: " + acumulador_dps;
				
				acumulador_aps = 0;
				acumulador_dps = 0;

				referenciaTemporalParaElIndicador = System.nanoTime();

			}

		}

	}

}

