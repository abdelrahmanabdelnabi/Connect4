package frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import backend.Connect4;

public class Draw extends JPanel implements MouseListener, MouseMotionListener {

	// this is just to suppress eclipse warning
	private static final long serialVersionUID = 1L;

	// some constants for the game and board size
	public static final int ROWS = 6;
	public static final int COLUMNS = 7;
	private static final int HOR_GAP = 50;
	private static final int VER_GAP = 150;
	private static final int TILES_GAP = 10;
	private static final int TILE = 70;
	private static final int BOARDWIDTH = 2 * HOR_GAP + COLUMNS * TILE
			+ (COLUMNS - 1) * TILES_GAP;
	private static final int BOARDHEIGHT = TILE + ROWS * TILE + (ROWS - 1)
			* TILES_GAP;

	// the current X, and Y positions of the mouse pointer on the screen
	// the source represents the mouse event the occurred
	// eg. mouseClicked, mouseMoved, mouseDragged, ...
	private int pointerX, pointerY, source;

	// new instance of the Connect4 backend class which is responsible
	// for the game logic
	Connect4 newgame = new Connect4();

	// initialize the UI basic components
	private void initUI(Graphics g) {

		super.paintComponent(g);

		// the color of the board
		g.setColor(Color.BLUE);

		// draw the board
		g.fillRoundRect(10, VER_GAP - TILE / 2, BOARDWIDTH, BOARDHEIGHT, 50, 50);

		// a 2D array to represent the current game status
		int[][] board = newgame.getArray();

		// draw the coins
		for (int i = 0; i < ROWS; i++) {

			for (int j = 0; j < COLUMNS; j++) {

				// calculate the top left coordinates of the square enclosing
				// the circle (coin)
				int horStart = 10 + HOR_GAP + j * (TILE + TILES_GAP);
				int verStart = VER_GAP + i * (TILE + TILES_GAP);

				// determine the coin's color
				if (board[i][j] == 0)
					g.setColor(getBackground());

				else if (board[i][j] == 1)
					g.setColor(Color.RED);

				else if (board[i][j] == 2)
					g.setColor(Color.YELLOW);

				// now draw the coin
				g.fillOval(horStart, verStart, TILE, TILE);
			}
		}
	}

	// this methods gets called whenever a mouse action occurs to update the
	// window
	public void paintComponent(Graphics g) {
		initUI(g);

		// set the color of the coin according to the current player
		g.setColor(newgame.getPlayer() == 1 ? Color.RED : Color.YELLOW);

		// calculate above which column will the coin be displayed
		int column = (pointerX - HOR_GAP - 10) / (TILE + TILES_GAP);
		// draw the coin only if the mouse pointer is above the board
		if (column < 7)
			g.fillOval(calcXCoord(column), 40, TILE, TILE);

		// if the mouse is "clicked" (i.e the user wants to insert a coin
		// at the current mouse (column) position)
		if (this.source == 1) {

			// cannot insert a coin out of the board
			// display an error message
			if (column >= 7)
				JOptionPane.showMessageDialog(this, "cannot insert coin here",
						"error", JOptionPane.PLAIN_MESSAGE);

			// check if a coin can be inserted at the chosen column
			// i.e check if the current column is full
			// using a call to "insertCoin" in the backend/Connect4
			else if (newgame.insertCoin(column) == -2)
				JOptionPane.showMessageDialog(this, "cannot insert coin here",
						"error", JOptionPane.PLAIN_MESSAGE);

			// chosen input is valid
			// proceed to draw
			else {
				initUI(g);

				// set the color according to the current player
				// draw the coin at the mouse position
				g.setColor(newgame.getPlayer() == 1 ? Color.RED : Color.YELLOW);
				if (column < 7)
					g.fillOval(calcXCoord(column), 40, TILE, TILE);

				// check for winner
				int winner = 0;
				winner = newgame.getWinner();

				if (winner == 1) {
					super.paintComponent(g);
					initUI(g);
					g.setColor(Color.RED);
					g.setFont(new Font("Serif", Font.BOLD, 40));
					g.drawString("player 1 wins", this.getWidth() - 300,
							this.getHeight() / 2);
				
//					JOptionPane.showMessageDialog(this,
//							"Player 1 wins\nCongratulations", "WINNER",
//							JOptionPane.PLAIN_MESSAGE);

					// stop listening for mouse events
					this.removeMouseListener(this);
					this.removeMouseMotionListener(this);

				} else if (winner == 2) {
					super.paintComponent(g);
					initUI(g);
					g.setColor(Color.YELLOW);
					g.setFont(new Font("Serif", Font.BOLD, 40));
					g.drawString("player 1 wins", this.getWidth() - 300,
							this.getHeight() / 2);

//					JOptionPane.showMessageDialog(this,
//							"Player 2 wins\nCongratulations", "WINNER",
//							JOptionPane.PLAIN_MESSAGE);

					// stop listening for mouse events
					this.removeMouseListener(this);
					this.removeMouseMotionListener(this);
				}
				// if the game ended as a draw
				else if (winner == -1) {
					super.paintComponent(g);
					initUI(g);
					g.setColor(Color.BLACK);
					g.setFont(new Font("Serif", Font.BOLD, 40));
					g.drawString("DRAW", this.getWidth() - 300,
							this.getHeight() / 2);
					
//					JOptionPane.showMessageDialog(this,
//							"The game ended as a DRAW", "DRAW",
//							JOptionPane.PLAIN_MESSAGE);

					// stop listening for clicks
					this.removeMouseListener(this);
					this.removeMouseMotionListener(this);
				}
			}

		}
	}

	// helper method
	private int calcXCoord(int columnNum) {
		return 10 + HOR_GAP + columnNum * (TILE + TILES_GAP);
	}

	// response to mouse actions methods
	@Override
	public void mouseClicked(MouseEvent e) {
		pointerX = e.getX();
		pointerY = e.getY();
		source = 1;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pointerX = e.getX();
		pointerY = e.getY();
		source = 2;
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pointerX = e.getX();
		pointerY = e.getY();
		source = 3;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		pointerX = e.getX();
		pointerY = e.getY();
		source = 4;
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		pointerX = e.getX();
		pointerY = e.getY();
		source = 5;
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		pointerX = e.getX();
		pointerY = e.getY();
		source = 6;
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		pointerX = e.getX();
		pointerY = e.getY();
		source = 7;
		repaint();
	}
}
