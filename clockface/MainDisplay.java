package clockface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.Timer;
import javax.swing.JFrame;

import clock.*;

public class MainDisplay extends JFrame {
	
	CurrentTimeLabel mainClock = new CurrentTimeLabel();
	TitleCard titleCard = new TitleCard();

	public MainDisplay() {
		super("Sleepy Time Clock by wokeupsleepy");
		add(titleCard);
		add(mainClock);
		setLayout(new GridLayout(2,1));
		Timer updater = new Timer(500, new ClockUpdater()); //sets a timer that can be used to repeat an action (check javadocs for swing.Timer)
		updater.start(); //updater checks dateSource every 500 milliseconds, UpdateListener resets mainClock's text with the new time
	}
	
	private class ClockUpdater implements ActionListener { //no event input specified, so apparently it continues to play?
		
		public void actionPerformed(ActionEvent eventInput) {
			DateFormat dateSource = DateFormat.getTimeInstance();
			mainClock.setText(dateSource.format(new Date()));

		}
		
	}
	
	public static void main(String[] args) {
		MainDisplay alpher = new MainDisplay();
		alpher.setVisible(true);
		alpher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alpher.setSize(650, 500);
	}
	
	//ideas for future improvements:
	//implement an alarm that plays a wav file
	//darken the text after a set period of time
	//make this with JavaFX
	//finish doing this for now to get used to using ActionListeners and whatnot, work on music player later
	//experiment with images, this will be useful for graphic simulations
	
}