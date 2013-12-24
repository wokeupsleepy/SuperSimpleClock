package clockview;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

//contains code detailing the look of the JLabel holding the title
public class TitleCard extends JLabel {
	
	public TitleCard() {
		setHorizontalAlignment(JLabel.CENTER);
		setOpaque(true);
		setBackground(Color.black);
		setForeground(Color.white);
		setFont(new Font("Verdana", Font.BOLD,16));
		setText("Sleepy Time Clock");
	}

}
