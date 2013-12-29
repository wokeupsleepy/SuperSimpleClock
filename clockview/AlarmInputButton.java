package clockview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import clocklogic.ClockAlarm;

public class AlarmInputButton extends JButton {
	
	private AlmBtnListener btnListener = new AlmBtnListener();

	private static int almInHour;
	private static int almInMin;
	private static int almInSec;
	
	public AlarmInputButton() {
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setFont(new Font("Verdana", Font.BOLD,16));
		setText("Click Here to Set Alarm");
		addActionListener(btnListener);
	}
	
	public static ClockAlarm setAlarm() {
		ClockAlarm klaxon = new ClockAlarm(almInHour, almInMin, almInSec);
		return klaxon;
	}
	
	public class AlmBtnListener implements ActionListener {
		
		public void actionPerformed(ActionEvent eventInput) {
			String alarmData = JOptionPane.showInputDialog(null, "Enter alarm in the format(HH:MM:SS): ");
			almInHour = Integer.parseInt(alarmData.substring(0, 2));
			almInMin = Integer.parseInt(alarmData.substring(3, 5));
			almInSec = Integer.parseInt(alarmData.substring(6, 8));
			
			setAlarm();
			
//			System.out.println(AlarmInputButton.getAlmInHour()); //check the same methods at the bottom of the main method in MainClockDisplay
//			System.out.println(AlarmInputButton.getAlmInMin()); //those methods output 0s across the board
//			System.out.println(AlarmInputButton.getAlmInSec()); //the reason is because the initialization statements are in this loop
		}
	}
	
	public String getAlarmTime() {
		String output = Integer.toString(almInHour) + Integer.toString(almInMin) + Integer.toString(almInSec);
		
		return output;
	}

	public static int getAlmInHour() {
		return almInHour;
	}

	public static int getAlmInMin() {
		return almInMin;
	}

	public static int getAlmInSec() {
		return almInSec;
	}
	
	

}