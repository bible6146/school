package go;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class five extends JFrame  {
	JLabel label;
	 JPanel panel;
	public five() {
		panel=new JPanel();
		label=new JLabel("11111111111111111");
		JButton bu1=new JButton("icon");
		ImageIcon icon=new ImageIcon("C:\\Users\\bon202-2\\Downloads\\c1c.PNG");
		
		bu1.setIcon(icon);
		bu1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setIcon(icon);
				label.setText(null);
				
			}
		});
		panel.setSize(600,700);
		panel.setLayout(new BorderLayout());
		panel.add(bu1,BorderLayout.WEST);
		panel.add(label,BorderLayout.EAST);
		this.add(panel);
		this.setSize(800,440);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String agrs[]) {
		new five();
	}
}
