package go;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import go.Game.imgPanel.pizza;

public class ComboBox extends JFrame implements ActionListener {
	JComboBox box=new JComboBox();;
	ArrayList<String> list=new ArrayList<String>();
	JLabel la;
	int index=0;
	
	public static void main(String args[]) {
		new ComboBox();
	}
	public ComboBox() {
		list.add("bird");
		list.add("hi");
		list.add("jo");
		for(int i=0;i<list.size();i++) {
			box.addItem(list.get(i));
		}
		
		box.setSelectedIndex(0);
		box.setEditable(true);
		box.addActionListener(this);
		this.add(box,BorderLayout.NORTH);
		la=new JLabel();
		la.setHorizontalAlignment(JLabel.CENTER);
		this.add(la,BorderLayout.CENTER);
		this.setSize(500,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	if(index%2==0) {
		boolean ss=true;
		JComboBox b1=(JComboBox)e.getSource();
		System.out.println(b1.getSelectedItem());

	for(String s:list) {
			if(s==String.valueOf(b1.getSelectedItem())) {
				ss=false;
				break;
			}
		}
		if(ss) {
			box.addItem(b1.getSelectedItem());
			System.out.println("haha");
			ss=false;
		}
		
		System.out.println("kkkkkkk");
		ImageIcon icon=new ImageIcon("C:\\Users\\bon202-2\\Downloads\\"+b1.getSelectedItem()+".png");
		//la.setText(null);
		la.setIcon(icon);
	}
	index++;
		
		
	}
	
}
