package frontend;

import javax.swing.JFrame;

public class Game extends JFrame {

	// this is just to suppress eclipse warning
	private static final long serialVersionUID = 1L;

	// initialize the game frame and its components
	public Game()
	{
		JFrame frame = new JFrame("Connect 4");
		Draw UI = new Draw();
		frame.setSize(1024, 720);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(UI);
		
		// register the UI as a mouse listener and mouse motion listener
		UI.addMouseListener(UI);
		UI.addMouseMotionListener(UI);
	}
	
	public static void main(String[] args) {
		new Game();
	}

}
