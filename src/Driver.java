import java.awt.event.ActionEvent;

import javax.swing.*;


public class Driver {

	public static void main(String[] args) {
		App app = new App(); //creating app instance
		app.launch(); //launching the splash applicaton

	    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminates program on close
	    app.pack(); //making program look good
	    app.setVisible(true); //setting application visible
	}

}
