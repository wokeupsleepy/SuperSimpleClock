package clock;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class CurrentTimeLabel extends JLabel {	

	public CurrentTimeLabel() {
		setHorizontalAlignment(JLabel.CENTER);
		setOpaque(true);
		setBackground(Color.black);
		setForeground(Color.white);
		setFont(new Font("Verdana", Font.BOLD,16));
	}
	

	
	

}