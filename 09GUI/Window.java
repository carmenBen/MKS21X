import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window  extends JFrame{
  private Container pane;

  private JButton CtoF, FtoC;
  private JTextField t;
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public Window() {
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

  }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
    Window g = new Window();
    g.setVisible(true);
  }
}
