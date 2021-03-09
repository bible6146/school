package go;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Eight extends JFrame implements ActionListener{
	JTextArea t1;
	JTextField t2;
	public Eight() {
		t1=new JTextArea(10,30);
		t1.setEditable(false);
		t2= new JTextField(30);
		t2.addActionListener(this);
		
		JPanel j=new JPanel();
		this.add(t2,BorderLayout.NORTH);
		this.add(t1,BorderLayout.CENTER);
		
		JScrollPane scroll=new JScrollPane(t1);
		this.add(scroll,BorderLayout.CENTER);
		
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		t1.append(t2.getText()+"\n");
		//t2.setText(null);]
		t2.selectAll();
		t1.setCaretPosition(t1.getDocument().getLength());
		
	}

	public static void main(String[] args) {
		new Eight();

	}


}
