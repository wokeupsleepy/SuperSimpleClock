package clockview;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import clocklogic.ClockAlarm;

//this handles the appearance of the button to input an alarm time along with an input window to put in a time
//future improvements: impose limits on inputs (use if loops), add a secondary button to set a remembered time
//explanation for the use of input string: It's simply faster than using drop-down menus (a wheel would be cool)
//however, with this we're going with functionality over looks

public class AlarmInputButton extends JButton {
	
	private AlarmButtonListener buttonListener = new AlarmButtonListener();

	private int alarmInHour; //user input for setting the alarm
	private int alarmInMin;
	private int alarmInSec;
	private boolean validAlarmYes = false;
	
	private String alarmData; //used in MainClockDisplay to check against current time to see if the alarm goes off
	
	public AlarmInputButton() {
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setFont(MainClockDisplay.clockFont);
		setText("Click Here to Set Alarm");
		addActionListener(buttonListener);
	}
	
	private ClockAlarm setAlarm() { //creates a new alarm! hurray!
		ClockAlarm klaxon = new ClockAlarm(alarmInHour, alarmInMin, alarmInSec);
		return klaxon;
	}
	
	private boolean checkValidClockInput (String inputAlarmData) {
		//this ugly method checks alarmData to make sure it's using a valid 24-hour clock input (HHMMSS)
		//assume input string length of 6 for this, look at assignment of alarmData in AlmBtnListener
		if(Integer.parseInt(inputAlarmData.substring(0, 2)) >= 0 &&
				Integer.parseInt(inputAlarmData.substring(0, 2)) <= 24 &&
				Integer.parseInt(inputAlarmData.substring(2, 4)) >= 0 &&
				Integer.parseInt(inputAlarmData.substring(2, 4)) <= 60 &&
				Integer.parseInt(inputAlarmData.substring(4, 6)) >= 0 &&
				Integer.parseInt(inputAlarmData.substring(4, 6)) <= 60) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public class AlarmButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent eventInput) {
			alarmData = JOptionPane.showInputDialog(null, "Enter alarm in the format(HHMMSS): ");
			
			if(alarmData.length() != 6 || checkValidClockInput(alarmData) == false) {
				alarmData = null;
				JOptionPane.showMessageDialog(null, "Invalid input, re-enter input");
				new AlarmButtonListener();
			}
			
			else {
				alarmInHour = Integer.parseInt(alarmData.substring(0, 2));
				alarmInMin = Integer.parseInt(alarmData.substring(2, 4));
				alarmInSec = Integer.parseInt(alarmData.substring(4, 6));
				setAlarm();
				validAlarmYes = true;
			}

		}
	}
	
	public String getAlarmData() {
		return alarmData;
	}
	

	public int getAlmInHour() {
		return alarmInHour;
	}

	public int getAlmInMin() {
		return alarmInMin;
	}

	public int getAlmInSec() {
		return alarmInSec;
	}

	public boolean isValidAlarmYes() {
		return validAlarmYes;
	}

	public void setValidAlarmYes(boolean validAlarmYes) {
		this.validAlarmYes = validAlarmYes;
	}
	
	

}
