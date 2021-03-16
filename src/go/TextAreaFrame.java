package go;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaFrame extends JFrame implements ActionListener{
   private JTextField textField;
   private JTextArea textArea;
   
   public TextAreaFrame() {
	   this.setLayout(new BorderLayout());
      setTitle("Text Area");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      textField = new JTextField(30);
      textField.addActionListener(this);
      
      textArea = new JTextArea(10,30);
      textArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(textArea);
      
      
      add(textField, BorderLayout.NORTH);
      add(textArea, BorderLayout.CENTER);
      add(scrollPane);
      
      pack();
      //setSize(300,300);
      setVisible(true);
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      String text = textField.getText();
      textArea.append(text + "\n");
      textField.selectAll();
     // textArea.setCaretPosition(textArea.getDocument().getLength());
   }
   public static void main(String[] args) {
      new TextAreaFrame();
   }
}