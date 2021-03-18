package go;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements KeyListener{
	Ball ball;
	Racket racket1;
	Racket racket2;
	int index=0,index2=0;
	public GameBoard() {
		ball = new Ball(this, Color.red);
		this.setBackground(Color.green);
		racket1 = new Racket(this, 10, 150, Color.blue);
		racket2 = new Racket(this, 560, 150, Color.yellow);
		setFocusable(true);
		addKeyListener(this);
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==87||e.getKeyCode()==83) {
			
			racket1.keyReleased(e);
		}
		else racket2.keyReleased(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==87||e.getKeyCode()==83) {
			racket1.keyPressed(e);
			}
		else racket2.keyPressed(e);
	}
	
	private void move() {
		ball.move();
		racket1.move();
		racket2.move();
		checkCollision();
		

	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		ball.draw(g2d);
		racket1.draw(g2d);
		racket2.draw(g2d);
		g.drawLine(300, 0,300,400);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Serif", Font.PLAIN, 40));
		g.drawString(String.valueOf(index), 250, 40);
		g.drawString(String.valueOf(index2), 330, 40);
		
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("PingPong°ÔÀÓ");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameBoard game = new GameBoard();
		frame.add(game);
		frame.setVisible(true);
		
		
		while (true) {
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	void checkCollision() {
		if(ball.x+40>=this.getWidth()) {
			ball.x=this.getWidth()/2;
			index++;
		}
		if(ball.x+ball.xspeed<=0) {
			ball.x=this.getWidth()/2;
			index2++;
		}
	}

}
class Ball {
	private static final int RADIUS = 20;
	int x =200;
	int y =100;
	int xspeed = 1;
	int yspeed = 1;
	private GameBoard game;
	Color color;
	
	public Ball(GameBoard game, Color color) {
		
		this.game = game;
		this.color = color;
	}
	
	void move() {
		if(x + xspeed < 0)
			xspeed = 5;
		if(x + xspeed > game.getWidth() -2 * RADIUS)
			xspeed = -5;
		if(y + yspeed < 0)
			yspeed = 5;
		if(y + yspeed > game.getHeight() -2 * RADIUS)
			yspeed = -5;
		if(collision()) {
			xspeed = -xspeed;
		}
		x = x + xspeed;
		y = y + yspeed;
	}
	
	private boolean collision() {
		return game.racket1.getBounds().intersects(this.getBounds())
				|| game.racket2.getBounds().intersects(this.getBounds());
	}
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
	}
}
class Racket {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 80;
	int x = 0;
	int y = 0;
	Color color;
	int xspeed = 0;
	int yspeed = 0;
	private GameBoard game;
	
	public Racket(GameBoard game, int x, int y, Color color) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void move() {
		if(y + yspeed > 0 && y + yspeed < game.getHeight() - HEIGHT)
			y = y + yspeed;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public void keyReleased(KeyEvent e) {
		yspeed = 0;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode()==87)
			yspeed = -3;
		if(e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode()==83)
			yspeed = 3;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
}