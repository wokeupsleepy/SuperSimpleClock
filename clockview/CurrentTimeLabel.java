package clockview;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

//contains code detailing the appearance of the JLabel holding the clock
public class CurrentTimeLabel extends JLabel {	

	public CurrentTimeLabel() {
		setHorizontalAlignment(JLabel.CENTER);
		setOpaque(true);
		setBackground(Color.black);
		setForeground(Color.white);
		setFont(new Font("Verdana", Font.BOLD,16));
	}
	

	
	

}