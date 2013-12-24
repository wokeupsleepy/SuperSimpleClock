package clocklogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ClockAlarm {
	
	int alarmHour;
	int alarmMin;
	int alarmSec;
	Timer alarmCheck;
	Ticker alarmSetup;
	Timer freshAlarm;

	//the constructor's really the only important bit here, everything else supports it
	public ClockAlarm(int hourInput, int minInput, int secInput) {
		alarmSetup = new Ticker();
		alarmCheck = new Timer(500, alarmSetup);
		alarmCheck.start();
		
		AlarmAction alarmer = new AlarmAction(hourInput, minInput, secInput);
		freshAlarm = new Timer(500, alarmer);
		freshAlarm.start();
	}
	
	private class AlarmAction implements ActionListener {
		
		int setoffHour;
		int setoffMin;
		int setoffSec;
		
		public AlarmAction(int hourInput, int minInput, int secInput) {
			setoffHour = hourInput;
			setoffMin = minInput;
			setoffSec = secInput;
		}
		
		public void actionPerformed(ActionEvent eventInput) {
			if(eventInput.getSource() == freshAlarm) {
				if(alarmHour == setoffHour && alarmMin == setoffMin && alarmSec == setoffSec) {
					JOptionPane.showMessageDialog(null, "The alarm has been released!"); //this is the alarm action, change how you please
				}
			}
		}
	}
	
	private class Ticker implements ActionListener {
		
		public void actionPerformed(ActionEvent eventInput) {			
			if(eventInput.getSource() == alarmCheck) { //basically, if alarmCheck adds a Ticker, this starts up and keeps looping over
				PrimeClock timeSource = new PrimeClock();
				alarmHour = timeSource.getCurrHour();
				alarmMin = timeSource.getCurrMin();
				alarmSec = timeSource.getCurrSec();				
			}
		}
		
	}

}
