import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import display.GamePanel;


public class SuperMario {

	public static void main(String args[]) {
		JFrame frame = new JFrame("Super Mario");
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setPreferredSize(new Dimension(600, 400));
		GamePanel canvas = new GamePanel(600, 400);
		panel.add(canvas);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}
