// Code and notes for chapter 17 reading
// Use SWING package instead of AWT(abstract window toolkit)
// GUI is used un event driven programming 
// the sending of an evnet is called "firing the event"
// // the oject that fires the event is often a GUI component such as a 
// // button that has been clicked  
// Listeners - A listener object poerforms some action in response to the
// // event 
// // Each listener may respond to a different kind of event, or multiple 
// // listeners might may repond to the same evernts 
// ex of GUI
import java.swing.Jframe;
import java.swing.JButton;

public class FirstSwingDemo {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    
    public static void main (String[] args) {
        JFrame firstWindow = new JFrame();
        firstWindow.setSize(WIDTH, HEIGHT);
        firstWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JButton endButton = new JButton("Click to end program.");
        EndingListener buttonEar = new EndingListener();
        endButton.addActionListener(buttonEar);
        firstWindow.odd(endBUtton):

	firstWindow.setVisible(true);
    }
}
