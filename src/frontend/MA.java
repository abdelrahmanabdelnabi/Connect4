package frontend;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MA extends MouseAdapter {

	public static int pointerX, pointerY, source;
	

	public void mouseClicked(MouseEvent event) {
		pointerX = event.getX();
		pointerY = event.getY();
		source = 1;
		
	}

	public void mouseMoved(MouseEvent event) {
		pointerX = event.getX();
		pointerY = event.getX();
		source = 2;
	}

	public void mouseDragged(MouseEvent event) {
		pointerX = event.getX();
		pointerY = event.getY();
		source = 3;
	}
	
	public int getPointerX()
	{
		return pointerX;
	}
	
	public int getPointerY()
	{
		return pointerY;
	}
}
