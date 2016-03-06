package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import backend.Connect4;

@SuppressWarnings("serial")
public class Draw extends JPanel implements ActionListener {

	public static final int ROWS = 6;
	public static final int COLUMNS = 7;
	private static final int HOR_GAP = 50;
	private static final int VER_GAP = 150;
	private static final int TILES_GAP = 10;
	private static final int TILE = 70;
	private static final int BOARDWIDTH = 2 * HOR_GAP + COLUMNS * TILE + (COLUMNS - 1) * TILES_GAP;
	private static final int BOARDHEIGHT = TILE + ROWS * TILE + (ROWS - 1) * TILES_GAP;

	Connect4 newgame = new Connect4();

	MA mouseAdapter = new MA();

	int x, y, source;
	int currentY;

	public void actionPerformed(ActionEvent event) {
		currentY = currentY + 2;
		System.out.println(event.getActionCommand());
		repaint();
	}

	public void drawing(int xx, int yy, int source) {
		x = xx;
		y = yy;
		this.source = source;
		repaint();
	}

	private void initUI(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRoundRect(10, VER_GAP - TILE / 2, BOARDWIDTH, BOARDHEIGHT, 50, 50);
		int[][] board = newgame.getArray();
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				int horStart = 10 + HOR_GAP + j * (TILE + TILES_GAP);
				int verStart = VER_GAP + i * (TILE + TILES_GAP);

				if (board[i][j] == 0)
					g.setColor(getBackground());
				else if (board[i][j] == 1)
					g.setColor(Color.RED);
				else if (board[i][j] == 2)
					g.setColor(Color.YELLOW);
				g.fillOval(horStart, verStart, TILE, TILE);
			}
		}
	}

	public void paintComponent(Graphics g) {
		initUI(g);

		g.setColor(newgame.getPlayer() == 1 ? Color.RED : Color.YELLOW);
		// calculate above which column will the coin be displayed
		int column = (x - HOR_GAP - 10) / (TILE + TILES_GAP);
		if (column < 7)
			g.fillOval(calcXCoord(column), 40, TILE, TILE);

		if (this.source == 1) {
			if (column >= 7)
				JOptionPane.showMessageDialog(this, "cannot insert coin here",
						"error", JOptionPane.PLAIN_MESSAGE);
			else if (newgame.insertCoin(column) == -2)
				JOptionPane.showMessageDialog(this, "cannot insert coin here",
						"error", JOptionPane.PLAIN_MESSAGE);
			else {
				initUI(g);
				g.setColor(newgame.getPlayer() == 1 ? Color.RED : Color.YELLOW);
				if (column < 7)
					g.fillOval(calcXCoord(column), 40, TILE, TILE);
				int winner = newgame.getWinner();
				if (winner == 1)
					JOptionPane.showMessageDialog(this,
							"Player 1 wins\nCongratulations", "error",
							JOptionPane.PLAIN_MESSAGE);
				else if (winner == 2)
					JOptionPane.showMessageDialog(this,
							"Player 2 wins\nCongratulations", "error",
							JOptionPane.PLAIN_MESSAGE);
				else if (winner == -1) // draw
					JOptionPane.showMessageDialog(this,
							"The game ended as a DRAW", "error",
							JOptionPane.PLAIN_MESSAGE);
			}

		}
	}

//	 private void translate(Graphics g)
//	 {
//	 g.setColor(true ? Color.RED : Color.YELLOW);
//	 g.fillOval(calcXCoord(5),currentY , TILE, TILE);
//	 timer.start();
//	 }

	private int calcXCoord(int columnNum) {
		return 10 + HOR_GAP + columnNum * (TILE + TILES_GAP);
	}
}
