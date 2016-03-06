package frontend;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Shapes {
	int x, y;
	public static Draw obj = new Draw();

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(1024, 720);
		frame.setTitle("connect 4 test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.addMouseListener(new MA());
		frame.add(obj);
		obj.addMouseListener(new MA());
		obj.addMouseMotionListener(new MA());

	}

	static class MA extends MouseAdapter {

		static int pointerX, pointerY, source;

		public void mouseClicked(MouseEvent event) {
			pointerX = event.getX();
			pointerY = event.getY();
			source = 1;
			obj.drawing(pointerX, pointerY, source);

		}

		public void mouseMoved(MouseEvent event) {
			pointerX = event.getX();
			pointerY = event.getX();
			source = 2;
			obj.drawing(pointerX, pointerY, source);
		}

		public void mouseDragged(MouseEvent event) {
			pointerX = event.getX();
			pointerY = event.getY();
			source = 3;
			obj.drawing(pointerX, pointerY, source);
		}

		public int getPointerX() {
			return pointerX;
		}

		public int getPointerY() {
			return pointerY;
		}
	}

}
