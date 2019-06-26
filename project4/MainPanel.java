package Assignment4;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MainPanel extends JPanel implements ActionListener {
	
	private final ArrayList<Point> points;
	private Point previousPoint;
	private JButton[] buttons;
	private boolean toggle = true; // toggle between two layouts
	private Container container; // frame container
	private GridLayout gridLayout1;
	private GridLayout gridLayout2;
	private JPanel buttonJPanel;
	
		
	public MainPanel() {
		points = new ArrayList<Point>();
		previousPoint = new Point(0,0);
		
		addMouseMotionListener(
			new MouseMotionAdapter(){
				public void mouseDragged(MouseEvent event){
					points.add(event.getPoint());	
					repaint();
					
					System.out.println(points.size() + ": x = " + points.get(points.size() - 1).x + " y = " + points.get(points.size() - 1).y);
				}
			}
		);

		buttons = new JButton[8]; // create buttons array
		buttonJPanel = new JPanel();
		buttonJPanel.setLayout(new GridLayout(1, buttons.length));
		// create and add buttons
		String[] buttonList = {"Green","Blue", "Black", "Red", "Large","Small", "Medium", "Clear"};
		for ( int count = 0; count < buttons.length; count++ ) {
			buttons[ count ] = new JButton(buttonList[count]);
			buttonJPanel.add( buttons[ count ] ); // add button to panel
		} // end for
		
		add( buttonJPanel, BorderLayout.SOUTH );
		
		
	}
	
 
		
	
	
	
	
	public void actionPerformed(ActionEvent event) {
		if ( toggle )
			container.setLayout(gridLayout2); // set layout to second
		else
			container.setLayout(gridLayout1); // set layout to first
	
		toggle = !toggle; // set toggle to opposite value
		container.validate(); // re-lay out container
	 } // end method actionPerformed

		
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		// Drawing dots	
		for(Point point : points)
			g.fillOval(point.x, point.y, 3, 3);
		//Moving the block
		if(points.size() > 1){
			if(points.get(points.size() - 1).x < previousPoint.x + 20 && points.get(points.size() - 1).y < previousPoint.y + 20){
				g.fillRect(points.get(points.size() - 1).x, points.get(points.size() - 1).y, 20, 10);
				previousPoint = points.get(points.size() - 2);
			}
		else {
			g.fillRect(previousPoint.x, previousPoint.y, 20, 10);
		}
		
	}	
}
	
}