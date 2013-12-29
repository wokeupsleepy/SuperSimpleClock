package clocklogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ClockAlarm {
	
	private int currHour;
	private int currMin;
	private int currSec;
	
	private static int setoffHour; //using static setoff time values may prevent the use of multiple alarms at a time, investigate later
	private static int setoffMin;
	private static int setoffSec;
	
	private Timer alarmCheck;
	private Ticker alarmSetup;
	private Timer freshAlarm;
	
	//the constructor's really the only important bit here, everything else supports it
	public ClockAlarm(int hourInput, int minInput, int secInput) {
		setoffHour = hourInput;
		setoffMin = minInput;
		setoffSec = secInput;
		alarmSetup = new Ticker();
		alarmCheck = new Timer(500, alarmSetup);
		alarmCheck.start();
		
		AlarmAction alarmer = new AlarmAction();
		freshAlarm = new Timer(500, alarmer);
		freshAlarm.start();
	}
	
	public class AlarmAction implements ActionListener {
		
		public void actionPerformed(ActionEvent eventInput) {
			if(eventInput.getSource() == freshAlarm) {
				if(currHour == setoffHour && currMin == setoffMin && currSec == setoffSec) {
					JOptionPane.showMessageDialog(null, "The alarm has been released!"); //this is the alarm action, change how you please
				}
			}
		}
	}
	
	private class Ticker implements ActionListener {
		
		public void actionPerformed(ActionEvent eventInput) {			
			if(eventInput.getSource() == alarmCheck) { //basically, if alarmCheck adds a Ticker, this starts up and keeps looping over
				PrimeClock timeSource = new PrimeClock();
				currHour = timeSource.getCurrHour();
				currMin = timeSource.getCurrMin();
				currSec = timeSource.getCurrSec();
			}
		}
		
	}	
	
	public static int getSetoffHour() {
		return setoffHour;
	}

	public static int getSetoffMin() {
		return setoffMin;
	}

	public static int getSetoffSec() {
		return setoffSec;
	}
	
}

