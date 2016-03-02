package frontend;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Draw extends JPanel{
	
	public static final int ROWS = 6;
	public static final int COLUMNS = 7;
	private static final int HOR_GAP = 50;
	private static final int VER_GAP = 50;
	private static final int TILES_GAP = 10;
	private static final int TILE = 80;
	private static final int BOARDWIDTH = 2*HOR_GAP + COLUMNS*TILE + (COLUMNS - 1)*TILES_GAP;
	private static final int BOARDHEIGHT = 2*VER_GAP + ROWS*TILE + (ROWS - 1)*TILES_GAP;
	public void drawing()
	{
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRoundRect(10, 10, BOARDWIDTH, BOARDHEIGHT, 50, 50);
		
		g.setColor(getBackground());
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				int horStart = HOR_GAP + j*(TILE + TILES_GAP);
				int verStart = VER_GAP + i*(TILE + TILES_GAP);
				g.fillOval(horStart, verStart, TILE, TILE);
			}
		}
	}
}
