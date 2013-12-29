package clockview;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

//contains code detailing the appearance of each part of the clock
public class ClockLabel extends JLabel {	

	public ClockLabel() {
		setHorizontalAlignment(JLabel.CENTER);
		setOpaque(true);
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setFont(new Font("Verdana", Font.BOLD,16));
	}

}