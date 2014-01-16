package clockview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import clocklogic.ClockAlarm;

//this handles the appearance of the button to input an alarm time along with an input window to put in a time
//future improvements: impose limits on inputs (use if loops), add a secondary button to set a remembered time
//explanation for the use of input string: It's simply faster than using drop-down menus (a wheel would be cool)

public class AlarmInputButton extends JButton {
	
	private AlmBtnListener btnListener = new AlmBtnListener();

	private int alarmInHour; //user input for setting the alarm
	private int alarmInMin;
	private int alarmInSec;
	private boolean validAlarmYes = false;
	
	private static String alarmData; //used in MainClockDisplay to check against current time to see if the alarm goes off
	
	public AlarmInputButton() {
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setFont(MainClockDisplay.clockFont);
		setText("Click Here to Set Alarm");
		addActionListener(btnListener);
	}
	
	private ClockAlarm setAlarm() { //creates a new alarm! hurray!
		ClockAlarm klaxon = new ClockAlarm(alarmInHour, alarmInMin, alarmInSec);
		return klaxon;
	}
	
	public class AlmBtnListener implements ActionListener {
		
		public void actionPerformed(ActionEvent eventInput) {
			alarmData = JOptionPane.showInputDialog(null, "Enter alarm in the format(HH:MM:SS): ");
			alarmInHour = Integer.parseInt(alarmData.substring(0, 2));
			alarmInMin = Integer.parseInt(alarmData.substring(3, 5));
			alarmInSec = Integer.parseInt(alarmData.substring(6, 8));
			
			if(alarmInHour >= 0 && alarmInMin >= 0 && alarmInSec >= 0 &&
					alarmInHour <= 24 && alarmInMin <= 60 && alarmInSec <= 60) {
				setAlarm();
				validAlarmYes = true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid alarm input, please re-submit");
				validAlarmYes = false;
			}
		}
	}
	
	public static String getAlarmData() {
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
