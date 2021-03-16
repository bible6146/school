package go;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JFrame implements KeyListener{
	imgPanel ho=new imgPanel();
	JLabel ja=new JLabel();
	int gindex=0;
	public Game() {
		ja.setSize(800,100);
		this.add(ja,BorderLayout.SOUTH);
		this.add(ho,BorderLayout.CENTER);
		this.setSize(800,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(this);
	}
	public static void main(String[] args) {
		new Game();

	}
	class imgPanel extends JPanel implements ActionListener{
		Image img;
		int index=0;
		int x=500,y=300;
		Timer timer;
		Random ra=new Random();
		ArrayList<pizza> list=new ArrayList<pizza>();
		public imgPanel() {
			this.setBackground(Color.BLACK);
			File input=new File("C:\\Users\\bon202-2\\Downloads\\jo.png");
			try{
				img=ImageIO.read(input);
				img=img.getScaledInstance(40, 40, img.SCALE_SMOOTH);
			}catch(Exception e) {
				System.out.println("시류ㅐ");
				System.exit(1);
			}
			
			timer=new Timer(25,this);
			timer.start();
			
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, x,y,this);
			for(pizza s:list) {
				g.drawImage(s.p1,s.x,s.y, this);
				Rectangle r=new Rectangle(s.x-5,s.y-5,30,30);
				if(r.contains(ho.x,ho.y)) {
					remove(ho);
					ho.img=null;
					timer.stop();
				}
			}
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(index%20==0) {
				for(int i=0;i<ra.nextInt(10);i++) {
					list.add(new pizza());
					gindex++;
					ja.setText("                "+String.valueOf(gindex/2));
			}
				
			}
			for(pizza s:list) {
				s.y+=10;
			}
			repaint();
			index++;
			
		}
		class pizza{
			int x=ra.nextInt(500),y=0;
			Image p1;
			public pizza() {
				try{
					File inpu=new File("C:\\Users\\bon202-2\\Downloads\\c1c.png");
					p1=ImageIO.read(inpu);
					p1=p1.getScaledInstance(30, 30, p1.SCALE_SMOOTH);
				}catch(Exception e) {
					System.out.println("시류ㅐ");
					System.exit(1);
				}
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
//		if(e.getKeyCode()==39) {
//			ho.x+=20;
//		}
//		if(e.getKeyCode()==37) {
//			ho.x-=20;
//		}
//		if(e.getKeyCode()==38) {
//			ho.y-=20;
//		}
//		if(e.getKeyCode()==40) {
//			ho.y+=20;
//		}
//		ho.repaint();
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==39) {
			ho.x+=20;
		}
		if(e.getKeyCode()==37) {
			ho.x-=20;
		}
		if(e.getKeyCode()==38) {
			ho.y-=20;
		}
		if(e.getKeyCode()==40) {
			ho.y+=20;
		}
		ho.repaint();
		//System.out.println(e.getKeyCode());	
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}















