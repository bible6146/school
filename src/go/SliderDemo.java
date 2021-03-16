package go;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderDemo extends JFrame implements ChangeListener {
	JSlider sl;
	JLabel la=new JLabel("슬라이더를 움직여 보세요");
	JButton b1;
	public SliderDemo() {
		sl=new JSlider(0,50,15);
		JPanel pa3=new JPanel();
		b1=new JButton(" ");
		ImageIcon icon=new ImageIcon("C:\\Users\\bon202-2\\Downloads\\c1c.png");
		b1.setIcon(icon);
		b1.setSize(150,150);
		
		sl.setMajorTickSpacing(10);
		sl.setMinorTickSpacing(1);
		sl.setPaintTicks(true);
		sl.setPaintLabels(true);
		sl.addChangeListener(this);
		
		pa3.add(la);
		pa3.add(sl);
		pa3.add(b1);
		this.add(pa3);
		this.setSize(300,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SliderDemo();

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider sour=(JSlider)e.getSource();
		if(!sour.getValueIsAdjusting()) {
			int value=sour.getValue();
			b1.setSize(value*6,value*6);
			System.out.println("   2232323");
		}
		
	}

}
