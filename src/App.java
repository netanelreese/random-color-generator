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

public class App extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6432587278844995877L;
	final String GENERATE_LABEL = "Generate";
	final String GENERATE_RANDOM_LABEL = "Generate Random";
	final String INPUT_LABEL = "Input color (rgb):";
	final int MAXIMUM_VAL = 255;
	final int MINIMUM_VAL = 0;
	JLabel InputRGB;
	JTextField red;
	JTextField green;
	JTextField blue;
	JButton generate;
	JButton generateRandom;
	private int redVal;
	private int blueVal;
	private int greenVal;
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
		String redText = red.getText();
		String greenText = green.getText();
		String blueText = blue.getText();
		
		System.out.println(redText + " " + greenText + " " + blueText);
		
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
