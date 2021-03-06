import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * 
 * @author Nathanael Reese
 * @version 1.0
 * Driver for the Random Color Generator.
 *
 */
public class Driver {
	/**
	 * Runs the code for the application.
	 * 
	 * @param args Strings of code inside the main method.
	 */
	public static void main(String[] args) {
		App app = new App(); //creating app instance
		app.launch(); //launching the splash applicaton

	    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminates program on close
	    app.pack(); //making program look good
	    app.setVisible(true); //setting application visible
	}

}
