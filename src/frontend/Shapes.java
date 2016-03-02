package frontend;

import java.awt.*;
import javax.swing.*;
public class Shapes {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(1024,720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Draw object = new Draw();
		frame.add(object);
}
}
