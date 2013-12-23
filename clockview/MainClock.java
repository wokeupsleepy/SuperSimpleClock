package clockview;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JFrame;

public class MainClock extends JFrame {
	
	CurrentTimeLabel mainClockLabel = new CurrentTimeLabel();
	TitleCard titleCard = new TitleCard();
	ClockUpdater updatePrime;
	Timer updater;
	AlarmTester firstAlarm;
	Calendar timeSource;
	int currHour;
	int currMin;
	int currSec;
	

	public MainClock() {
		super("Sleepy Time Clock by wokeupsleepy");
		add(titleCard);
		add(mainClockLabel);
		setLayout(new GridLayout(2,1));
		updatePrime = new ClockUpdater();
		firstAlarm = new AlarmTester();
		updater = new Timer(500, updatePrime); //sets a timer that can be used to repeat an action (check javadocs for swing.Timer)
		updater.start(); //updater checks updatePrime every 500 milliseconds
		updater.addActionListener(firstAlarm);
		//ClockUpdater's actionPerformed resets mainClockLabel's text with the new time
		
		
		//updater.addActionListener(firstAlarm); if I set this, then it sets off firstAlarm
			//rework AlarmTester to change eventInput if and else if statements, include more logic flows
	}
	
	private class ClockUpdater implements ActionListener { //no event input specified, so apparently it continues to play?
		
		public void actionPerformed(ActionEvent eventInput) {			
			if(eventInput.getSource() == updater) {				
				timeSource = Calendar.getInstance();
				
				currHour = timeSource.get(Calendar.HOUR_OF_DAY);
				currMin = timeSource.get(Calendar.MINUTE);
				currSec = timeSource.get(Calendar.SECOND);
				
				mainClockLabel.setText(currHour + ":" + currMin + ":" + currSec);
			}
		}
		
	}
	
	private class AlarmTester implements ActionListener{
		
		public void actionPerformed(ActionEvent eventInput) {
			if(eventInput.getSource() == updater) {
				if(currMin == 15 && currSec == 10) {
					JOptionPane.showMessageDialog(null, "THE FIVE SECOND TIMER WORKED");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MainClock alpher = new MainClock();
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