import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window  extends JFrame  implements ActionListener{
  private Container pane;

  private JButton C, F;
  private JTextField t;

  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    System.out.println(s);
    
  }
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public Window() {
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());

    F = new JButton("Convert to Fahrenheit");
    C = new JButton("Convert to Celsius");
    t = new JTextField(12);

    C.addActionListener(this);
    F.addActionListener(this);
    t.addActionListener(this);
    
    pane.add(C);
    pane.add(F);
    pane.add(t);
  }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
    Window g = new Window();
    g.setVisible(true);
  }
}
