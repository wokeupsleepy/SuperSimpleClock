package clockface;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

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
