package first;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class One extends JFrame {
	public One() {
		this.add(new Panel1());
		this.setSize(500,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new One();
	}

	class Panel1 extends JPanel implements ActionListener{
		Image img;
		int x=0,y=300;
		int a=-1;
		boolean xmove=false,ymove=false;
		public Panel1() {
			File input =new File("C:\\Users\\jungse\\Downloads\\pngegg.PNG");
			try {
				img=ImageIO.read(input);
				img=img.getScaledInstance(50, 53, Image.SCALE_SMOOTH);
			}catch(IOException e) {
				System.out.println("½ÇÆÐ");
				System.exit(1);
			}
			Timer timer=new Timer(1,this);
			timer.start();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			set();
			if(xmove)x--;
			else x++;
			if(ymove)y++;
			else y--;
			repaint();
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, x, y,this);
		
		}
		public void set() {
			if(x==500-50) {
				xmove=true;
			}
			if(y==0) {
				ymove=true;
			}
			if(x==0) {
				xmove=false;
			}
			if(y==400-70) {
				ymove=false;
			}
		}
		
	}

}
