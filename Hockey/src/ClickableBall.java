import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickableBall extends FlashingBall implements MouseListener{

	public ClickableBall(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left, right, top, bottom);
		 boolean mouseButtonDown = false;
		 
		 public public void mousePressed (MouseEvent e){
				mouseButtonDown = true;
				x = e.getX ();
				y = e.getY ();
		 }
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
