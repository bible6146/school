package go;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButton extends JFrame implements ActionListener {
	public static void main(String agrs[]) {
		new RadioButton();
	}
	private JPanel topPanel,sizePanel,resultPanel;
	private JRadioButton small,medium,large;
	private JLabel TextLabel;
	public RadioButton() {
		topPanel=new JPanel();
		JLabel label=new JLabel("어떤 커피르 주문 하시겠습니까?");
		sizePanel=new JPanel();
		sizePanel.add(label);
		this.add(sizePanel);
		
		small=new JRadioButton("smallSize");
		small.addActionListener(this);
		medium=new JRadioButton("medium sizw");
		medium.addActionListener(this);
		large=new JRadioButton("large");
		large.addActionListener(this);
		
		ButtonGroup group=new ButtonGroup();
		group.add(small);
		group.add(medium);
		group.add(large);
		
		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		
		resultPanel=new JPanel();
		TextLabel =new JLabel("크기가 ㅈ선택됮 ㅣ않았습니다");
		TextLabel.setBackground(Color.blue);
		resultPanel.add(TextLabel);
		
		this.setSize(240,300);
		this.add(topPanel,BorderLayout.PAGE_START);
		this.add(sizePanel,BorderLayout.CENTER);
		this.add(resultPanel,BorderLayout.PAGE_END);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==small){
			TextLabel.setText("small 사이즈 선택");
		}else if(e.getSource()==medium) {
			TextLabel.setText("미디움 사이즈 선택");
		}else {
			TextLabel.setText("라지 사이즈 선택");
		}
		
	}
}
