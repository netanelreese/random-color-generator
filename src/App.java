import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;
/**
 * Application code for the random color generator. Extends the JFrame class and implements the ActionListener class(?).
 * 
 * @author Nathanael Reese
 * @version 1.0
 *
 */
public class App extends JFrame implements ActionListener{
	/**
	 * Serial number for the application.
	 */
	private static final long serialVersionUID = 6432587278844995877L;
	/**
	 * String constant for the JButton member, generate.
	 */
	final String GENERATE_LABEL = "Generate";
	/**
	 * String constant for the JButton member, generateRandom.
	 */
	final String GENERATE_RANDOM_LABEL = "Generate Random";
	/**
	 * String constant for the JLabel member, InputRGB.
	 */
	final String INPUT_LABEL = "Input color (rgb):";
	/**
	 * Maximum value for an rgb variable.
	 */
	final int MAXIMUM_VAL = 255;
	/**
	 * Minimum value for an rgb variable.
	 */
	final int MINIMUM_VAL = 0;
	/**
	 * JLabel to prompt user to input an rgb value.
	 */
	JLabel InputRGB;
	/**
	 * Text field for user to input red value.
	 */
	JTextField red;
	/**
	 * Text field for user to input green value.
	 */
	JTextField green;
	/**
	 * Text field for user to input blue value.
	 */
	JTextField blue;
	/**
	 * Button to generate color of user's choice
	 */
	JButton generate;
	/**
	 * Button to generate random color.
	 */
	JButton generateRandom;
	/**
	 * Variable for red value of rgb.
	 */
	private int redVal;
	/**
	 * Variable for blue value of rgb.
	 */
	private int blueVal;
	/**
	 * Variable for green value of rgb.
	 */
	private int greenVal;
	/**
	 * Color value for user or random input.
	 */
	private Color color;
	
	public void launch() {
		setTitle("Random Color Generator");
		
		JLabel InputRGB = new JLabel(INPUT_LABEL);
		red = new JTextField("0");
		green = new JTextField("0");
		blue = new JTextField("0");
		JButton generate = new JButton(GENERATE_LABEL);
		JButton generateRandom = new JButton(GENERATE_RANDOM_LABEL);
		
		Font labelFont = new Font("Comic Sans", Font.BOLD, 14);
		
		InputRGB.setFont(labelFont);
		InputRGB.setForeground(Color.WHITE);
		
		setPreferredSize(new Dimension(400, 400));
	    setLayout(new GridBagLayout());
	    GridBagConstraints positionConst = new GridBagConstraints();
		getContentPane().setBackground(new Color(128, 0, 32));

	    
		
		red.setPreferredSize(new Dimension(40, 25));
		green.setPreferredSize(new Dimension(40, 25));
		blue.setPreferredSize(new Dimension(40, 25));
		
		
		System.out.println(blueVal + redVal + greenVal);
		
		
		generate.addActionListener(this);
		generateRandom.addActionListener(this);
		
		positionConst.insets = new Insets(5, 5, 5, 5);
	    positionConst.gridx = 0;
	    positionConst.gridy = 0;
	    add(InputRGB, positionConst);
	    
	    positionConst.gridx = 1;
	    positionConst.gridy = 0;
	    add(red, positionConst);
	    
	    positionConst.gridx = 2;
	    positionConst.gridy = 0;
	    add(green, positionConst);
	    
	    positionConst.gridx = 3;
	    positionConst.gridy = 0;
	    add(blue, positionConst);
	    
	    positionConst.gridx = 2;
	    positionConst.gridy = 1;
	    add(generate, positionConst);
	    
	    positionConst.gridx = 2;
	    positionConst.gridy = 2;
	    add(generateRandom, positionConst);
	    
	    pack();	
	}
	public void launchPopUp() {
		JFrame colorFrame = new JFrame("Color - r: " + redVal + " g: " + greenVal + " b: " + blueVal);
		colorFrame.setPreferredSize(new Dimension(500, 500));
		colorFrame.getContentPane().setBackground(color);
	    colorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    colorFrame.pack();
	    colorFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO: FIX RANDOM COLOR GENERATOR ON BUTTON PRESS
		String redText = red.getText();
		String greenText = green.getText();
		String blueText = blue.getText();
				
		if(redText != null || blueText != null || greenText != null) {
			redVal = Integer.parseInt(red.getText()); //parsing input value
			greenVal = Integer.parseInt(green.getText());
			blueVal = Integer.parseInt(blue.getText());
			
			//if input is greater than 255 or less than 0 show error popup
			if (redVal < 0 || redVal > 255) {
				JOptionPane.showMessageDialog(this, "Invalid red value", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if (greenVal < 0 || greenVal > 255) {
				JOptionPane.showMessageDialog(this, "Invalid green value", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if (blueVal < 0 || blueVal > 255) {
				JOptionPane.showMessageDialog(this, "Invalid blue value", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
			color = new Color(redVal, greenVal, blueVal); //else make color value
			launchPopUp();
			}
		}
		else {
			redVal = ThreadLocalRandom.current().nextInt(MINIMUM_VAL, MAXIMUM_VAL + 1);
			blueVal = ThreadLocalRandom.current().nextInt(MINIMUM_VAL, MAXIMUM_VAL + 1);
			greenVal = ThreadLocalRandom.current().nextInt(MINIMUM_VAL, MAXIMUM_VAL + 1);
			color = new Color(redVal, greenVal, blueVal);
			launchPopUp();
		}
	}
}
