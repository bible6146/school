package first;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class four extends JFrame {
	public four() {
		this.add(new panel5());
		this.setSize(600,130);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new four();

	}
	class panel5 extends JPanel{
		@Override
		public void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(3));
		GradientPaint gp=new GradientPaint(0, 10, Color.WHITE, 0,70,Color.RED);
		g2.setColor(Color.RED);
		g2.fill(new Rectangle2D.Float(10,10,70,80));
		g2.fill(new Ellipse2D.Float(210,10,80,80));
		g2.fill(new Arc2D.Float(410,10,80,80,30,230,Arc2D.CHORD));
		g2.setPaint(gp);
		g2.fill(new RoundRectangle2D.Float(110,10,70,80,20,20));
		g2.fill(new Arc2D.Float(310,10,80,80,30,230,Arc2D.CHORD));
		g2.fill(new Arc2D.Float(510,10,80,80,30,230,Arc2D.PIE));
		}
	}
}








