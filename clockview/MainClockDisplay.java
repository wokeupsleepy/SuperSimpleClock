package clockview;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JFrame;

import clocklogic.*;

//contains code joining JLabels into a JFrame and displaying clock inside clock label
//also contains main method

//ideas for future improvements:
//darken the text after a set period of time
//include some code where you can't close the window until you input a keyboard command/password
//have the keyboard command be a randomly generated string of words
//include code to allow the user to change certain settings (play custom .wav file for alarm)
//make this with JavaFX
//finish doing this for now to get used to using ActionListeners and whatnot, work on music player later
//experiment with images, this could be useful for graphic work later

public class MainClockDisplay extends JFrame {
	
	private ClockLabel mainClockLabel = new ClockLabel();
	private ClockLabel titleCard = new ClockLabel();
	private ClockLabel alarmLabel = new ClockLabel();
	private AlarmInputButton alarmInput = new AlarmInputButton();
	
	public static Font clockFont = new Font("Verdana", Font.PLAIN, 24); //check this to change color gradually
	
	private ClockUpdater updatePrime;
	private Timer updater;
	
	private int currHour;
	private int currMin;
	private int currSec;

	public MainClockDisplay() {
		super("Sleepy Time Alarm Clock by Tom");
		add(titleCard);
		add(mainClockLabel);
		add(alarmInput);
		add(alarmLabel);
		
		mainClockLabel.setFont(new Font("Verdana", Font.PLAIN, 75));
		titleCard.setText("<html>Sleepy Time Alarm Clock<br>by Tom</html>");
		setLayout(new GridLayout(2,2));
		updatePrime = new ClockUpdater();
		updater = new Timer(500, updatePrime); //sets a timer that can be used to repeat an action (check javadocs for swing.Timer)
		updater.start(); //updater checks updatePrime every 500 milliseconds
		
		//ClockUpdater's actionPerformed resets mainClockLabel's text with the new time
		//updater.addActionListener(firstAlarm); if I set this, then it sets off firstAlarm
			//rework AlarmTester to change eventInput if and else if statements, include more logic flows
	}
	
	public static String clockFaceDisplay(int timeInput) {
		//if timeInput is a single digit n, clockFaceDisplay converts it into a string that is "0n"
		//ex. currHour = 9, cFaceDispl(currHour) = "09"
		String output = "";
		
		if(timeInput < 10) {
			output = "0" + Integer.toString(timeInput);
		}
		else {
			output = Integer.toString(timeInput);
		}
		
		return output;
	}
	
	private class ClockUpdater implements ActionListener {
		
		public void actionPerformed(ActionEvent eventInput) {			
			if(eventInput.getSource() == updater) { //basically, if updater adds a ClockUpdater, this starts up and keeps looping over
				PrimeClock whereTimeIs = new PrimeClock();
				currHour = whereTimeIs.getCurrHour();
				currMin = whereTimeIs.getCurrMin();
				currSec = whereTimeIs.getCurrSec();
				
				mainClockLabel.setText(clockFaceDisplay(whereTimeIs.getCurrHour()) + ":" 
				+ clockFaceDisplay(whereTimeIs.getCurrMin()) + ":" + clockFaceDisplay(whereTimeIs.getCurrSec()));
				
				if(alarmInput.getAlarmData() == null) {
					alarmLabel.setText("The alarm is set to... null");
				}
				
				else {
					alarmLabel.setText("The alarm is set to... " + clockFaceDisplay(alarmInput.getAlmInHour()) + ":"
						+ clockFaceDisplay(alarmInput.getAlmInMin()) + ":" + clockFaceDisplay(alarmInput.getAlmInSec()));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		MainClockDisplay alpher = new MainClockDisplay();
		alpher.pack();
		alpher.setVisible(true);
	    alpher.setExtendedState(alpher.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		alpher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//it works now. add wav play functionality
	}
	
}