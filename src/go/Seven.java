package go;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Seven extends JFrame implements ActionListener{
	JTextField t1,t2;
	JButton bu1;
	public Seven() {
		t1=new JTextField(15);
		t1.addActionListener(this);
		JLabel la1=new JLabel("숫자이력 :");
		t2=new JTextField(15);
		t2.setEditable(false);
		JLabel la2=new JLabel("제곱합 결과:");
		JPanel p1=new JPanel();
		p1.add(la1);
		p1.add(t1);
		p1.add(la2);
		p1.add(t2);
		bu1=new JButton("ok");
		bu1.addActionListener(this);
		p1.add(bu1);
		
		this.add(p1);
		this.setSize(300,130);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bu1||e.getSource()==t1) {
			int a=Integer.parseInt(t1.getText());
			t2.setText(String.valueOf(a*a));
			t1.requestFocus();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new Seven();
	}













}
