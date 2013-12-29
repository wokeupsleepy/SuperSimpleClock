package clockview;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JFrame;

import clocklogic.*;

//contains code joining JLabels into a JFrame and displaying clock inside clock label
//also contains main method

//ideas for future improvements:
//implement an alarm that plays a wav file
//darken the text after a set period of time
//include some code where you can't close the window until you input a keyboard command/password
//have the keyboard command be a randomly generated string of words, this prevents
//include code to allow the user to change certain settings (play custom .wav file for alarm)
//make this with JavaFX
//finish doing this for now to get used to using ActionListeners and whatnot, work on music player later
//experiment with images, this will be useful for graphic simulations

public class MainClockDisplay extends JFrame {
	
	private ClockLabel mainClockLabel = new ClockLabel();
	private ClockLabel titleCard = new ClockLabel();
	private ClockLabel alarmLabel = new ClockLabel();
	private AlarmInputButton alarmInput = new AlarmInputButton();
	
	private ClockUpdater updatePrime;
	private Timer updater;
	
	private String alarmInfo = new String("nothing here for now, fix later");

	private int currHour;
	private int currMin;
	private int currSec;
	private String civvieTime;
	private boolean isMilitaryTime = true;

	public MainClockDisplay() {
		super("Sleepy Time Alarm Clock by Tom");
		add(titleCard);
		add(mainClockLabel);
		add(alarmLabel);
		add(alarmInput);
		titleCard.setText("<html>Sleepy Time Alarm Clock<br>by Tom</html>");
		setLayout(new GridLayout(4,1));
		updatePrime = new ClockUpdater();
		updater = new Timer(500, updatePrime); //sets a timer that can be used to repeat an action (check javadocs for swing.Timer)
		updater.start(); //updater checks updatePrime every 500 milliseconds
		
		//ClockUpdater's actionPerformed resets mainClockLabel's text with the new time
		//updater.addActionListener(firstAlarm); if I set this, then it sets off firstAlarm
			//rework AlarmTester to change eventInput if and else if statements, include more logic flows
	}
	
	public static String cFaceDispl(int timeInput) {
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
				
				mainClockLabel.setText(cFaceDispl(whereTimeIs.getCurrHour()) + ":" 
				+ cFaceDispl(whereTimeIs.getCurrMin()) + ":" + cFaceDispl(whereTimeIs.getCurrSec()));
				
				alarmLabel.setText("The alarm is set to " + AlarmInputButton.getAlarmData());
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		MainClockDisplay alpher = new MainClockDisplay();
		alpher.setVisible(true);
		alpher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alpher.setSize(650, 500);
		
		//it works now. add wav play functionality
	}
	
}