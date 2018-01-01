package display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class GamePanel extends Canvas implements KeyListener {
	private static final long serialVersionUID = 1669753928994571274L;
	
	BufferStrategy strategy;
	
	public GamePanel(int width, int height) {
		super();
		setSize(width, height);
		setVisible(true);
		setBackground(Color.WHITE);
		createBufferStrategy(1);
		strategy = getBufferStrategy();
		requestFocus();
		addKeyListener(this);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP:
			System.out.println("UP");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("DOWN");
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("RIGHT");
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
