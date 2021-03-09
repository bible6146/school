package go;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class six extends JPanel implements ItemListener {
	private JCheckBox[] box=new JCheckBox[3];
	private JLabel[] label=new JLabel[3];
	ImageIcon icon;
	ImageIcon[] icons=new ImageIcon[3]; 
	String[] fruits= {"appp","grape","orange"};
	public six() {
		this.setLayout(new GridLayout(3,1));
		for(int i=0;i<3;i++) {
			box[i]=new JCheckBox(fruits[i]);
			box[i].addItemListener(this);
			label[i]=new JLabel(fruits[i]);
			icons[i]=new ImageIcon();
		}
		for(int i=0;i<3;i++) {
			this.add(box[i]);
			this.add(label[i]);
		
		}
		icon=new ImageIcon("C:\\Users\\bon202-2\\Downloads\\c1c.PNG");
		//icon=new ImageIcon("‪C:/Users/bon202-2/Desktop/duck/apple.jpg");
		//icon=new ImageIcon("C:\\Users\\bon202-2\\Downloads\\grape.JPG");
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		int index=0;
		for(int i=0;i<3;i++) {
			if(e.getSource().equals(box[i]))
			index=i;
		}
		if(label[index].getIcon()!=null) {
			label[index].setIcon(null);
			label[index].setText("골라주세요");
		}
		else {
			label[index].setIcon(icon);
			label[index].setText(null);
		}
		
	}
	public static void main(String[] args) {
		JFrame f1=new JFrame();
		f1.add(new six());
		f1.setSize(400,500);
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
		f1.setVisible(true);
		
	}

}
