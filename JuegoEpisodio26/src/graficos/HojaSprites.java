package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public final class HojaSprites {

	private final int x;
	private final int y;

	private String ruta;

	private BufferedImage img;

	public int[] pixeles;
	
	int totalPixeles;

	// coleccion de hojas de sprites
	public static HojaSprites desierto = new HojaSprites("/images/texturas/desierto.png", 320, 320);
	public static HojaSprites subterraneo = new HojaSprites("/images/texturas/subterraneo.png", 320, 320);
	public static HojaSprites jugador = new HojaSprites("/images/jugador.png", 128, 96);
	public static HojaSprites desierto2 = new HojaSprites("/images/texturas/4.png", 320, 320);

	// fin de la coleccion

	public HojaSprites(final String ruta, final int x, final int y) {

		this.x = x;
		this.y = y;

		totalPixeles = x * y;
		
		pixeles = new int[totalPixeles];

		BufferedImage imagen;
		
		try {

			URL url = HojaSprites.class.getResource(ruta);
			
			imagen = ImageIO.read(url);

			pixeles = imagen.getRGB(0, 0, x, y, null, 0, x);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}

	}

	public String getRuta() {
		
		return ruta;
		
	}

	public void setRuta(String ruta) {
		
		this.ruta = ruta;
		
	}

	public BufferedImage getImg() {
		
		return img;
		
	}

	public void setImg(BufferedImage img) {
		
		this.img = img;
		
	}

	public int[] getPixeles() {

		return pixeles;

	}

	public void setPixeles(int[] pixeles) {

		this.pixeles = pixeles;

	}

	public int getX() {
		
		return x;
	
	}

	public int getY() {
	
		return y;
	
	}
	

	public int getTotalPixeles() {
	
		return totalPixeles;
	
	}

	public void setTotalPixeles(int totalPixeles) {
	
		this.totalPixeles = totalPixeles;
	
	}

}
