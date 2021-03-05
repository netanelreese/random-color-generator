import java.awt.event.ActionEvent;

import javax.swing.*;


public class Driver extends JFrame {

	public static void main(String[] args) {
		App app = new App();
		app.launch();

	    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    app.pack();
	    app.setVisible(true);
	}

}
