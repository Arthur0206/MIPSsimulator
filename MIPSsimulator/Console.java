import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Console extends JPanel implements ActionListener {
  protected JTextField textField;
  protected JTextArea textArea;
  private final static String newline = "\n";

  public Console() {
    super(new GridBagLayout());

    textField = new JTextField(30);
    textField.addActionListener(this);

    textArea = new JTextArea(30,50);
    textArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textArea);

    GridBagConstraints c = new GridBagConstraints();
    c.gridwidth = GridBagConstraints.REMAINDER;

    c.fill = GridBagConstraints.HORIZONTAL;
    add(textField, c);

    c.fill = GridBagConstraints.BOTH;
    c.weightx = 1.0;
    c.weighty = 1.0;
    add(scrollPane, c);
  }

  public void actionPerformed(ActionEvent evt) {
    String text = textField.getText();
    textArea.append(text + text + newline);
    textField.selectAll();

    textArea.setCaretPosition(textArea.getDocument().getLength());
  }

  private static void createAndShowGUI() {
    JFrame frame = new JFrame("Console");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.add(new Console());

    frame.pack();
    frame.setVisible(true);
  }
  
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}




