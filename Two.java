package first;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Two extends JFrame {
	int[] x= {10,30,80,90};
	int[] y= {40,10,60,40};
	public Two() {
		this.add(new Panel2());
		this.setSize(1000,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Two();
	}
	class Panel2 extends JPanel implements MouseListener, MouseMotionListener{
		bezi mo;
		int line=0;
		int[] a= {50,150,300,450};
		int[] b= {200,50,300,200};
		int[] c= {100,300,600,900};
		int[] d= {400,100,600,400};
		bezi b1=new bezi(a,b);
		bezi b2=new bezi(c,d);
		bezi[] list=new bezi[2];
		//ArrayList<bezi> list=new ArrayList<>();
		public Panel2() {
			list[0]=(b1);
			list[1]=(b2);
		//	this.setSize(500,200);
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
				for(int i=0;i<4;i++) {
				g.fillRect(b1.x[i],b1.y[i], 15, 15);
			}
				g.setColor(Color.RED);
			for(int i=0;i<4;i++) {
				g.fillRect(b2.x[i],b2.y[i], 15, 15);
			}
				
			Graphics2D g2=(Graphics2D)g;
			GeneralPath path=new GeneralPath();
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(3));
			for(bezi b:list) {
				path.moveTo(b.x[0], b.y[0]);
				path.curveTo(b.x[1],b.y[1],b.x[2],b.y[2],b.x[3],b.y[3]);
				path.moveTo(b.x[0], b.y[0]);
				path.curveTo(b.x[1],b.y[1],b.x[2],b.y[2],b.x[3],b.y[3]);
				g2.draw(path);
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
			for(int j=0;j<2;j++) {
				for(int i=0;i<4;i++) {
					Rectangle r=new Rectangle(list[j].x[i]-4,list[j].y[i]-4,20,20);
					if(r.contains(e.getX(),e.getY())) {
						System.out.println("Å¬¸¯");
						list[line].index=i;
						line=j;
					}
				}
			}
			repaint();
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			
			list[line].index=-1;
			repaint();
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			if(list[line].index!=-1) {
				list[line].x[list[line].index]=e.getX();
				list[line].y[list[line].index]=e.getY();
			}
			repaint();
			
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	class bezi{
		int[] x;
		int[] y;
		int index=-1;
		public bezi(int[] a,int[] b) {
			x=new int[4];
			y=new int[4];
			for(int i=0;i<4;i++) {
				x[i]=a[i];
				y[i]=b[i];
			}
			
		}
	}
	}
	

}

