//package chpt17;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;  // This is the file EndingListener

class chpt17 {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    
    public static void main (String[] args) {
        // This is example 17.2
        //
        // JFrame firstWindow = new JFrame();
        // firstWindow.setSize(WIDTH, HEIGHT);
        // firstWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // JButton endButton = new JButton("Click to end program.");
        // EndingListener buttonEar = new EndingListener();
        // endButton.addActionListener(buttonEar);
        // firstWindow.add(endButton);
	    // firstWindow.setVisible(true);

        // This is example 17.4
        //
        FirstWindow w = new FirstWindow();
        w.setVisible(true);

        ColoredWindow w1 = new ColoredWindow();
        w1.setVisible(true);

        ColoredWindow w2 = new ColoredWindow();
        w2.setVisible(true);

    }
    
}
class FirstWindow extends JFrame{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    public FirstWindow() {
        super();
        setSize(WIDTH, HEIGHT);

        setTitle("Did this clss work");
        setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
        

        // YOu can only have one at a time?? How can you add both functions? Do you need to create a whole new class for every new button/label?
        // The last J(add) is prioritized
        // Adds greeting 
        JLabel greeting = new JLabel("THis is a new label");
        add(greeting);

        // Adds exit button
        JButton endButton = new JButton("Click to send it.");
        endButton.addActionListener(new EndingListener());
        add(endButton);

    }
}

class ColoredWindow extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    public ColoredWindow(Color theColor) {
        super("No charge for the color");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(theColor);
        JLabel aLabel = new JLabel("CLose-window button works.");
        add(aLabel);
    }

    public ColoredWindow() {
        this(Color.PINK);
    }
}
    
class EndingListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}