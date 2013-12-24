package clockview;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JFrame;

import clocklogic.*;

//contains code joining JLabels into a JFrame and displaying clock inside clock label
public class MainClockDisplay extends JFrame {
	
	CurrentTimeLabel mainClockLabel = new CurrentTimeLabel();
	TitleCard titleCard = new TitleCard();
	ClockUpdater updatePrime;
	Timer updater;

	int currHour;
	int currMin;
	int currSec;

	String civvieTime;
	boolean isMilitaryTime = true;
	
	private String cFaceDispl(int timeInput) {
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

	public MainClockDisplay() {
		super("Sleepy Time Clock by wokeupsleepy");
		add(titleCard);
		add(mainClockLabel);
		setLayout(new GridLayout(2,1));
		updatePrime = new ClockUpdater();
		updater = new Timer(500, updatePrime); //sets a timer that can be used to repeat an action (check javadocs for swing.Timer)
		updater.start(); //updater checks updatePrime every 500 milliseconds
		
		//ClockUpdater's actionPerformed resets mainClockLabel's text with the new time
		
		
		//updater.addActionListener(firstAlarm); if I set this, then it sets off firstAlarm
			//rework AlarmTester to change eventInput if and else if statements, include more logic flows
	}
	
	private class ClockUpdater implements ActionListener {
		
		public void actionPerformed(ActionEvent eventInput) {			
			if(eventInput.getSource() == updater) { //basically, if updater adds a ClockUpdater, this starts up and keeps looping over
				PrimeClock whereTimeIs = new PrimeClock();
				currHour = whereTimeIs.getCurrHour();
				currMin = whereTimeIs.getCurrMin();
				currSec = whereTimeIs.getCurrSec();
				
				mainClockLabel.setText(cFaceDispl(whereTimeIs.getCurrHour()) + ":" + cFaceDispl(whereTimeIs.getCurrMin()) + ":" + cFaceDispl(whereTimeIs.getCurrSec()));
			}
		}
		
	}
	
	public static void main(String[] args) {
		MainClockDisplay alpher = new MainClockDisplay();
		alpher.setVisible(true);
		alpher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alpher.setSize(650, 500);
		
		ClockAlarm beta = new ClockAlarm(11, 33, 50);
		
	}
	
	//ideas for future improvements:
	//implement an alarm that plays a wav file
	//darken the text after a set period of time
	//make this with JavaFX
	//finish doing this for now to get used to using ActionListeners and whatnot, work on music player later
	//experiment with images, this will be useful for graphic simulations
	
}