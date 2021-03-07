package first;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class There extends JFrame {
	double a=0,b=0,c=0;
	JTextField t1;
	JTextField t2;
	JTextField t3;
	JButton b1;
	panel3 p1=new panel3();
	panel4 p2=new panel4();
	boolean check=false;
	public There() {
		this.add(p1,BorderLayout.CENTER);
		this.add(p2,BorderLayout.NORTH);
		this.setSize(500,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String args[]) {
		new There();
	}
	class panel3 extends JPanel{
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2=(Graphics2D)g;
			g.drawLine(0, 200, 400,200);
			g.drawLine(200, 0, 200, 400);
			g.setColor(Color.RED);
			for(int i=-20;i<20;i++) {
				int x=i;
				int y=(int) (a*x*x-b*x+c);
				g2.fillOval(200+x,200- y, 4, 4);
			}
		}
	}
	class panel4 extends JPanel{
		public panel4() {
			t1=new JTextField("1.0",10);
			t2=new JTextField("-5.0",10);
			t3=new JTextField("6.0",10);
			b1=new JButton("¹öÆ°");
			this.add(t1);
			this.add(t2);
			this.add(t3);
			b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					a=Double.parseDouble(t1.getText());
					b=Double.parseDouble(t2.getText());
					c=Double.parseDouble(t3.getText());
					System.out.println(a+b+c);
					p1.repaint();
				}
			});
			this.add(b1);
		}
	}
}







