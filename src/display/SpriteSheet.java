package display;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private BufferedImage sheet;
	private HashMap<String, Rectangle> map;
	
	public SpriteSheet(String fileName) throws IOException {
		File file = new File(fileName);
		if(!file.exists())
			throw new IOException("Sprite sheet not available");
		sheet = ImageIO.read(file);
		map = new HashMap<String, Rectangle>(0);
	}
	
	public void define(String name, int x, int y, int w, int h) throws IOException {
		define(name, new Rectangle(x, y, w, h));
	}
	
	public void define(String name, Rectangle sprite) throws IOException {
		Rectangle img = new Rectangle(0, 0, sheet.getWidth(), sheet.getHeight());
		if(!img.contains(sprite))
			throw new IOException("Invalid sprite bounds");
		map.put(name, sprite);
	}
	
	public BufferedImage get(String name) {
		Rectangle sprite = map.get(name);
		return sheet.getSubimage(sprite.x, sprite.y, sprite.width, sprite.height);
	}
}
