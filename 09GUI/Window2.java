import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window2 extends JFrame implements ActionListener{
    private Container pane;

    private JButton CtoF, FtoC;
    private JTextField t;
 
    //CONSTRUCTOR SETS EVERYTHING UP
    public Window2() {
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
	CtoF = new JButton("Convert to Fahrenheit");
       	FtoC = new JButton("Convert to Celsius");
	t = new JTextField(12);
	pane.add(CtoF);
	pane.add(FtoC);
	pane.add(t);
    }

    public void actionPerformed(ActionEvent e){
	String s = e.getActionperformed;
	if(s.equals("Convert to Celsius")){
	    t.setText("" + Temp.FtoC((double) t.getText()));
	}
	if(s.equals("Convert to Fahrenheit")){
	    t.setText("" + Temp.CtoF((double) t.getText()));
	}
    }

    public static double CtoF(double t){
	return (t*1.8) + 32;
    }

    public static double FtoC(double t){
	return ((t - 32)* 5) / 9;
    }

    
    //MAIN JUST INSTANTIATES + MAKE VISIBLE
    public static void main(String[] args) {
	Window2 g = new Window2();
	g.setVisible(true);
    }
}
